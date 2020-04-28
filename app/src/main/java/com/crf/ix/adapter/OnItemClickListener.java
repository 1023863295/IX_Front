package com.crf.ix.adapter;

import android.view.View;
import android.view.ViewGroup;

/**
 * @ClassName: OnItemClickListener
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/26 15:09
 */
public interface OnItemClickListener {
    /**
     * @param helper
     * @param parent   如果是RecyclerView的话，parent为空
     * @param itemView
     * @param position
     */
    void onItemClick(LQRViewHolder helper, ViewGroup parent, View itemView, int position);
}
