package com.crf.ix.presenter;

import android.app.Activity;

import com.crf.ix.base.BasePresenter;
import com.crf.ix.presenter.contract.ForgetPasswordContract;
import com.crf.ix.utils.StringUtils;
import com.crf.ix.utils.ToastUtil;

/**
 * @ClassName: ForgetPasswordContract
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/8/31 14:12
 */
public class ForgetPasswordPresenter extends BasePresenter<ForgetPasswordContract.View> implements ForgetPasswordContract.Presenter{
    @Override
    public void setPassword(String firstStr, String secondStr) {
        if (StringUtils.isEmpty(firstStr) || StringUtils.isEmpty(secondStr) || firstStr.length() < 6 || secondStr.length() <6){
            ToastUtil.showShortToast(mContext,"请输入完整");
            return;
        }
        if (!firstStr.equals(secondStr)){
            ToastUtil.showShortToast(mContext,"两次输入不一致");
            ((Activity) mContext).finish();
            return;
        }
    }
}
