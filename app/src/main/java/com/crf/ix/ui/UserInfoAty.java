package com.crf.ix.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.crf.ix.R;
import com.crf.ix.base.BaseActivity;
import com.crf.ix.utils.ToastUtil;

/**
 * @ClassName: UserInfoAty
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/7 11:03
 */
public class UserInfoAty extends BaseActivity implements View.OnClickListener{
    private ImageView imgBack;
    private TextView textTitle;
    private TextView textRight;

    private RelativeLayout rlStatus; //状态
    private int openType; // 0 未开通存管账户； 1未完成风险评测; 2,都已经完成

    private TextView textUserName;
    private TextView textUserId; //身份证
    private TextView textRiskType; //风险类型

    @Override
    public int getLayoutId() {
        return R.layout.aty_user_info;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initView() {
        imgBack = (ImageView) findViewById(R.id.head_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView) findViewById(R.id.head_text_title);
        textTitle.setText("个人资料");
        textRight = (TextView) findViewById(R.id.head_text_right);
        textRight.setVisibility(View.INVISIBLE);

        rlStatus = (RelativeLayout)findViewById(R.id.user_info_rl);
        rlStatus.setBackgroundResource(R.drawable.user_info_open_account);
        rlStatus.setOnClickListener(this);

        textUserName = (TextView)findViewById(R.id.user_info_text_name);
        textUserId = (TextView)findViewById(R.id.user_info_userid);
        textRiskType = (TextView)findViewById(R.id.user_info_text_risk_type);
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
            case R.id.user_info_rl:
                ToastUtil.showShortToast(this,"正在开发中");
                break;
        }
    }
}
