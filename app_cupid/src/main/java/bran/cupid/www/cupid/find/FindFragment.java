package bran.cupid.www.cupid.find;

import bran.cupid.www.baselib.mvp.BaseFragment;
import bran.cupid.www.baselib.mvp.PresenterImp;
import bran.cupid.www.cupid.R;

/**
 * 作者: bran
 * 日期: 2019/10/26 0026
 * 描述：
 */
public class FindFragment extends BaseFragment<PresenterImp> {
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
