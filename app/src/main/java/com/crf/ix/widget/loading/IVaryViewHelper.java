package com.crf.ix.widget.loading;

import android.content.Context;
import android.view.View;

/**
 * @ClassName: IVaryViewHelper
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/8/27 11:32
 */
public interface IVaryViewHelper {
    public abstract View getCurrentLayout();

    public abstract void restoreView();

    public abstract void showLayout(View view);

    public abstract View inflate(int layoutId);

    public abstract Context getContext();

    public abstract View getView();
}
