package com.crf.ix.presenter;

import android.content.Intent;

import com.crf.ix.base.BasePresenter;
import com.crf.ix.ui.GestureAty;
import com.crf.ix.utils.ToastUtil;
import com.crf.ix.presenter.contract.PasswardLoginContract;

/**
 * @ClassName: PasswardLoginPresenter
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/8/31 13:33
 */
public class PasswardLoginPresenter extends BasePresenter<PasswardLoginContract.View> implements PasswardLoginContract.Presenter {
    @Override
    public void login(String phone,String password) {
        ToastUtil.showShortToast(mContext,"正在开发");
        Intent intentGesture = new Intent(mContext,GestureAty.class);
        mContext.startActivity(intentGesture);
    }
}
