package bran.cupid.www.cupid;

import android.os.Bundle;
import android.widget.FrameLayout;

import bran.cupid.www.baselib.mvp.BaseActivity;
import bran.cupid.www.baselib.mvp.PresenterImp;
import bran.cupid.www.cupid.base.Constant;
import butterknife.BindView;

public class MainActivity extends BaseActivity<PresenterImp> {
    @BindView(R.id.container)
    FrameLayout container;

    private MainFragment mainFragment;

    @Override
    protected PresenterImp createPresenter() {
        return new PresenterImp();
    }

    @Override
    protected void init() {
        mainFragment = findFragment(MainFragment.class);
        if (mainFragment == null) {
            MainFragment.UiParams params = new MainFragment.UiParams();
            Bundle bundle = new Bundle();
            bundle.putSerializable(Constant.UI_PARAMS, params);
            mainFragment = MainFragment.getInstance(bundle);
            loadRootFragment(R.id.container, mainFragment);
        }
    }

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }


}
