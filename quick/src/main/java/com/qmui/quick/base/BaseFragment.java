package com.qmui.quick.base;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;


import com.orhanobut.logger.Logger;
import com.qmuiteam.qmui.arch.QMUIFragment;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;

import org.simple.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends QMUIFragment {

    protected Activity mActivity;
    private Unbinder mUnbinder;

    @Override
    protected View onCreateView() {
        View view = null;
        if(useEventBus()){
            EventBus.getDefault().register(this);
        }
        int layoutId = getLayoutId();
        if (layoutId == 0) {
            Logger.e("请调用getLayoutId()返回布局");
        }else{
            view = LayoutInflater.from(mActivity).inflate(layoutId, null);
            mUnbinder = ButterKnife.bind(this, view);
            init(view);
        }
        return view;
    }


    protected abstract void init(View view);

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;

    }

    protected abstract int getLayoutId();
    public boolean useEventBus(){
        return false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(useEventBus()){
            EventBus.getDefault().unregister(this);
        }
        if (mUnbinder != null && mUnbinder != Unbinder.EMPTY)
            mUnbinder.unbind();
    }

    @Override
    protected int backViewInitOffset() {
        return QMUIDisplayHelper.dp2px(getContext(), 100);
    }

    @Override
    protected boolean canDragBack() {
        return false;
    }

}
