package com.crf.ix.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: DateUtils
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/17 15:00
 */
public class DateUtils {
    public static final String DATE_TYPE = "yyyyMMdd";
    public static final String DATE_TIME_TYPE = "yyyy-MM-dd HH:mm:ss";

    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static String getStringDateTime() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
}
