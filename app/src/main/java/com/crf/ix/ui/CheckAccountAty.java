package com.crf.ix.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.crf.ix.R;
import com.crf.ix.base.BaseActivity;
import com.crf.ix.widget.view.ClearEditText;

/**
 * @ClassName: CheckAccountAty
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/7 14:02
 */
public class CheckAccountAty extends BaseActivity implements View.OnClickListener{
    private ImageView imgBack;
    private TextView textTitle;
    private TextView textRight;//

    private int FROM_TYPE = 0; // 2：从设置-手势密码过来 ;  3，表示从设置-交易密码过来

    private TextView textPhone;
    private ClearEditText ediPassword;
    private Button btnCheck;

    @Override
    public int getLayoutId() {
        return R.layout.aty_check_account;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initView() {
        imgBack = (ImageView) findViewById(R.id.head_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView) findViewById(R.id.head_text_title);
        textTitle.setText("账户验证");
        textRight = (TextView) findViewById(R.id.head_text_right);
        textRight.setVisibility(View.INVISIBLE);

        textPhone = (TextView)findViewById(R.id.check_account_text_phone);
        ediPassword = (ClearEditText)findViewById(R.id.check_account_edit_password);
        btnCheck = (Button)findViewById(R.id.check_account_btn_check);
        btnCheck.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        FROM_TYPE = getIntent().getIntExtra("from_type",0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.head_img_back:
                finish();
                break;
            case R.id.check_account_btn_check:
                if (FROM_TYPE == 2){
                    Intent intent = new Intent(this,GestureAty.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(this,SetDealPasswordAty.class);
                    startActivity(intent);
                }
                break;
        }

    }
}
