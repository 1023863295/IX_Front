package com.crf.ix.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crf.ix.widget.dialog.LoadingFragmentDialog;
import com.crf.ix.widget.loading.VaryViewHelperController;

/**
 * @ClassName: BaseFragment
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/8/27 11:18
 */
public abstract class BaseFragment<T extends BasePresenterI, V>  extends Fragment implements BaseViewI<V> {
    private String TAG ;
    protected View mRootView;
    protected T mPresenter;
    private LoadingFragmentDialog loadDialogView;
    protected VaryViewHelperController mVaryViewHelperController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (null == mRootView) {
            mRootView = inflater.inflate(getContentLayout(), container, false);
            TAG=this.getClass().getSimpleName();
            if (null != getLoadingTargetView()) {
                mVaryViewHelperController = new VaryViewHelperController(getLoadingTargetView());
            }

            if (null != getPresenter()) {
                mPresenter = getPresenter();
            }

            initView(mRootView);
            initData();
        } else {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (null != parent) {
                parent.removeView(mRootView);
            }
        }
        return mRootView;
    }

    protected abstract void initData();

    protected abstract void initView(View RootView);


    protected abstract int getContentLayout();

    public T getPresenter() {
        return null;
    }

    /**
     * 具体在哪个部位显示加载中，加载失败，网络异常等
     * */
    protected View getLoadingTargetView() {
        return null;
    }

    /**
     * 显示加载弹框
     */
    @Override
    public void showProgress() {
        if (loadDialogView == null) {
            loadDialogView = LoadingFragmentDialog.createDialog(getActivity());
        }

        loadDialogView.show();
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
    public void showLoadingView() {
        if (mVaryViewHelperController == null) {
            throw new IllegalStateException("no ViewHelperController");
        }
        mVaryViewHelperController.showLoading();
    }

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
    public void showEmptyView(String msg) {
        if (mVaryViewHelperController == null) {
            throw new IllegalStateException("no ViewHelperController");
        }
        mVaryViewHelperController.showEmpty(msg);
    }

    @Override
    public void showContent() {
        if (mVaryViewHelperController == null) {
            throw new IllegalStateException("no ViewHelperController");
        }
        mVaryViewHelperController.restore();
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
