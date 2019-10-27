package bran.cupid.www.cupid;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import bran.cupid.www.baselib.eventbus.EventBean;
import bran.cupid.www.baselib.eventbus.EventBus;
import bran.cupid.www.baselib.mvp.BaseFragment;
import bran.cupid.www.baselib.mvp.PresenterImp;
import bran.cupid.www.baselib.util.BaseUtils;
import bran.cupid.www.baselib.util.LogUtils;
import bran.cupid.www.baselib.util.SpUtils;
import bran.cupid.www.cupid.base.Constant;
import bran.cupid.www.cupid.config.JsonFile;
import bran.cupid.www.cupid.config.TabItem;
import bran.cupid.www.cupid.find.FindFragment;
import bran.cupid.www.cupid.home.HomeFragment;
import bran.cupid.www.cupid.mine.MineFragment;
import butterknife.BindView;
import me.yokeyword.fragmentation.ISupportFragment;

import static bran.cupid.www.cupid.config.JsonFile.FindPage;
import static bran.cupid.www.cupid.config.JsonFile.HomePage;
import static bran.cupid.www.cupid.config.JsonFile.MinePage;

/**
 * 作者: bran
 * 日期: 2019/10/26 0026
 * 描述：
 */
public class MainFragment extends BaseFragment implements BottomNavigationBar.OnTabSelectedListener {

    @BindView(R.id.rootContainer)
    FrameLayout container;
    @BindView(R.id.navigator)
    BottomNavigationBar navigator;

    private static final String TAG = "MainFragment";
    private static MainFragment instance;

    private List<BaseFragment> list;
    private JsonFile jsonFile;
    private HomeFragment homeFragment;
    private FindFragment findFragment;
    private MineFragment mineFragment;


    public String mainColor;
    private int curPage = 0;

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
        String json = BaseUtils.getJson(getContext(), Config.ConfigV1);
        jsonFile = new Gson().fromJson(json, JsonFile.class);

        buidlPage(jsonFile);
    }

    private void buidlPage(JsonFile jsonFile) {
        if (jsonFile == null) {
            return;
        }
        mainColor = jsonFile.pubConfig.mainColor;
        SpUtils.saveString(Constant.MAIN_COLOR, mainColor);
        List<TabItem> tabBar = jsonFile.pubConfig.tabBar;
        if (tabBar != null && tabBar.size() > 0) {
            for (TabItem tabItem : tabBar) {
                switch (tabItem.tabView) {
                    case HomePage:
                        navigator.addItem(new BottomNavigationItem(R.mipmap.icon_tab_home, tabItem.text)
                                .setActiveColor(tabItem.tabBarTextSelectColor))
                                .setInActiveColor(tabItem.tabBarTextColor);
                        if (homeFragment == null) {
                            homeFragment = HomeFragment.getInstance(arg(Constant.UI_PARAMS, jsonFile).build());
                        }
                        list.add(homeFragment);
                        break;
                    case FindPage:
                        navigator.addItem(new BottomNavigationItem(R.mipmap.icon_tab_find, tabItem.text)
                                .setActiveColor(tabItem.tabBarTextSelectColor))
                                .setInActiveColor(tabItem.tabBarTextColor);
                        if (findFragment == null) {
                            findFragment = FindFragment.getInstance(arg(Constant.UI_PARAMS, jsonFile).build());
                        }
                        list.add(findFragment);
                        break;
                    case MinePage:
                        navigator.addItem(new BottomNavigationItem(R.mipmap.icon_tab_mine, tabItem.text)
                                .setActiveColor(tabItem.tabBarTextSelectColor))
                                .setInActiveColor(tabItem.tabBarTextColor);
                        if (mineFragment == null) {
                            mineFragment = MineFragment.getInstance(arg(Constant.UI_PARAMS, jsonFile).build());
                        }
                        list.add(mineFragment);
                        break;
                }
            }

            navigator.initialise();
            navigator.setTabSelectedListener(this);
            ISupportFragment[] fragments = new ISupportFragment[list.size()];
            loadMultipleRootFragment(R.id.rootContainer, curPage, list.toArray(fragments));
        }


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

    @Override
    public void onTabSelected(int position) {
        if (position == curPage) {
            return;
        }
        showHideFragment(list.get(position), list.get(curPage));
        curPage = position;


    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    public static class UiParams implements Serializable {

    }


    public static class Config {
        public static final String ConfigV1 = "TempConfigV1.json";
    }
}
