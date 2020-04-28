package com.crf.ix.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.crf.ix.R;
import com.crf.ix.base.BaseActivity;
import com.crf.ix.widget.view.PasswordView;

/**
 * @ClassName: SetDealPasswordAty
 * @Description: java 设置交易密码
 * @Author: liuliang
 * @CreateDate: 2018/9/4 12:36
 */
public class SetDealPasswordAty extends BaseActivity implements View.OnClickListener{
    private ImageView imgBack;
    private TextView textTitle;
    private TextView textRight;

    private PasswordView passwordView;

    @Override
    public int getLayoutId() {
        return R.layout.aty_setdeal_password;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initView() {
        imgBack = (ImageView)findViewById(R.id.head_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView)findViewById(R.id.head_text_title);
        textTitle.setText("设置交易密码");
        textRight = (TextView)findViewById(R.id.head_text_right);
        textRight.setVisibility(View.GONE);

        passwordView = (PasswordView)findViewById(R.id.setdeal_password);
        passwordView.setPasswordListener(new PasswordView.PasswordListener() {
            @Override
            public void passwordChange(String changeText) {

            }

            @Override
            public void passwordComplete() {
                Intent intent = new Intent(SetDealPasswordAty.this,SetDealPasswordResultAty.class);
                startActivity(intent);
            }

            @Override
            public void keyEnterPress(String password, boolean isComplete) {

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
        }
    }
}
