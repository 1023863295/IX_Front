package com.crf.ix.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.crf.ix.R;
import com.crf.ix.base.BaseActivity;
import com.crf.ix.base.BasePresenter;

/**
 * @ClassName: MessageDetailAty
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/19 9:58
 */
public class MessageDetailAty extends BaseActivity {
    private ImageView imgBack;
    private TextView textTitle;
    private TextView textRight;

    @Override
    public int getLayoutId() {
        return R.layout.aty_message_detail;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initView() {
        imgBack = (ImageView) findViewById(R.id.head_img_back);
        imgBack.setVisibility(View.GONE);
        textTitle = (TextView) findViewById(R.id.head_text_title);
        textTitle.setText("消息详情");
        textRight = (TextView) findViewById(R.id.head_text_right);
        textRight.setVisibility(View.GONE);
    }

    @Override
    protected void initData() {

    }
}
