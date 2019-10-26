package bran.cupid.www.baselib.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

import bran.cupid.www.baselib.AppProxy;

public class SpUtils {

    // sp的名字
    private final static String SP_NAME = "sp_config";
    private static SharedPreferences sp;

    public static void saveBoolean(String key, boolean value) {

        if (sp == null)
            sp = AppProxy.getInstance().getSharedPreferences(SP_NAME, 0);

        sp.edit().putBoolean(key, value).apply();
    }

    public static void saveInt(String key, int value) {

        if (sp == null)
            sp = AppProxy.getInstance().getSharedPreferences(SP_NAME, 0);

        sp.edit().putInt(key, value).apply();
    }

    public static void saveLong(String key, long value) {

        if (sp == null)
            sp = AppProxy.getInstance().getSharedPreferences(SP_NAME, 0);

        sp.edit().putLong(key, value).apply();
    }

    public static void saveString(String key, String value) {

        if (sp == null)
            sp = AppProxy.getInstance().getSharedPreferences(SP_NAME, 0);

        sp.edit().putString(key, value).apply();
    }


    public static void saveString2(Context context, String key, String value) {

        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, 0);

        sp.edit().putString(key, value).apply();
    }

    public static void saveSet(Context context, String key, Set<String> value) {

        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, 0);

        sp.edit().putStringSet(key, value).apply();
    }

    public static int getInt(Context context,String key, int defValue) {
        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, 0);

        return sp.getInt(key, defValue);

    }

    public static long getLong( String key, long defValue) {
        if (sp == null)
            sp = AppProxy.getInstance().getSharedPreferences(SP_NAME, 0);

        return sp.getLong(key, defValue);
    }

    public static String getString(Context context, String key, String defValue) {
        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, 0);

        return sp.getString(key, defValue);

    }

    public static String getString(String key, String defValue) {
        if (sp == null)
            sp = AppProxy.getInstance().getSharedPreferences(SP_NAME, 0);

        return sp.getString(key, defValue);

    }

    public static String getString2(Context context,String key, String defValue) {
        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, 0);

        return sp.getString(key, defValue);

    }

    public static boolean getBoolean(String key, boolean defValue) {
        if (sp == null) {
            sp = AppProxy.getInstance().getSharedPreferences(SP_NAME, 0);
        }
        return sp.getBoolean(key, defValue);
    }

    public static Set<String> getSet(Context context, String key, Set<String> defValue) {

        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, 0);

        return sp.getStringSet(key, defValue);
    }

    public static void removeValue(Context context, String value) {
        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, 0);
        SharedPreferences.Editor edit = sp.edit();
        edit.remove(value);
        edit.apply();
    }

    public static void clear(Context context) {
        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, 0);
        SharedPreferences.Editor edit = sp.edit();
        edit.clear();
        edit.apply();
    }
}
