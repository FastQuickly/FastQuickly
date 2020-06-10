package com.qmui.quick.helper;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.qmui.quick.QuickApplication;

public class QuickImageHelper {

    public static void into(ImageView view, String url) {
        Glide.with(QuickApplication.getContext()).load(url).
                into(view);
    }
}
