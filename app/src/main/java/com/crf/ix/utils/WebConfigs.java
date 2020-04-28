package com.crf.ix.utils;

import android.content.Context;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * @ClassName: WebConfigs
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/4 15:27
 */
public class WebConfigs {

    public static void setDefaultConfig(WebView webView, final Context context){

        //声明WebSettings子类
        WebSettings settings = webView.getSettings();
        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        settings.setJavaScriptEnabled(true);
        //支持插件
//        settings.setPluginsEnabled(true);
//        settings.setPluginState(WebSettings.PluginState.ON);

        //设置自适应屏幕，两者合用
        settings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        settings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小

        //缩放操作
        settings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        settings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        settings.setDisplayZoomControls(false); //隐藏原生的缩放控件

        settings.setAppCacheEnabled(true);
        //其他细节操作
//        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
        if (NetUtil.isNetworkAvailable()) {
            settings.setCacheMode(WebSettings.LOAD_DEFAULT);//根据cache-control决定是否从网络上取数据。
        } else {
            settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);//没网，则从本地获取，即离线加载
        }
        settings.setAllowFileAccess(true); //设置可以访问文件
        settings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        settings.setLoadsImagesAutomatically(true); //支持自动加载图片
        settings.setDefaultTextEncodingName("utf-8");//设置编码格式


        settings.setDatabaseEnabled(true);
        settings.setGeolocationEnabled(false);
        settings.setDomStorageEnabled(true);

        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        webView.requestFocus();
        webView.setLongClickable(true);
        webView.setScrollbarFadingEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setDrawingCacheEnabled(true);

        // 隐藏滚动条
        webView.setHorizontalScrollBarEnabled(false);
    }

}
