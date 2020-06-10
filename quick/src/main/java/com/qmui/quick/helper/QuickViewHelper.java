package com.qmui.quick.helper;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.qmui.quick.QuickApplication;

public class QuickViewHelper {

    public static View createView(int resource){
        return LayoutInflater.from(QuickApplication.getContext()).inflate(resource,null);
    }

    public static void setFont(View view, String fontPath) {
        if(view == null || fontPath == null){
            return;
        }
        try {
            if(view instanceof TextView){
                Typeface fromAsset = Typeface.createFromAsset(QuickApplication.getContext().getAssets(), fontPath);
                ((TextView)view).setTypeface(fromAsset);
            }
        } catch (Exception e) {
            Logger.e("找不到字体文件资源！");
        }
    }

    public static void setBolder(View view) {
        if (view == null) {
            return;
        }
        if (view instanceof TextView) {
            TextPaint paint = ((TextView) view).getPaint();
            paint.setFakeBoldText(true);
        }
    }
}
