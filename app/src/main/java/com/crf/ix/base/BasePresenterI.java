package com.crf.ix.base;

import android.content.Context;

/**
 * @ClassName: BasePresenterI
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/8/23 18:31
 */
public interface BasePresenterI {
    /**
     * 判断网络连接
     * */
    boolean checkNetWork(Context context);

//    void unsubcrible();

    void  detachView();
}
