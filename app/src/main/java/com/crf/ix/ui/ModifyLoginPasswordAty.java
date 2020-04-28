package com.crf.ix.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.crf.ix.R;
import com.crf.ix.base.BaseActivity;

/**
 * @ClassName: ModifyLoginPasswordAty
 * @Description: java类描述  修改登录密码
 * @Author: liuliang
 * @CreateDate: 2018/9/6 17:09
 */
public class ModifyLoginPasswordAty extends BaseActivity implements View.OnClickListener{
    private ImageView imgBack;
    private TextView textTitle;
    private TextView textRight;

    @Override
    public int getLayoutId(){
        return R.layout.aty_modify_login_password;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initView() {
        imgBack = (ImageView) findViewById(R.id.head_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView) findViewById(R.id.head_text_title);
        textTitle.setText("修改登录密码");
        textRight = (TextView) findViewById(R.id.head_text_right);
        textRight.setVisibility(View.INVISIBLE);

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
