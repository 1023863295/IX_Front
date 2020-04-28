package com.crf.ix.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.crf.ix.R;
import com.crf.ix.base.BaseActivity;

/**
 * @ClassName: RegisterResultAty
 * @Description: 注册结果页面
 * @Author: liuliang
 * @CreateDate: 2018/8/29 17:34
 */
public class RegisterResultAty extends BaseActivity implements View.OnClickListener{
    private ImageView imgBack;
    private TextView textTitle;
    private TextView textRight;

    private Button btnOpen;

    @Override
    public int getLayoutId() {
        return R.layout.aty_register_result;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initView() {
        imgBack = (ImageView)findViewById(R.id.head_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView)findViewById(R.id.head_text_title);
        textTitle.setText("注册结果");
        textRight = (TextView)findViewById(R.id.head_text_right);
        textRight.setVisibility(View.VISIBLE);
        textRight.setText("返回首页");
        textRight.setOnClickListener(this);

        btnOpen = (Button)findViewById(R.id.register_result_btn_open);
        btnOpen.setOnClickListener(this);
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
            case R.id.register_result_btn_open:
                Intent intent = new Intent(this,OpenAccountAty.class);
                startActivity(intent);
                break;
        }
    }
}
