package com.crf.ix.utils;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * @ClassName: DeviceInfoUtil
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/5 15:08
 */
public class DeviceInfoUtil {
    private static String androidVersion="";


    public static int getWidth(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }


    public static int getHeight(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }

    //需要的权限
    //只有Android手机才有， IMEI号是一串15位的号码，比如像这样 359881030314356
    //<uses-permission android:name="android.permission.READ_PHONE_STATE"/>
    public String getIMEI(Context context){
        TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getDeviceId();
    }

    //获得独一无二的Psuedo ID, 不需要任何权限
    public static String getUniquePsuedoID() {
        String serial = null;

        String m_szDevIDShort = "35" +
                Build.BOARD.length()%10+ Build.BRAND.length()%10 +
                Build.CPU_ABI.length()%10 + Build.DEVICE.length()%10 +
                Build.DISPLAY.length()%10 + Build.HOST.length()%10 +
                Build.ID.length()%10 + Build.MANUFACTURER.length()%10 +
                Build.MODEL.length()%10 + Build.PRODUCT.length()%10 +
                Build.TAGS.length()%10 + Build.TYPE.length()%10 +
                Build.USER.length()%10 ; //13 位
        try {
            serial = android.os.Build.class.getField("SERIAL").get(null).toString();
            //API>=9 使用serial号
            return new UUID(m_szDevIDShort.hashCode(), serial.hashCode()).toString();
        } catch (Exception exception) {
            //serial需要一个初始化
            serial = "serial"; // 随便一个初始化
        }
        //使用硬件信息拼凑出来的15位号码
        return new UUID(m_szDevIDShort.hashCode(), serial.hashCode()).toString();
    }


    //这个是不靠谱的，因为有时候它是null的，文档中明确说明，如果你恢复了出厂设置，那他就会改变的。而且如果你root了手机，你也可以改变这个ID
    public static String getAndroidId(Context context){
        return Settings.System.getString(context.getContentResolver(),Settings.Secure.ANDROID_ID);
    }


    //获取手机的android版本号
    public static String getAndroidVersion(){
        if(StringUtils.isEmpty(androidVersion)){
            try {
                androidVersion = URLEncoder.encode(android.os.Build.VERSION.RELEASE,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return androidVersion;
    }
}
