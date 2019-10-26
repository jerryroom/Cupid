package bran.cupid.www.baselib.mvp;

import android.content.Context;

/**
 * 作者: bran
 * 日期: 2019/10/25 0025
 * 描述：
 */
public interface BaseView {

    Context getContext();

    void onFail(Throwable ex, String code, String msg);

    void onNetError();

    void loading();

    void cancelLoading();
}
