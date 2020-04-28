package com.crf.ix.ui;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.crf.ix.presenter.LoginPresenter;
import com.crf.ix.presenter.contract.LoginContract;
import com.crf.ix.R;
import com.crf.ix.base.BaseActivity;
import com.crf.ix.widget.view.ClearEditText;

/**
 * @ClassName: LoginAty
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/8/28 13:27
 */
public class LoginAty extends BaseActivity<LoginPresenter,Object>implements View.OnClickListener,LoginContract.View {
    private ImageView imgBack;
    private TextView textTitle;
    private TextView textRight;

    private ClearEditText editPhone;
    private Button btnNext;

    @Override
    public int getLayoutId() {
        return R.layout.aty_login;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initView() {
        imgBack = (ImageView)findViewById(R.id.head_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView)findViewById(R.id.head_text_title);
        textTitle.setText("登录注册");
        textRight = (TextView)findViewById(R.id.head_text_right);
        textRight.setVisibility(View.INVISIBLE);

        editPhone = (ClearEditText)findViewById(R.id.login_edit_phone);
        btnNext = (Button)findViewById(R.id.login_btn_next);
        btnNext.setOnClickListener(this);

        mPresenter.attachView(this, this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public LoginPresenter getPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.head_img_back:
                finish();
                break;
            case R.id.login_btn_next:
                mPresenter.next(editPhone.getText().toString());
                break;
        }
    }

}
