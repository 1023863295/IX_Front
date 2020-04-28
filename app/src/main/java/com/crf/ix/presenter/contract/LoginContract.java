package com.crf.ix.presenter.contract;

import com.crf.ix.base.BaseViewI;

/**
 * @ClassName: LoginContract
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/8/30 17:34
 */
public interface LoginContract {

    interface View extends BaseViewI<Object> {

    };

    interface Presenter{
        void next(String content);
    }
}
