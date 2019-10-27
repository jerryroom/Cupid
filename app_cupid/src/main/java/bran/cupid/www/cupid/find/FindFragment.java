package bran.cupid.www.cupid.find;

import android.os.Bundle;

import bran.cupid.www.baselib.mvp.BaseFragment;
import bran.cupid.www.baselib.mvp.PresenterImp;
import bran.cupid.www.cupid.R;
import bran.cupid.www.cupid.home.HomeFragment;

/**
 * 作者: bran
 * 日期: 2019/10/26 0026
 * 描述：
 */
public class FindFragment extends BaseFragment<PresenterImp> {
    private static final String TAG = "FindFragment";
    private static FindFragment instance;

    public static FindFragment getInstance(Bundle args) {
        if (instance == null) {
            instance = new FindFragment();
        }
        instance.setArguments(args);
        return instance;
    }
    @Override
    protected void init() {
        exitFlag = true;
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
        return R.layout.frag_find;
    }
}
