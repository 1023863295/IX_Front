package com.crf.ix.jsInterface;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Message;
import android.provider.Settings;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.crf.ix.utils.ToastUtil;

/**
 *
 */

public class JSInterface {
    private Context context;

    public JSInterface(Activity activity) {
        this.context = activity;

    }
    @JavascriptInterface
    public void JScallBack(String content) {
        ToastUtil.showShortToast(context,content);
    }

    @JavascriptInterface
    public String getName() {
      return "android  123456";
    }
}
