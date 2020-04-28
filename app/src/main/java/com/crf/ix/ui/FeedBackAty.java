package com.crf.ix.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.crf.ix.R;
import com.crf.ix.base.BaseActivity;

/**
 * @ClassName: FeedBackAty
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/6 17:57
 */
public class FeedBackAty extends BaseActivity implements View.OnClickListener{
    private ImageView imgBack;
    private TextView textTitle;
    private TextView textRight;

    private EditText editContent;
    private TextView textCount;

    @Override
    public int getLayoutId() {
        return R.layout.aty_feed_back;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initView() {
        imgBack = (ImageView) findViewById(R.id.head_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView) findViewById(R.id.head_text_title);
        textTitle.setText("意见反馈");
        textRight = (TextView) findViewById(R.id.head_text_right);
        textRight.setText("提交");
        textRight.setVisibility(View.VISIBLE);
        textRight.setOnClickListener(this);

        editContent = (EditText)findViewById(R.id.feed_back_edit_content);
        textCount = (TextView)findViewById(R.id.feed_back_text_count);

        editContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textCount.setText(s.length()+"/1000");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.head_img_back:
                finish();
                break;
            case R.id.head_text_right:
                break;
        }

    }
}
