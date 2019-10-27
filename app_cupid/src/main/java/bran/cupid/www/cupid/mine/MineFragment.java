package bran.cupid.www.cupid.mine;

import android.os.Bundle;

import bran.cupid.www.baselib.eventbus.EventBean;
import bran.cupid.www.baselib.eventbus.EventBus;
import bran.cupid.www.baselib.eventbus.Subscribe;
import bran.cupid.www.baselib.eventbus.ThreadMode;
import bran.cupid.www.baselib.mvp.BaseFragment;
import bran.cupid.www.baselib.mvp.PresenterImp;
import bran.cupid.www.baselib.util.LogUtils;
import bran.cupid.www.cupid.R;

/**
 * 作者: bran
 * 日期: 2019/10/26 0026
 * 描述：
 */
public class MineFragment extends BaseFragment<PresenterImp> {
    private static final String TAG = "MineFragment";
    private static MineFragment instance;

    public static MineFragment getInstance(Bundle args) {
        if (instance == null) {
            instance = new MineFragment();
        }
        instance.setArguments(args);
        return instance;
    }

    protected void init() {
        EventBus.getEventBus().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventBean eventBean) {
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
        return R.layout.frag_mine;
    }
}
