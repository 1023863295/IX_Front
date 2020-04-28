package com.crf.ix.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.crf.ix.global.MyApplication;

/**
 * @ClassName: AppInfo
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/3 14:34
 */
public class AppInfo {
    /**
     * 得到应用程序的包名
     *
     * @return
     */
    public static String getPackageName() {
        return MyApplication.getAppContext().getPackageName();
    }

    // 取得版本名称
    public static String GetVersionName(Context context) {
        try {
            PackageInfo manager = context.getApplicationContext().getPackageManager().getPackageInfo(
                    context.getPackageName(), 0);
            return manager.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "Unknown";
        }
    }

    //获取版本号
    public static String getVersionCode(Context context){
        try {
            PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(),0);
            return packageInfo.versionCode+"";
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "Unknown";
        }
    }

}
