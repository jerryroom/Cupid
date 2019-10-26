package bran.cupid.www.baselib.mvp;

import bran.cupid.www.baselib.http.RetrofitManager;
import bran.cupid.www.baselib.http.SubscriberWrapper;
import bran.cupid.www.baselib.module.req.LoginReq;
import bran.cupid.www.baselib.module.rsp.LoginRsp;
import bran.cupid.www.baselib.util.LogUtils;

/**
 * 作者: bran
 * 日期: 2019/10/26 0026
 * 描述：
 */
public class PresenterImp extends BasePresenter implements GlobalContract.GlobalPreenter {
    private static final String TAG = "PresenterImp";

    @Override
    public void onLogin(LoginReq req, GlobalContract.LoginView loginView) {
        attachView(loginView);
        loginView.loading();
        LogUtils.toJson(TAG, req.toString());
        mApi.login(req).compose(RetrofitManager.rxSchedulerHelper()).subscribe(new SubscriberWrapper<LoginRsp>(new SubscriberWrapper.CallBackListener<LoginRsp>() {
            @Override
            public void onSuccess(String code, LoginRsp data, String msg, String desc) {
                if (loginView != null) {
                    loginView.onLoginSuc(code, data, msg, desc);
                    loginView.cancelLoading();
                }
            }

            @Override
            public void onFailed(Throwable ex, String code, String msg) {
                if (loginView != null) {
                    loginView.onFail(ex, code, msg);
                    loginView.cancelLoading();
                }
            }

            @Override
            public void onError(int code) {
                if (loginView != null) {
                    loginView.onNetError();
                    loginView.cancelLoading();
                }
            }
        }));
    }

}
