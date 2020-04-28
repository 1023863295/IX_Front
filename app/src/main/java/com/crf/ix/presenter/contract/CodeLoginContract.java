package com.crf.ix.presenter.contract;

import com.crf.ix.base.BaseViewI;

/**
 * @ClassName: CodeContract
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/8/31 13:57
 */
public interface CodeLoginContract {
    interface View extends BaseViewI<Object> {

    };

    interface Presenter{
        void login(String phone,String code);

    }
}
