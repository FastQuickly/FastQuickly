package com.qmui.quick.helper;

import android.content.Context;
import android.content.SharedPreferences;

import com.qmui.quick.QuickApplication;


public class QuickPreferences {
    private SharedPreferences share;
    private SharedPreferences.Editor editor;
    private String SHARED_NAME = "quick_config";//sp的文件名 自定义

    private QuickPreferences() {
        share = QuickApplication.getContext().getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE);
        editor = share.edit();
    }


    private static QuickPreferences instance;//单例模式 双重检查锁定
    public static QuickPreferences getInstance() {
        if (instance == null) {
            synchronized (QuickPreferences.class) {
                if (instance == null) {
                    instance = new QuickPreferences();
                }
            }
        }
        return instance;
    }



    public void putInt(String spName, int value) {
        editor.putInt(spName, value);
        editor.commit();
    }

    public int getInt(String spName, int defaultvalue) {
        return share.getInt(spName, defaultvalue);
    }


    public void putString(String spName, String value) {
        editor.putString(spName, value);
        editor.commit();
    }

    public String getString(String spName, String defaultvalue) {
        return share.getString(spName, defaultvalue);
    }

    public String getString(String spName) {
        return share.getString(spName, "");
    }



    public void putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public boolean getBoolean(String key, boolean defValue) {
        return share.getBoolean(key, defValue);
    }


    public void putFloat(String key, float value) {
        editor.putFloat(key, value);
        editor.commit();
    }

    public float getFloat(String key, float defValue) {
        return share.getFloat(key, defValue);
    }


    public void putLong(String key, long value) {
        editor.putLong(key, value);
        editor.commit();
    }

    public long getLong(String key, long defValue) {
        return share.getLong(key, defValue);
    }

    public void clear() {
        editor.clear();//清空
        editor.commit();//提交
    }

    public void remove(String key) {
        editor.remove(key);//删除掉指定的值
        editor.commit();//提交
    }

    public boolean contains(String key) {
        return share.contains(key);
    }

}
