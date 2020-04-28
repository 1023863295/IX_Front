package com.crf.ix.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.crf.ix.widget.dialog.LoadingActivityDialog;
import com.crf.ix.widget.loading.VaryViewHelperController;

/**
 * @ClassName: BaseActivity
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/8/27 11:04
 */
public abstract class BaseActivity<T extends BasePresenterI, V>  extends AppCompatActivity implements BaseViewI<V>{
    public T mPresenter;
    public Context context;
    private LoadingActivityDialog loadDialogView;
    protected VaryViewHelperController mVaryViewHelperController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        if (null != getPresenter()) {
            mPresenter = getPresenter();
        }
        initData();
        initView();
    }

    /**
     * Base基本类
     * */
    public abstract int getLayoutId();
    /**
     * 设置toolbar
     * */
    protected abstract void initToolbar();
    /**
     * 设置initView
     * */
    protected abstract void initView();

    protected abstract void initData();

    /**
     * 获取Presenter
     * */
    public T getPresenter() {
        return null;
    }



    @Override
    public void showLoadingView() {
        if (mVaryViewHelperController == null) {
            throw new IllegalStateException("no ViewHelperController");
        }
        mVaryViewHelperController.showLoading();
    }

    @Override
    public void showEmptyView(String msg) {
        if (mVaryViewHelperController == null) {
            throw new IllegalStateException("no ViewHelperController");
        }
        mVaryViewHelperController.showEmpty(msg);
    }

    /**
     * 加载失败的View
     * */
    @Override
    public void showNetErrorView() {
        if (mVaryViewHelperController == null) {
            throw new IllegalStateException("no ViewHelperController");
        }
        mVaryViewHelperController.showNetworkError(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onReload();
            }
        });
    }
    @Override
    public void showContent() {
        if (mVaryViewHelperController == null) {
            throw new IllegalStateException("no ViewHelperController");
        }
        mVaryViewHelperController.restore();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * 显示加载弹框
     */
    @Override
    public void showProgress() {
        if (loadDialogView == null) {
            loadDialogView = LoadingActivityDialog.createDialog(BaseActivity.this);
        }

        loadDialogView.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
            mPresenter.detachView();
//            mPresenter.unsubcrible();
        }
        if(loadDialogView!=null){
            loadDialogView.dismiss();
        }
    }

    /**
     * 隐藏加载弹框
     */
    @Override
    public void hideProgress() {
        if (loadDialogView != null) {
            loadDialogView.dismiss();
        }
    }

    @Override
    public void onReload() {

    }

    @Override
    public void showDataError(String errorMessage, int tag) {
        hideProgress();
    }

    @Override
    public void showDataSuccess(V datas) {
        hideProgress();
    }




}
