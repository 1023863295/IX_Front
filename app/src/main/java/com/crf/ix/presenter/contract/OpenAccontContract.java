package com.crf.ix.presenter.contract;

import com.crf.ix.base.BaseViewI;

/**
 * @ClassName: OpenAccontContract
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/4 10:39
 */
public interface OpenAccontContract {
    interface View extends BaseViewI<Object> {

    };

    interface Presenter{

        void openAccount(String name,String id,String cardNo,String phone,String code);
    }
}
