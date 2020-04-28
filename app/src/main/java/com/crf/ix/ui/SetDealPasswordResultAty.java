package com.crf.ix.ui;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.crf.ix.base.BaseActivity;
import com.crf.ix.utils.ToastUtil;
import com.crf.ix.R;

/**
 * @ClassName: SetDealPasswordResultAty
 * @Description: java类描述 交易密码设置成功
 * @Author: liuliang
 * @CreateDate: 2018/9/4 13:00
 */
public class SetDealPasswordResultAty extends BaseActivity implements View.OnClickListener{
    private ImageView imgBack;
    private TextView textTitle;
    private TextView textRight;

    private ImageView imgLogo;
    private TextView textResult;
    private TextView textTips;
    private Button btnRiskEvaluation ;

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
        textTitle.setText("交易密码设置");
        textRight = (TextView)findViewById(R.id.head_text_right);
        textRight.setVisibility(View.VISIBLE);
        textRight.setText("完成");
        textRight.setOnClickListener(this);

        imgLogo = (ImageView)findViewById(R.id.open_account_succ_img_logo);
        imgLogo.setImageResource(R.drawable.lock);
        textResult = (TextView)findViewById(R.id.open_account_succ_text_result);
        textResult.setText("您的交易密码已设置成功");

        textTips = (TextView)findViewById(R.id.open_account_succ_text_tips);
        textTips.setText("在您投资前需评测您的投资风险偏好");
        btnRiskEvaluation = (Button)findViewById(R.id.open_account_succ_btn_open);
        btnRiskEvaluation.setText("评测风险偏好");
        btnRiskEvaluation.setOnClickListener(this);
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
            case R.id.open_account_succ_btn_open:
                ToastUtil.showShortToast(this,"正在开发");
//                Intent intent = new Intent(this,SetDealPasswordResultAty.class);
//                startActivity(intent);
                break;
        }

    }
}
