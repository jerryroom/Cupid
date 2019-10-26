package bran.cupid.www.cupid;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import bran.cupid.www.baselib.mvp.BaseFragment;
import bran.cupid.www.baselib.mvp.PresenterImp;
import bran.cupid.www.cupid.find.FindFragment;
import bran.cupid.www.cupid.home.HomeFragment;
import bran.cupid.www.cupid.mine.MineFragment;
import butterknife.BindView;

/**
 * 作者: bran
 * 日期: 2019/10/26 0026
 * 描述：
 */
public class MainFragment extends BaseFragment {

    @BindView(R.id.rootContainer)
    FrameLayout container;
    @BindView(R.id.navigator)
    BottomNavigationBar navigator;

    private static final String TAG = "MainFragment";
    private static MainFragment instance;

    private List<BaseFragment> list;

    private HomeFragment homeFragment;
    private FindFragment findFragment;
    private MineFragment mineFragment;


    public static MainFragment getInstance(Bundle args) {
        if (instance == null) {
            instance = new MainFragment();
        }
        instance.setArguments(args);
        return instance;
    }

    @Override
    protected void init() {

        list = new ArrayList<>();
        
//        for (int i = 0; i <4 ; i++) {
//            navigator.addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "tab"+i).setInactiveIconResource(R.mipmap.ic_launcher).setActiveColor(R.color.colorAccent));
//        }
//        navigator.initialise();
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
        return R.layout.frag_main;
    }

    public static class UiParams implements Serializable {

    }
}
