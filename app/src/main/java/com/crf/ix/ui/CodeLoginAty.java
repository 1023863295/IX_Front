package com.crf.ix.ui;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.crf.ix.presenter.CodeLoginPresenter;
import com.crf.ix.presenter.contract.CodeLoginContract;
import com.crf.ix.R;
import com.crf.ix.base.BaseActivity;
import com.crf.ix.utils.StringUtils;
import com.crf.ix.widget.view.PasswordView;

/**
 * @ClassName: CodeLoginAty
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/8/28 17:11
 */
public class CodeLoginAty extends BaseActivity<CodeLoginPresenter,Object> implements View.OnClickListener,CodeLoginContract.View {
    private ImageView imgBack;
    private TextView textTitle;
    private TextView textRight;

    private PasswordView passwordView;
    private TextView textTimeTips;

    @Override
    public int getLayoutId() {
        return R.layout.aty_code_login;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initView() {
        imgBack = (ImageView) findViewById(R.id.head_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView) findViewById(R.id.head_text_title);
        textTitle.setText("验证码登录");
        textRight = (TextView) findViewById(R.id.head_text_right);
        textRight.setVisibility(View.INVISIBLE);

        passwordView = (PasswordView)findViewById(R.id.codelogin_passwordview);
        passwordView.setPasswordListener(new PasswordView.PasswordListener() {
            @Override
            public void passwordChange(String changeText) {

            }

            @Override
            public void passwordComplete() {
                mPresenter.login("13476183516",passwordView.getPassword());
            }

            @Override
            public void keyEnterPress(String password, boolean isComplete) {

            }
        });

        textTimeTips = (TextView) findViewById(R.id.code_text_time_tips);
        String content =  "39s" + "后重新发送";
        textTimeTips.setText(StringUtils.matcherSearchText(Color.RED,content,"39s"));
        textTimeTips.setOnClickListener(this);
        mPresenter.attachView(this,this);
    }

    @Override
    public CodeLoginPresenter getPresenter() {
        return new CodeLoginPresenter();
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
            case R.id.code_text_time_tips:
                mPresenter.login("13476183516",passwordView.getPassword());
                break;
        }
    }
}
