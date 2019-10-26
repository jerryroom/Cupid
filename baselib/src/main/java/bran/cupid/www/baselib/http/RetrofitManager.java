package bran.cupid.www.baselib.http;

import java.util.concurrent.TimeUnit;

import bran.cupid.www.baselib.Api;
import bran.cupid.www.baselib.Constant;
import bran.cupid.www.baselib.util.LogUtils;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者: bran
 * 日期: 2019/10/26 0026
 * 描述：
 */
public class RetrofitManager {
    private static final String TAG = "RetrofitManager";
    private OkHttpClient client;
    private OkHttpClient.Builder builder;

    private RetrofitManager() {
        builder = new OkHttpClient.Builder();
        builder.addInterceptor(new TokenInterceptor());
        builder.addInterceptor(new LoggingInterceptor());
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(message -> LogUtils.e(TAG, "HttpLoggingInterceptor====: " + message));
        builder.addInterceptor(interceptor);
        builder.connectTimeout(1, TimeUnit.SECONDS);
        client = builder.build();
    }

    public Api getApi() {
        return createRetrofit(client, Constant.BASE_URL).create(Api.class);
    }

    private Retrofit createRetrofit(OkHttpClient client, String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static RetrofitManager getInstance() {
        return RetrofitProvider.retrofitManager;
    }

    private static class RetrofitProvider {
        private static RetrofitManager retrofitManager = new RetrofitManager();
    }

    public static <T> FlowableTransformer<T, T> rxSchedulerHelper() {
        return upstream -> upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
