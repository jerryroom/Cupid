package bran.cupid.www.baselib;

import android.app.Application;

/**
 * 作者: bran
 * 日期: 2019/10/26 0026
 * 描述：
 */
public class AppProxy extends Application {
    private static Application application;


    public static void inject(Application app) {
        application = app;
    }

    public static Application getInstance() {
        return application;
    }
}
