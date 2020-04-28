package com.crf.ix.presenter;

import com.crf.ix.base.BasePresenter;
import com.crf.ix.bean.ChargeRequest;
import com.crf.ix.bean.Test;
import com.crf.ix.http.ApiRetrofit;
import com.crf.ix.presenter.contract.RechargeContract;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @ClassName: ChargePresenter
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/18 11:33
 */
public class ChargePresenter extends BasePresenter implements RechargeContract.Presenter {
    @Override
    public void charge() {
        ChargeRequest chargeRequest = new ChargeRequest();
        chargeRequest.setAgentBusinessType("chujie");
        chargeRequest.setApplyTime("2018-09-17 15:05:59");
        chargeRequest.setBankCode("CCB");
        chargeRequest.setBusiness_type("rcs");
        chargeRequest.setExternalAccount("13585868152");
        chargeRequest.setRemarks("委托充值测试1分钱");
        chargeRequest.setRequestRefNo("83f150c528f34d1fb1d8447a485cf5a7");
        chargeRequest.setTransferAmount("1");
        chargeRequest.setUserName("杨悦");

        ApiRetrofit.getInstance().charge(chargeRequest)
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

                    }
                });

    }
}
