package com.crf.ix.ui;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.crf.ix.R;
import com.crf.ix.base.BaseActivity;

/**
 * @ClassName: ChargeDrawResultAty
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/10 13:59
 */
public class ChargeDrawResultAty extends BaseActivity implements View.OnClickListener{
    private ImageView imgBack;
    private TextView textTitle;
    private TextView textRight;

    private ImageView imgLogo;
    private TextView textResultTips;
    private Button btnOpen;
    private TextView textProtocol;

    private int type = 0 ; // 0 充值，  1 提现

    @Override
    public int getLayoutId() {
        return R.layout.aty_register_result;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initView() {
        imgBack = (ImageView)findViewById(R.id.head_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView)findViewById(R.id.head_text_title);

        textRight = (TextView)findViewById(R.id.head_text_right);
        textRight.setVisibility(View.GONE);
        textResultTips = (TextView)findViewById(R.id.register_result_text_tips);
        imgLogo = (ImageView)findViewById(R.id.register_resut_img_logo);

        if (type == 0){
            textTitle.setText("充值结果");
            textResultTips.setText("充值成功");
            imgLogo.setImageResource(R.drawable.charge_result);
        }else{
            textTitle.setText("提现结果");
            textResultTips.setText("提现成功");
            imgLogo.setImageResource(R.drawable.with_draw);
        }
        btnOpen = (Button)findViewById(R.id.register_result_btn_open);
        btnOpen.setText("完成");
        btnOpen.setOnClickListener(this);
        textProtocol = (TextView)findViewById(R.id.register_result_text_protocol);
        textProtocol.setVisibility(View.GONE);
    }

    @Override
    protected void initData() {
        type = getIntent().getIntExtra("type",0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.head_img_back:
                finish();
                break;
            case R.id.register_result_btn_open:
                finish();
                break;
        }

    }
}
