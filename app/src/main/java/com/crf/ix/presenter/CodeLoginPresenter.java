package com.crf.ix.presenter;

import com.crf.ix.base.BasePresenter;
import com.crf.ix.presenter.contract.CodeLoginContract;
import com.crf.ix.utils.ToastUtil;

/**
 * @ClassName: CodePresenter
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/8/31 13:58
 */
public class CodeLoginPresenter extends BasePresenter<CodeLoginContract.View> implements CodeLoginContract.Presenter{
    @Override
    public void login(String phone, String code) {
        ToastUtil.showShortToast(mContext,"正在开发");
    }
}
