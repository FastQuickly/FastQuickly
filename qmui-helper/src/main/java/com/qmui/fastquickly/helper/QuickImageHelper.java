package com.qmui.fastquickly.helper;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.qmui.fastquickly.QuickApplication;

public class QuickImageHelper {

    public static void into(ImageView view, String url) {
        Glide.with(QuickApplication.getContext()).load(url).
                into(view);
    }
}
