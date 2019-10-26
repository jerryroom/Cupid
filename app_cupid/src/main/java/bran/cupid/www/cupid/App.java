package bran.cupid.www.cupid;

import android.app.Application;

import bran.cupid.www.baselib.AppProxy;

/**
 * 作者: bran
 * 日期: 2019/10/26 0026
 * 描述：
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppProxy.inject(this);
    }
}
