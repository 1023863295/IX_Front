package com.crf.ix.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;

/**
 * @ClassName: LQRViewHolderForRecyclerView
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/26 15:06
 */
public class LQRViewHolderForRecyclerView extends LQRViewHolder {

    public LQRViewHolderForRecyclerView(Context context, View itemView) {
        super(itemView);
        mContext = context;
        mConvertView = itemView;
        mViews = new SparseArray<>();

        mConvertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(LQRViewHolderForRecyclerView.this, null, v, getPosition());
                }
            }
        });

        mConvertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mOnItemLongClickListener != null) {
                    return mOnItemLongClickListener.onItemLongClick(LQRViewHolderForRecyclerView.this, null, v, getPosition());
                }
                return false;
            }
        });

        mConvertView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (mOnItemTouchListener != null) {
                    return mOnItemTouchListener.onItemTouch(LQRViewHolderForRecyclerView.this, v, event, getPosition());
                }
                return false;
            }
        });

    }
}