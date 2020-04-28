package com.crf.ix.adapter;

import android.view.MotionEvent;
import android.view.View;

/**
 * @ClassName: OnItemTouchListener
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/26 15:11
 */
public interface OnItemTouchListener {
    boolean onItemTouch(LQRViewHolder helper, View childView, MotionEvent event, int position);
}
