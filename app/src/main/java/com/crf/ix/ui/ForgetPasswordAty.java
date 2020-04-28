package com.crf.ix.ui;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.crf.ix.base.BaseActivity;
import com.crf.ix.presenter.ForgetPasswordPresenter;
import com.crf.ix.presenter.contract.ForgetPasswordContract;
import com.crf.ix.R;

/**
 * @ClassName: ForgetPasswordAty
 * @Description: java类描述 忘记密码
 * @Author: liuliang
 * @CreateDate: 2018/8/28 17:58
 */
public class ForgetPasswordAty extends BaseActivity<ForgetPasswordPresenter,Object> implements View.OnClickListener,ForgetPasswordContract.View {
    private ImageView imgBack;
    private TextView textTitle;
    private TextView textRight;

    private EditText editPasswordFirst;
    private EditText editPasswordSecond;
    private Button btnConfirm;

    @Override
    public int getLayoutId() {
        return R.layout.aty_forget_password;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initView() {
        imgBack = (ImageView)findViewById(R.id.head_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView)findViewById(R.id.head_text_title);
        textTitle.setText("重设登录密码");
        textRight = (TextView)findViewById(R.id.head_text_right);
        textRight.setVisibility(View.INVISIBLE);

        editPasswordFirst = (EditText)findViewById(R.id.forget_edit_password_first);
        editPasswordSecond = (EditText)findViewById(R.id.forget_edit_password_second);
        btnConfirm = (Button)findViewById(R.id.forget_btn_confirm);
        btnConfirm.setOnClickListener(this);
        mPresenter.attachView(this,this);
    }

    @Override
    public ForgetPasswordPresenter getPresenter() {
        return new ForgetPasswordPresenter();
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
            case R.id.forget_btn_confirm:
                mPresenter.setPassword(editPasswordFirst.getText().toString(),editPasswordSecond.getText().toString());
                break;
        }

    }
}
