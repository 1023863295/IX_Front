package com.crf.ix.presenter;

import com.crf.ix.base.BasePresenter;
import com.crf.ix.presenter.contract.OpenAccontContract;

/**
 * @ClassName: OpenAccountPresenter
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/4 10:40
 */
public class OpenAccountPresenter extends BasePresenter<OpenAccontContract.View> implements OpenAccontContract.Presenter {

    @Override
    public void openAccount(String name, String id, String cardNo, String phone, String code) {

        mView.get().showDataSuccess(null);
    }
}
