package com.crf.ix.adapter;

import android.view.View;
import android.view.ViewGroup;

/**
 * @ClassName: OnItemLongClickListener
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/26 15:10
 */
public interface OnItemLongClickListener {
    /**
     * @param helper
     * @param parent   如果是RecyclerView的话，parent为空
     * @param itemView
     * @param position
     */
    boolean onItemLongClick(LQRViewHolder helper, ViewGroup parent, View itemView, int position);
}
