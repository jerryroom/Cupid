package bran.cupid.www.baselib.mvp;

import android.content.Context;
import android.os.Bundle;

import bran.cupid.www.baselib.util.BaseUtils;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackActivity;

/**
 * 作者: bran
 * 日期: 2019/10/26 0026
 * 描述：
 */
public abstract class BaseActivity<P extends PresenterImp> extends SwipeBackActivity implements BaseView {
    private Unbinder unbinder;
    private Context context;
    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (layoutRes() != 0) {
            setContentView(layoutRes());
        }
        unbinder = ButterKnife.bind(this);
        context = this;
        mPresenter = createPresenter();
        init();
    }

    protected abstract P createPresenter();

    protected abstract void init();

    protected abstract int layoutRes();

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public void onFail(Throwable ex, String code, String msg) {
        BaseUtils.toast(msg);
    }

    @Override
    public void onNetError() {

    }

    @Override
    public void loading() {

    }

    @Override
    public void cancelLoading() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
