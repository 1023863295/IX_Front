package com.crf.ix.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.crf.ix.R;
import com.crf.ix.base.BaseActivity;
import com.crf.ix.presenter.PasswardLoginPresenter;
import com.crf.ix.presenter.contract.PasswardLoginContract;

/**
 * @ClassName: PasswardLoginAty
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/8/28 15:57
 */
public class PasswardLoginAty extends BaseActivity<PasswardLoginPresenter,Object> implements View.OnClickListener,PasswardLoginContract.View{
    private ImageView imgBack;
    private TextView textTitle;
    private TextView textRight;

    private TextView textPhone;
    private EditText editPassword;

    private TextView textCodeLogin;
    private TextView textForget;
    private Button btnLogin;
//    private TextView textRegister;

    @Override
    public int getLayoutId() {
        return R.layout.aty_password_login;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initView() {
        imgBack = (ImageView)findViewById(R.id.head_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView)findViewById(R.id.head_text_title);
        textTitle.setText("密码登录");
        textRight = (TextView)findViewById(R.id.head_text_right);
        textRight.setVisibility(View.INVISIBLE);

        textPhone = (TextView)findViewById(R.id.password_text_write_telephone);
        editPassword = (EditText)findViewById(R.id.password_edit_password);
        textPhone.setText("手机号为"+getIntent().getStringExtra("phone"));

        textCodeLogin = (TextView)findViewById(R.id.password_text_code_login);
        textCodeLogin.setOnClickListener(this);
        textForget = (TextView)findViewById(R.id.password_text_forget_password);
        textForget.setOnClickListener(this);
        btnLogin = (Button)findViewById(R.id.password_btn_login);
        btnLogin.setOnClickListener(this);
//        textRegister = (TextView)findViewById(R.id.password_text_register);
//        textRegister.setOnClickListener(this);

        mPresenter.attachView(this,this);
    }

    @Override
    public PasswardLoginPresenter getPresenter() {
        return new PasswardLoginPresenter();
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
            case R.id.password_btn_login:
                mPresenter.login("","");
                break;
            case R.id.password_text_code_login:
                Intent intent = new Intent(this,CodeLoginAty.class);
                startActivity(intent);
                break;
            case R.id.password_text_forget_password:
                Intent intentForget = new Intent(this,ForgetPasswordAty.class);
                startActivity(intentForget);
                break;
//            case R.id.password_text_register:
//                Intent intentRegister = new Intent(this,RegisterAty.class);
//                startActivity(intentRegister);
//                break;
        }

    }
}
