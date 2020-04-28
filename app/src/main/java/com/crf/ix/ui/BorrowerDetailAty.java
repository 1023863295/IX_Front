package com.crf.ix.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.crf.ix.R;
import com.crf.ix.base.BaseActivity;

/**
 * @ClassName: BorrowerDetailAty
 * @Description: java类描述 借款人详情页面
 * @Author: liuliang
 * @CreateDate: 2018/9/27 10:41
 */
public class BorrowerDetailAty extends BaseActivity implements View.OnClickListener{
    private ImageView imgBack;
    private TextView textTitle;
    private TextView textRight;


    @Override
    public int getLayoutId() {
        return R.layout.aty_borrower_detail;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initView() {
        imgBack = (ImageView)findViewById(R.id.head_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView)findViewById(R.id.head_text_title);
        textTitle.setText("借款人详情");
        textRight = (TextView)findViewById(R.id.head_text_right);
        textRight.setVisibility(View.GONE);
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
        }

    }
}
