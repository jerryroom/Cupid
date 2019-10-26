package bran.cupid.www.baselib.mvp;

import bran.cupid.www.baselib.module.req.LoginReq;
import bran.cupid.www.baselib.module.rsp.LoginRsp;

/**
 * 作者: bran
 * 日期: 2019/10/26 0026
 * 描述：
 */
public interface GlobalContract {
    interface GlobalPreenter {
        void onLogin(LoginReq req, LoginView loginView);
    }

    public interface LoginView extends BaseView {
        void onLoginSuc(String code, LoginRsp data, String msg, String desc);
    }
}
