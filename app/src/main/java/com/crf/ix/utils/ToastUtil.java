package com.crf.ix.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * @ClassName: ToastUtil
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/8/29 18:48
 */
public class ToastUtil {

    private static Toast mToast = null;
    private static ToastUtil toastUtil;
    private static Toast toast=null;

    public static ToastUtil getInstance() {
        if (toastUtil == null) {
            toastUtil = new ToastUtil();
        }
        return toastUtil;
    }

    public ToastUtil() {
    }

    public static void showLongToast(Context context, int id) {
        if (null != context) {
            if (null == mToast) {
                mToast = Toast.makeText(context, id, Toast.LENGTH_LONG);
            } else {
                mToast.setText(id);
            }
            mToast.show();
        }
    }

    public static void showLongToast(Context context, String content) {
        if (null != context) {
            if (null == mToast) {
                mToast = Toast.makeText(context, content, Toast.LENGTH_LONG);
            } else {
                mToast.setText(content);
            }
            mToast.show();
        }
    }

    public static void showShortToast(Context context, int id) {
        if (null != context) {
            if (null == mToast) {
                mToast = Toast.makeText(context, id, Toast.LENGTH_SHORT);
            } else {
                mToast.setText(id);
            }
            mToast.show();
        }
    }

    public static void showShortToast(Context context, String content) {
        if (null != context) {
            if (null == mToast) {
                mToast = Toast.makeText(context, content, Toast.LENGTH_SHORT);
            } else {
                mToast.setText(content);
            }
            mToast.show();
        }
    }
}
