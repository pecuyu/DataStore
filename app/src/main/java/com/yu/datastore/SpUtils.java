package com.yu.datastore;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by D22436 on 2017/8/1.
 * SharedPreferences工具类
 */

public class SpUtils {
    private static  SharedPreferences sp;
    private Context context;

    private SpUtils(Context context) {
        this.context = context;
    }

    public static SpUtils getInstance(Context context) {
        sp = context.getSharedPreferences("sp.xml", Context.MODE_PRIVATE | Context.MODE_APPEND);
        return new SpUtils(context);
    }

    public  void putString(String key, String value) {
        sp.edit().putString(key, value).commit();
    }
    public  void putInt(String key, int value) {
        sp.edit().putInt(key, value).commit();
    }

    public String getString(String key) {
        return sp.getString(key, null);
    }

    public int getInt(String key) {
        return sp.getInt(key, 0);
    }

    private void checkSpState() {
        if (sp == null) {
            throw new RuntimeException("you should use getInstance to edit");
        }
    }
}
