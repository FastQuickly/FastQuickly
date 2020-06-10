package com.qmui.quick.helper;

import android.app.Activity;
import android.app.Dialog;

import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.zhouyou.http.subsciber.IProgressDialog;

public class QuickLoadingHelper {
    public static Dialog showLoading(Activity mActivity) {
        Dialog loading = showLoading(mActivity, null);
        loading.show();
        return loading;
    }

    public static Dialog showLoading(Activity mActivity, String tipWord) {
        return createLoading(mActivity, tipWord);
    }

    public static Dialog createLoading(Activity mActivity) {
        return createLoading(mActivity, null);
    }

    public static Dialog createLoading(Activity mActivity, String tipWord) {
        QMUITipDialog.Builder builder = new QMUITipDialog.Builder(mActivity)
                .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                .setTipWord(tipWord == null || tipWord.trim().length() == 0 ? "载入中..." : tipWord);
        QMUITipDialog dialog = builder.create();
        dialog.setCancelable(false);
        return dialog;
    }

    public static IProgressDialog createProgress(Activity activity) {
        IProgressDialog mProgressDialog = () -> createLoading(activity);
        return mProgressDialog;
    }
}
