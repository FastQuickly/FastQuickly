package com.qmui.quick.helper;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.qmui.quick.QuickApplication;
import com.qmui.quick.R;

public class QuickImageLoader {

    public static void load(ImageView view, String url) {
        Glide.with(QuickApplication.getContext()).load(url).
                into(view);
    }

    public static void loadOnHolder(ImageView view, String url) {
        Glide.with(QuickApplication.getContext()).load(url).
                error(R.drawable.quick_image_holder).
                placeholder(R.drawable.quick_image_holder).
                into(view);
    }
}
