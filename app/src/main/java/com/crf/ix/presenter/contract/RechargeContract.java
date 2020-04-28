package com.crf.ix.presenter.contract;

import com.crf.ix.base.BaseViewI;

/**
 * @ClassName: RechargeContract
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/18 11:32
 */
public interface RechargeContract {
    interface View extends BaseViewI<Object> {

    };

    interface Presenter{
        void charge();

    }
}
