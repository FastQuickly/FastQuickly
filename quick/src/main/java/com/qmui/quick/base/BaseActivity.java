package com.qmui.quick.base;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.orhanobut.logger.Logger;
import com.qmuiteam.qmui.arch.QMUIActivity;

import org.simple.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends QMUIActivity {

    protected AppManager appManager = AppManager.getAppManager();
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appManager.addActivity(this);
        if(useEventBus()){
            EventBus.getDefault().register(this);
        }
        int layoutId = getLayoutId();
        if(layoutId == 0){
            Logger.d("未设定布局文件");
        }else{
            setContentView(layoutId);
            mUnbinder = ButterKnife.bind(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(useEventBus()){
            EventBus.getDefault().unregister(this);
        }
        appManager.finishActivity(this);
        if (mUnbinder != null && mUnbinder != Unbinder.EMPTY)
            mUnbinder.unbind();
    }

    @Override
    protected boolean canDragBack() {
        return true;
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
    protected abstract int getLayoutId();
    public boolean useEventBus(){
        return false;
    }
}
