package bran.cupid.www.baselib.mvp;

import java.util.HashSet;
import java.util.Set;

import bran.cupid.www.baselib.Api;
import bran.cupid.www.baselib.http.RetrofitManager;

/**
 * 作者: bran
 * 日期: 2019/10/26 0026
 * 描述：
 */
public abstract class BasePresenter {
    private Set set;
    protected Api mApi;

    public BasePresenter() {
        mApi = RetrofitManager.getInstance().getApi();
    }

    protected <V extends BaseView> void attachView(V m) {
        if (set == null) {
            set = new HashSet<V>();
        }
        set.add(m);
    }

    public void detachView() {
        if (set != null) {
            for (Object o : set) {
                o = null;
            }
        }
    }
}
