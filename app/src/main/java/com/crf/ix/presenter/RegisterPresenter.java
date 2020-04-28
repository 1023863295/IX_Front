package com.crf.ix.presenter;

import com.crf.ix.base.BasePresenter;
import com.crf.ix.bean.Test;
import com.crf.ix.http.ApiRetrofit;
import com.crf.ix.presenter.contract.RegisterContract;
import com.crf.ix.utils.LogUtils;
import com.crf.ix.utils.ToastUtil;

import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @ClassName: RegisterPresenter
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/8/31 14:25
 */
public class RegisterPresenter extends BasePresenter<RegisterContract.View> implements RegisterContract.Presenter {
    @Override
    public void register(String phone, String code, String password) {
        mView.get().showDataSuccess(null);

        ApiRetrofit.getInstance().register(phone,code,"channel",password,"android","123456789")
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Test>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Test test) {
                        LogUtils.d(test.toString());

                    }
                });
    }

    @Override
    public void sendCode(String phone) {
        ApiRetrofit.getInstance().sendCode(phone)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Test>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Test test) {
                        LogUtils.d("info:"+test.getInfo()+"code:"+test.getCode()+"data"+test.getData());
                        if (test.getCode() == 0){
                            ToastUtil.showShortToast(mContext,"验证码发送成功");
                        }else{
                            ToastUtil.showShortToast(mContext,test.getInfo());
                        }
                    }
                });
    }
}
