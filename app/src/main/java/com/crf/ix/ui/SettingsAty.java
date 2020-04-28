package com.crf.ix.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.crf.ix.R;
import com.crf.ix.base.BaseActivity;
import com.crf.ix.utils.ToastUtil;
import com.crf.ix.widget.view.OptionItemView;

/**
 * @ClassName: SettingsAty
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/6 16:40
 */
public class SettingsAty extends BaseActivity implements View.OnClickListener{
    private ImageView imgBack;
    private TextView textTitle;
    private TextView textRight;

    private OptionItemView ModifyLoginPassword;
    private OptionItemView gesturePassword; //手势密码
    private OptionItemView dealPassword; //交易密码
    private OptionItemView FeedBack; //意见反馈


    private TextView textLogout;  //退出登录


    @Override
    public int getLayoutId() {
        return R.layout.aty_settings;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initView() {
        imgBack = (ImageView) findViewById(R.id.head_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView) findViewById(R.id.head_text_title);
        textTitle.setText("设置");
        textRight = (TextView) findViewById(R.id.head_text_right);
        textRight.setVisibility(View.INVISIBLE);

        ModifyLoginPassword = (OptionItemView)findViewById(R.id.setting_modify_login_password);
        ModifyLoginPassword.setOnClickListener(this);
        gesturePassword = (OptionItemView)findViewById(R.id.setting_gestuer_password);
        gesturePassword.setOnClickListener(this);
        dealPassword = (OptionItemView)findViewById(R.id.setting_deal_password);
        dealPassword.setOnClickListener(this);
        FeedBack = (OptionItemView)findViewById(R.id.setting_feedback);
        FeedBack.setOnClickListener(this);
        textLogout = (TextView)findViewById(R.id.setting_text_logout);
        textLogout.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.head_img_back:
                finish();
                break;
            case R.id.setting_modify_login_password:
                Intent intentModify = new Intent(this,ModifyLoginPasswordAty.class);
                startActivity(intentModify);
                break;
            case R.id.setting_gestuer_password:
                Intent intentGesture = new Intent(this,CheckAccountAty.class);
                intentGesture.putExtra("from_type", 2);
                startActivity(intentGesture);
                break;
            case R.id.setting_deal_password:
                Intent intentDeal = new Intent(this,CheckAccountAty.class);
                intentDeal.putExtra("from_type", 2);
                startActivity(intentDeal);
                break;
            case R.id.setting_feedback:
                Intent intentFeed = new Intent(this,FeedBackAty.class);
                startActivity(intentFeed);
                break;
            case R.id.setting_text_logout:
                ToastUtil.showLongToast(this,"正在开发");
                break;
        }
    }
}
