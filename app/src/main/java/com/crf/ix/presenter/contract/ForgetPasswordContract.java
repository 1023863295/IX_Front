package com.crf.ix.presenter.contract;

import com.crf.ix.base.BaseViewI;

/**
 * @ClassName: ForgetPasswordContract
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/8/31 14:10
 */
public interface ForgetPasswordContract {
    interface View extends BaseViewI<Object> {

    };

    interface Presenter{
        void setPassword(String phone,String code);

    }
}
