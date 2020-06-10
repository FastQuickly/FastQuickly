package com.qmui.quick.base;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.qmuiteam.qmui.arch.QMUIFragmentActivity;



public abstract class BaseFragmentActivity extends QMUIFragmentActivity {

    protected AppManager appManager = AppManager.getAppManager();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appManager.addActivity(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        appManager.finishActivity(this);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        if (newConfig.fontScale != 1){
            getResources();
        }
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        if (res.getConfiguration().fontScale != 1) {//非默认值
            Configuration newConfig = new Configuration();
            newConfig.setToDefaults();//设置默认
            res.updateConfiguration(newConfig, res.getDisplayMetrics());
        }
        return res;
    }
}
