package com.crf.ix.utils;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;

/**
 * @ClassName: StringUtils
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/8/30 11:26
 */
public class StringUtils {
    public static boolean isEmpty(String str) {
        if(str==null){
            return true;
        }else {
            if (TextUtils.isEmpty(str) || "null".equals(str)|| "".equals(str.trim())) {
                return true;
            }
            return false;
        }
    }

    /**
     * 替换字符串内指定字段颜色
     * @param color
     * @param string
     * @param keyWord
     * @return
     */
    public static CharSequence matcherSearchText(int color, String string, String keyWord) {
        SpannableStringBuilder builder = new SpannableStringBuilder(string);
        if(keyWord.length()>0&&!keyWord.equals("")){
            int indexOf = string.indexOf(keyWord);
            if (indexOf != -1) {
                builder.setSpan(new ForegroundColorSpan(color), indexOf, indexOf + keyWord.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        return builder;
    }

    /**
     * 手机号码中间隐私处理
     * @param pNumber  手机号
     * @return
     */
    public static String getPhoneString(String pNumber){
        StringBuilder sb  =new StringBuilder();
        for (int i = 0; i < pNumber.length(); i++) {
            char c = pNumber.charAt(i);
            if (i >= 3 && i <= 7) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return  sb.toString();

    }


}
