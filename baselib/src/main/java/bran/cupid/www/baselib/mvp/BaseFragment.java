package bran.cupid.www.baselib.mvp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * 作者: bran
 * 日期: 2019/10/26 0026
 * 描述：
 */
public abstract class BaseFragment<P extends PresenterImp> extends SwipeBackFragment implements BaseView {
    protected P mPresenter;
    protected View mRootView;
    private Unbinder unbinder;
    protected boolean exitFlag = false;
    protected Bundle bundle;
    private Activity context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(layoutRes(), container, false);
        unbinder = ButterKnife.bind(this, mRootView);
        initIntent(getArguments());
        mPresenter = createPresenter();
        init();
        return attachToSwipeBack(mRootView);
    }

    protected void initIntent(Bundle arguments) {

    }

    protected abstract void init();

    protected abstract P createPresenter();

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        lazyLoad();
    }

    protected abstract void lazyLoad();

    @Override
    public void onDestroyView() {
        if (exitFlag) {
            _mActivity.finish();
        }
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = (BaseActivity) context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context = activity;
    }

    @Override
    public Activity getContext() {
        return context;
    }

    protected abstract int layoutRes();

    @Override
    public void onFail(Throwable ex, String code, String msg) {

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

    protected void back() {
        pop();
    }

    public BaseFragment<P> arg(String key, String value) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(key, value);
        return this;
    }

    public BaseFragment arg(String key, boolean value) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBoolean(key, value);
        return this;
    }

    public BaseFragment arg(String key, Serializable value) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putSerializable(key, value);
        return this;
    }

    public Bundle build() {
        return bundle;
    }
}
