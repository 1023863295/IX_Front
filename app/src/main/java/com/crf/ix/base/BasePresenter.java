package com.crf.ix.base;

import android.content.Context;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * @ClassName: BasePresenter
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/8/23 18:32
 */
public class BasePresenter <V extends BaseViewI> implements BasePresenterI {
    protected Reference<V> mView;
//    public V mView;
    public Context mContext;


    public void attachView(V view,Context context) {
        this.mView = new WeakReference<V>(view);
        this.mContext=context;
    }
    @Override
    public void detachView() {
        if (mView != null) {
            mView.clear();
            mView = null;
        }
    }


    @Override
    public boolean checkNetWork(Context context) {
        return false;
    }

//    @Override
//    public void unsubcrible() {
//        mView=null;
//        mContext=null;
//    }
}
