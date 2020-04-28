package com.crf.ix.utils;


import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.RadioGroup;

/**
 * @ClassName: PopupwindowUtil
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/28 14:21
 */
public class PopupwindowUtil extends PopupWindow {
    private static PopupwindowUtil mPopupwindowUtil;
    private Context mContext;

    public PopupwindowUtil(View contentView) {
        super(contentView);
    }

    public PopupwindowUtil(Context context) {
        super(context);
        mContext = context;
    }
    public static PopupwindowUtil getInstance(@NonNull Context context) {
        if (null == context) {
            throw new IllegalArgumentException("Context can't be null!");
        }
        if (null == mPopupwindowUtil) {
            synchronized (PopupwindowUtil.class) {
                if (null == mPopupwindowUtil) {
                    mPopupwindowUtil = new PopupwindowUtil(context);
                }
            }
        }
        //非正常情况处理
        mDismiss();
        return mPopupwindowUtil;
    }
    /**
     * 必须设置，否则pop无法填充满整个屏幕
     *
     * @param background
     *
     * @return
     */
    public PopupwindowUtil mBackground(Drawable background) {
        setBackgroundDrawable(background);
        return mPopupwindowUtil;
    }

    public PopupwindowUtil mAnimationStyle(int animationStyle) {
        setAnimationStyle(animationStyle);
        return mPopupwindowUtil;
    }

    public PopupwindowUtil mLoadView(int layoutID) {
        if (0 == layoutID) {
            throw new IllegalArgumentException("This layoutID is invalid!");
        }
        View contentView = null;
        if (null != mContext) {
            contentView = LayoutInflater.from(mContext).inflate(layoutID, null);
        }
        if (null == contentView) {
            throw new RuntimeException("This layout can't be load!");
        }
        setContentView(contentView);
        return mPopupwindowUtil;
    }

    public PopupwindowUtil mWidthHeight(int width, int height) {
        setWidth(width);
        setHeight(height);
        return mPopupwindowUtil;
    }

    public PopupwindowUtil mFocusable(boolean able) {
        setFocusable(able);
        return mPopupwindowUtil;
    }

    public PopupwindowUtil mTouchable(boolean able) {
        setTouchable(able);
        return mPopupwindowUtil;
    }

    public PopupwindowUtil mOutsideTouchable(final boolean able) {
        setOutsideTouchable(able);
        setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (!isOutsideTouchable()) {
                    View mView = getContentView();
                    if (null != mView) {
                        mView.dispatchTouchEvent(event);
                    }
                }
                return isFocusable() && !isOutsideTouchable();
            }
        });
        return mPopupwindowUtil;
    }

    public PopupwindowUtil mSoftInputMode(int mode) {
        setSoftInputMode(mode);
        return mPopupwindowUtil;
    }

    public <T extends View> PopupwindowUtil mViewAction(int mViewID,final ViewAction<T> mViewAction) {
        View mContentView = getContentView();
        if (null != mContentView) {
            View mView = mContentView.findViewById(mViewID);
            if (null != mView) {
                mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mViewAction.action(mPopupwindowUtil, (T) v);
                    }
                });
            }
        }
        return mPopupwindowUtil;
    }

    public <T extends View> PopupwindowUtil mViewActions(final ViewActions<T> mViewActions, Integer... mViewIDs) {
        View mContentView = getContentView();
        if (null != mContentView) {
            for (int mViewID : mViewIDs) {
                View mView = mContentView.findViewById(mViewID);
                mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mViewActions.action(null != v ? (T) v : null, v.getId());
                    }
                });
            }
        }
        return mPopupwindowUtil;
    }

    public PopupwindowUtil mCheckAction(int mViewID, final PopupAction mPopupAction) {
        final View mContentView = getContentView();
        if (null != mContentView) {
            View mView = mContentView.findViewById(mViewID);
            if (null != mView && mView instanceof RadioGroup) {
                ((RadioGroup) mView).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        mPopupAction.action(PopupwindowUtil.this, mContentView, group, checkedId);
                    }
                });
            }
        }
        return mPopupwindowUtil;
    }

    public PopupwindowUtil mClickAction(int mViewID, final PopupAction mPopupAction) {
        final View mContentView = getContentView();
        if (null != mContentView) {
            View mView = mContentView.findViewById(mViewID);
            if (null != mView) {
                mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPopupAction.action(PopupwindowUtil.this, mContentView, null, -1);
                    }
                });
            }
        }
        return mPopupwindowUtil;
    }

    public void mShowAtLocation(View parent, int gravity, int x, int y) {
        if (null != parent.getContext() && parent.isShown()) {
            showAtLocation(parent, gravity, x, y);
        }
    }

    public void mshowAsDropDown(View parent) {
        if (null != parent.getContext() && parent.isShown()) {
            showAsDropDown(parent);
        }
    }

    public PopupwindowUtil mDisMissListener(OnDismissListener mOnDismissListener) {
        setOnDismissListener(mOnDismissListener);
        return mPopupwindowUtil;
    }

    public PopupwindowUtil mDisMissAction(int mViewID) {
        View mContentView = getContentView();
        if (null != mContentView) {
            View mView = mContentView.findViewById(mViewID);
            if (null != mView) {
                mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDismiss();
                    }
                });
            }
        }
        return mPopupwindowUtil;
    }

    public PopupwindowUtil mDisMissAction(View mView) {
        if (null != mView) {
            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDismiss();
                }
            });
        }
        return mPopupwindowUtil;
    }

    private static void mDismiss() {
        if (null != mPopupwindowUtil && mPopupwindowUtil.isShowing()) {
            mPopupwindowUtil.dismiss();
        }
    }

    public interface PopupAction {
        void action(PopupWindow mPopupWindow, @Nullable View mContentView, @Nullable RadioGroup group, int checkedId);
    }

    public interface ViewAction<T extends View> {
        void action(PopupwindowUtil mPopupwindowUtil, T mView);
    }

    public interface ViewActions<T extends View> {
        void action(T mView, int mViewId);
    }


    /**
     * 控制窗口背景的不透明度
     */
    private void setWindowBackgroundAlpha(float alpha) {
        if (mContext == null){
            return;
        }
        if (mContext instanceof Activity) {
            Window window = ((Activity) mContext).getWindow();
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            layoutParams.alpha = alpha;
            window.setAttributes(layoutParams);
        }
    }
}
