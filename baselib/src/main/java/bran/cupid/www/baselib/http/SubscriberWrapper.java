package bran.cupid.www.baselib.http;

import android.util.Log;

import org.reactivestreams.Subscription;

import java.net.NoRouteToHostException;

import bran.cupid.www.baselib.util.BaseUtils;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.NonNull;
import retrofit2.HttpException;

public class SubscriberWrapper<T> implements FlowableSubscriber<T> {

    private static final String TAG = "SubscriberWrapper";

    public static final String ERR_NETWORK_MSG = "请求数据失败";
    public static final String TOKEN_ERR = "用户在别处登录,请重新登录";
    private static final String NET_WORK_ERROR = "网络错误";
    private static final String CONNECT_TIME_OUT = "连接超时";
    public static int ERR_NETWORK_CODE = -100;
    public static int ERR_SEVER_CODE = -200;
    public boolean jumpLogin = true;

    private CallBackListener<T> callBackListener;
    private CodeInterceptor<T> codeInterceptor;

    public SubscriberWrapper(CallBackListener<T> callBackListener) {
        this.callBackListener = callBackListener;
        codeInterceptor = new CodeInterceptor<>();
    }

    public SubscriberWrapper(boolean jumpLogin, CallBackListener<T> callBackListener) {
        this.jumpLogin = jumpLogin;
        this.callBackListener = callBackListener;
        codeInterceptor = new CodeInterceptor<>();
    }

    @Override
    public void onSubscribe(@NonNull Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T t) {
        codeInterceptor.intercept(callBackListener,t);
    }

    @Override
    public void onError(Throwable ex) {

        if (ex != null) {
            Log.e(TAG, Log.getStackTraceString(ex));
        }

        if (ex instanceof HttpException) {
            //网络错误
            HttpException httpEx = (HttpException) ex;
            int code = httpEx.code();
            callBackListener.onFailed(ex, code+"", NET_WORK_ERROR);
            return;
        } else if (ex instanceof NoRouteToHostException){
            //网络错误
            NoRouteToHostException httpEx = (NoRouteToHostException) ex;
            Throwable throwable = httpEx.getCause();
            callBackListener.onFailed(throwable, "", NET_WORK_ERROR);
        } else if (!BaseUtils.checkNet()) {
            callBackListener.onError(ERR_NETWORK_CODE);
            return;
        } else {
            callBackListener.onFailed(null,CONNECT_TIME_OUT,CONNECT_TIME_OUT);
            return;
        }
    }

    @Override
    public void onComplete() {

    }

    public interface CallBackListener<T> {
        void onSuccess(String code, T data, String msg, String desc);

        void onFailed(Throwable ex, String code, String msg);

        void onError(int code);
    }
}
