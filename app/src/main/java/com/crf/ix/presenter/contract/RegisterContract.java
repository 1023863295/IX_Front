package com.crf.ix.presenter.contract;

import com.crf.ix.base.BaseViewI;

/**
 * @ClassName: RegisterContract
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/8/31 14:24
 */
public interface RegisterContract {
    interface View extends BaseViewI<Object> {

    };

    interface Presenter{
        void register(String phone,String code,String password);


        void sendCode(String phone);
    }
}
