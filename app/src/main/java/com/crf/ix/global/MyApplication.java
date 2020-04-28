package com.crf.ix.global;

import android.app.Application;
import android.content.Context;

import cn.jpush.android.api.JPushInterface;

/**
 * @ClassName: MyApplication
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/8/23 18:35
 */
public class MyApplication extends Application {
    private static Context sAppContext;

    public MyApplication(){
        sAppContext=getAppContext();
    }

    public static Context getAppContext() {
        return sAppContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sAppContext = this;


        //极光推送
//        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }
}
