package com.crf.ix.presenter;

import android.content.Context;

import com.crf.ix.base.BasePresenter;
import com.crf.ix.bean.ChargeRequest;
import com.crf.ix.bean.Test;
import com.crf.ix.bean.WithDrawRequest;
import com.crf.ix.http.ApiRetrofit;
import com.crf.ix.presenter.contract.WithDrawContrtact;

import java.util.HashMap;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @ClassName: WithDrawPresenter
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/18 11:19
 */
public class WithDrawPresenter extends BasePresenter<WithDrawContrtact.View> implements WithDrawContrtact.Presenter {
    @Override
    public void withDraw() {
        WithDrawRequest withDrawRequest = new WithDrawRequest();
        withDrawRequest.setAgentBusinessType("chujie");
        withDrawRequest.setApplyTime("2018-09-17 15:29:38");
        withDrawRequest.setBankCode("CCB");
        withDrawRequest.setBusiness_type("rcs");
        withDrawRequest.setCallBackUrl("");
        withDrawRequest.setExternalAccount("13585868152");
        withDrawRequest.setRequestRefNo("16a752f7a77342f885e909062a0461c7");
        withDrawRequest.setTransferAmount("2");
        withDrawRequest.setUserName("杨悦");

        ApiRetrofit.getInstance().withDraw(withDrawRequest)
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
