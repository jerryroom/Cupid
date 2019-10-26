package bran.cupid.www.baselib.http;

import bran.cupid.www.baselib.module.BaseListModule;
import bran.cupid.www.baselib.module.BaseModule;


public class CodeInterceptor<T> {

    public void intercept(SubscriberWrapper.CallBackListener<T> callBackListener, T t) {
        if (t instanceof BaseModule) {
            BaseModule baseResponse = (BaseModule) t;
            String code = baseResponse.code;
            String msg = baseResponse.msg;
            String desc = baseResponse.desc;
            // 后续处理异常情况
//            desc = CodeParser.parse(code, desc);

            if (baseResponse.data != null) {
                t = (T) baseResponse.data;
            } else {
//                parseCode(callBackListener, null, code, msg, desc);
                return;
            }

            parseCode(callBackListener, t, code, msg, desc);

        } else if (t instanceof BaseListModule) {
            BaseListModule baseListResponse = (BaseListModule) t;
            String code = baseListResponse.code;
            String msg = baseListResponse.msg;
            String desc = baseListResponse.desc;

            // 后续处理异常情况
//            desc = CodeParser.parse(code, desc);

//            parseCode(callBackListener, t, code, msg, desc);

        } else {
            callBackListener.onSuccess("", t, "", "");
        }
    }


    /**
     * 解析code
     *
     * @param callBackListener
     * @param t
     * @param code
     * @param msg
     * @param desc
     */
    private void parseCode(SubscriberWrapper.CallBackListener<T> callBackListener, T t, String code, String msg, String desc) {

//        if (TextUtils.isEmpty(code)) {
//            callBackListener.onFailed(null, code + "", desc + "");
//            return;
//        }
//
//        switch (code) {
//            case CodeParser.CODE_REQUEST_SUCCESS:
//                callBackListener.onSuccess(code, t, msg, desc);
//                break;
//            case CodeParser.CODE_TOKEN_OVERTIME:
//            case CodeParser.CODE_FORCE_LOGOUT:
//            case CodeParser.CODE_TOKEN_INVALID:
//            case CodeParser.CODE_TOKEN_NOT_FOUND:
//            case CodeParser.CODE_FORCE_LOGOUT2:
//                callBackListener.onFailed(null, code, desc);
//                SpUtils.saveString(Constant.AUTHTOKEN, "");
//                //重新登录
//                AppProxy.login();
//                break;
//            case CodeParser.CODE_HAS_NEW_LOGIN:
//                SpUtils.saveString(Constant.AUTHTOKEN, "");
//                callBackListener.onFailed(null, code, desc);
//                //被踢下线
//                AppProxy.kickOutline();
//                break;
//            case CodeParser.CODE_TOKEN_OVER_30DAYS:
//                SpUtils.saveString(Constant.AUTHTOKEN, "");
//                callBackListener.onFailed(null, code, desc);
//                AppProxy.gestureLogin();
//                break;
//            case CodeParser.CODE_SAFE_HOME_TYPE1:
//            case CodeParser.CODE_SAFE_HOME_TYPE2:
//                // 直接回到首页，不执行后续任务 TODO
////                callBackListener.onFailed(null,code,desc);
//                AppProxy.safeBackHome(desc, "homePage");
//                break;
//            default:
//                callBackListener.onFailed(null, code + "", desc);
//                break;
//        }
//    }
    }
}
