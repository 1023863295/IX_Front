package com.crf.ix.presenter.contract;

import com.crf.ix.base.BaseViewI;

/**
 * @ClassName: MineFragmentContract
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/18 10:57
 */
public interface MineFragmentContract {
    interface View extends BaseViewI<Object> {

    };

    interface Presenter{
        void getBalance(String account);
    }
}
