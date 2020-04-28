package com.crf.ix.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.crf.ix.base.BaseActivity;
import com.crf.ix.utils.ToastUtil;
import com.crf.ix.R;

/**
 * @ClassName: OpenAccountSuccessAty
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/4 11:26
 */
public class OpenAccountSuccessAty extends BaseActivity implements View.OnClickListener{
    private ImageView imgBack;
    private TextView textTitle;
    private TextView textRight;

    private Button btnSetPassword;

    @Override
    public int getLayoutId() {
        return R.layout.aty_open_account_success;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initView() {
        imgBack = (ImageView)findViewById(R.id.head_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView)findViewById(R.id.head_text_title);
        textTitle.setText("开通存管账户结果");
        textRight = (TextView)findViewById(R.id.head_text_right);
        textRight.setVisibility(View.VISIBLE);
        textRight.setText("完成");
        textRight.setOnClickListener(this);

        btnSetPassword = (Button)findViewById(R.id.open_account_succ_btn_open);
        btnSetPassword.setOnClickListener(this);
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
                ToastUtil.showShortToast(this,"正在开发");
                break;
            case R.id.open_account_succ_btn_open:
                Intent intent = new Intent(this,SetDealPasswordAty.class);
                startActivity(intent);
                break;
        }
    }
}
