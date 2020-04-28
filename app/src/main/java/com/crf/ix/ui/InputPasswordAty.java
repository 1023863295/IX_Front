package com.crf.ix.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.crf.ix.R;
import com.crf.ix.base.BaseActivity;
import com.crf.ix.widget.view.PasswordView;

/**
 * @ClassName: InputPasswordAty
 * @Description: java类描述  弹框输入密码页面
 * @Author: liuliang
 * @CreateDate: 2018/9/10 14:43
 */
public class InputPasswordAty extends BaseActivity implements View.OnClickListener{
    private ImageView imgBack;
    private TextView textTitle;
    private TextView textRight;

    private TextView textForgetPassword;
    private PasswordView passwordView;



    @Override
    public int getLayoutId() {
        return R.layout.aty_input_password;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initView() {
        imgBack = (ImageView)findViewById(R.id.head_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView)findViewById(R.id.head_text_title);
        textTitle.setText("交易密码");

        textRight = (TextView)findViewById(R.id.head_text_right);
        textRight.setVisibility(View.GONE);


        textForgetPassword = (TextView)findViewById(R.id.input_text_forget_password);
        textForgetPassword.setOnClickListener(this);
        passwordView = (PasswordView)findViewById(R.id.input_text_password_view);
        passwordView.setPasswordListener(new PasswordView.PasswordListener() {
            @Override
            public void passwordChange(String changeText) {

            }

            @Override
            public void passwordComplete() {
                Intent intent = new Intent(InputPasswordAty.this,ChargeDrawResultAty.class);
                intent.putExtra("type",1);
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

                break;
            case R.id.input_text_forget_password:
                break;
        }

    }
}
