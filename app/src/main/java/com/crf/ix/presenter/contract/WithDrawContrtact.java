package com.crf.ix.presenter.contract;

import com.crf.ix.base.BaseViewI;

/**
 * @ClassName: WithDrawPresenter
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/18 11:18
 */
public interface WithDrawContrtact {
    interface View extends BaseViewI<Object> {

    };

    interface Presenter{
        void withDraw();

    }
}
