package bran.cupid.www.baselib.util;

import android.util.Log;

import com.google.gson.Gson;

import io.reactivex.annotations.Nullable;

/**
 * 作者: bran
 * 日期: 2019/10/26 0026
 * 描述：
 */
public class LogUtils {
    private static boolean toggle = true;

    public static void closeLog() {
        toggle = false;
    }

    public static void toJson(@Nullable String TAG, Object object) {
        if (toggle) {
            Gson gson = new Gson();
            Log.e(TAG, "requestLog: JSON ----> " + gson.toJson(object));
        }
    }

    public static void e(@Nullable String TAG, Object obj) {
        if (toggle) Log.e(TAG, "WR---" + TAG + "-----" + obj);
    }
}
