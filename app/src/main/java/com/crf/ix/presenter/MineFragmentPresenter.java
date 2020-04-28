package com.crf.ix.presenter;

import com.crf.ix.base.BasePresenter;
import com.crf.ix.bean.Test;
import com.crf.ix.http.ApiRetrofit;
import com.crf.ix.presenter.contract.MineFragmentContract;
import com.crf.ix.utils.LogUtils;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @ClassName: MineFragmentPresenter
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/18 10:58
 */
public class MineFragmentPresenter extends BasePresenter<MineFragmentContract.View> implements MineFragmentContract.Presenter{
    @Override
    public void getBalance(String account) {
        ApiRetrofit.getInstance().getBalance(account)
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
                        LogUtils.d(test.toString());
                    }
                });
    }
}
