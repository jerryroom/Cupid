package bran.cupid.www.baselib.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import bran.cupid.www.baselib.AppProxy;

/**
 * 作者: bran
 * 日期: 2019/10/26 0026
 * 描述：
 */
public class BaseUtils {
    private static final String TAG = "BaseUtils";

    /**
     * toast
     *
     * @param s
     */
    private static Toast toast;

    public static void toast(String s) {
        if (toast == null) {
            toast = Toast.makeText(AppProxy.getInstance(), s, Toast.LENGTH_SHORT);
        }
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setText(s);
        toast.show();
    }

    public static void toast(@StringRes int s) {
        if (toast == null) {
            toast = Toast.makeText(AppProxy.getInstance(), s, Toast.LENGTH_SHORT);
        }
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setText(s);
        toast.show();
    }

    /**
     * 获取屏幕宽度
     */
    public static int getScreenWidth() {
        DisplayMetrics dm = AppProxy.getInstance().getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        DisplayMetrics dm = AppProxy.getInstance().getResources().getDisplayMetrics();
        return dm.heightPixels;
    }

    /**
     * 获取手机分辨率
     *
     * @return
     */
    public static float getDensity() {
        DisplayMetrics dm = AppProxy.getInstance().getResources().getDisplayMetrics();
        return dm.density;
    }

    /**
     * 点击操作
     */
    private static final int MIN_DELAY_TIME = 1000;  // 两次点击间隔不能少于1000ms
    private static long lastClickTime;

    public static boolean isFastClick() {
        boolean flag = true;
        long currentClickTime = System.currentTimeMillis();
        if ((currentClickTime - lastClickTime) >= MIN_DELAY_TIME) {
            flag = false;
        }
        lastClickTime = currentClickTime;
        return flag;
    }

    /**
     * 脱敏手机号
     *
     * @param mobile
     * @return
     */
    public static String hideMobile(String mobile) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(mobile) && mobile.length() > 6) {

            for (int i = 0; i < mobile.length(); i++) {
                char c = mobile.charAt(i);
                if (i >= 3 && i <= 6) {
                    sb.append('*');
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 检查网络
     *
     * @return
     */
    public static boolean checkNet() {
        String networkTypeName = getNetworkTypeName();
        if (TextUtils.isEmpty(networkTypeName)) {//没网络
            return false;
        }
        return true;
    }

    /**
     * @return int
     * @Title:
     * @Description:获取网络类型
     */
    public static String getNetworkTypeName() {
        ConnectivityManager connManager = (ConnectivityManager) AppProxy.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        @SuppressLint("MissingPermission") NetworkInfo networkinfo = connManager.getActiveNetworkInfo();
        if (networkinfo == null)
            return null;
        int type = networkinfo.getType();
        if (type == ConnectivityManager.TYPE_WIFI) {
            return "WIFI";
        } else if (type == ConnectivityManager.TYPE_MOBILE) {
            String networkName = networkinfo.getExtraInfo();
            if (networkName != null && networkName.length() > 20) {
                networkName = networkName.substring(0, 20);
            }
            return networkName;
        } else {
            return null;
        }
    }

    /**
     * dip transform to px
     *
     * @param dpVale
     * @return
     */
    public static int dip2px(float dpVale) {
        final float scale = AppProxy.getInstance().getResources().getDisplayMetrics().density;
        return (int) (dpVale * scale + 0.5f);
    }


    /**
     * @return String
     * @Title:
     * @Description:获取手机型号
     */
    public static String getModel() {
        return Build.MODEL;
    }

    /**
     * @return String
     * @Title:
     * @Description:获取手机品牌
     */
    public static String getBrand() {
        return Build.BRAND;
    }

    public static String fileToJson(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            File file = new File(path);

            if (file.exists()) {
                LogUtils.e(TAG, "开始读取json");
                BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                String line;
                while ((line = bf.readLine()) != null) {
                    stringBuilder.append(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /**
     * 资源文件转换成json字符串
     *
     * @param context
     * @param fileName
     * @return
     */
    public static String getJson(Context context, String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assetManager = context.getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static boolean listIsEmpty(List list) {
        return list == null || list.size() == 0;
    }
}
