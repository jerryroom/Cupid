package bran.cupid.www.cupid.home;

import android.os.Bundle;

import bran.cupid.www.baselib.mvp.BaseFragment;
import bran.cupid.www.baselib.mvp.PresenterImp;
import bran.cupid.www.cupid.R;

/**
 * 作者: bran
 * 日期: 2019/10/26 0026
 * 描述：
 */
public class HomeFragment extends BaseFragment<PresenterImp> {

    private static final String TAG = "HomeFragment";
    private static HomeFragment instance;

    public static HomeFragment getInstance(Bundle args) {
        if (instance == null) {
            instance = new HomeFragment();
        }
        instance.setArguments(args);
        return instance;
    }

    @Override
    protected void init() {

    }

    @Override
    protected PresenterImp createPresenter() {
        return new PresenterImp();
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected int layoutRes() {
        return R.layout.frag_home;
    }
}
