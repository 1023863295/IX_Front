package com.crf.ix.presenter.contract;

import com.crf.ix.base.BaseViewI;

/**
 * @ClassName: MainFragmentContract
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/20 15:06
 */
public interface MainFragmentContract {

    interface View extends BaseViewI<Object> {

    };

    interface Presenter{

        void getDate();
    }
}
