package com.crf.ix.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.crf.ix.R;
import com.crf.ix.base.BaseActivity;
import com.crf.ix.presenter.ChargePresenter;
import com.crf.ix.presenter.contract.RechargeContract;
import com.crf.ix.utils.ToastUtil;
import com.crf.ix.widget.view.ClearEditText;

/**
 * @ClassName: RechargeAty
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/7 13:34
 */
public class RechargeAty extends BaseActivity<ChargePresenter,Object> implements View.OnClickListener,RechargeContract.View{
    private ImageView imgBack;
    private TextView textTitle;
    private TextView textRight;

    private TextView textLable;
    private TextView textBank;
    private TextView textTips;
    private ClearEditText editAmount;
    private TextView textAll;
    private Button btnNext;
    private TextView textProtocol;
    private CheckBox checkBox;

    @Override
    public int getLayoutId() {
        return R.layout.aty_recharge;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initView() {
        imgBack = (ImageView) findViewById(R.id.head_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView) findViewById(R.id.head_text_title);
        textTitle.setText("充值");
        textRight = (TextView) findViewById(R.id.head_text_right);
        textRight.setVisibility(View.INVISIBLE);

        textLable = (TextView)findViewById(R.id.recharge_text_lable);
        textBank = (TextView)findViewById(R.id.recharge_text_bankname);
        textTips = (TextView)findViewById(R.id.recharge_text_tips);
        editAmount = (ClearEditText)findViewById(R.id.recharge_edit_amount);
        textAll = (TextView)findViewById(R.id.recharge_text_all);
        textAll.setVisibility(View.GONE);
        btnNext = (Button)findViewById(R.id.recharge_btn_next);
        btnNext.setOnClickListener(this);
        checkBox = (CheckBox)findViewById(R.id.recharge_rb);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ToastUtil.showShortToast(RechargeAty.this, isChecked+"");
            }
        });
        textProtocol = (TextView)findViewById(R.id.recharge_text_protocol);
        textProtocol.setOnClickListener(this);

        mPresenter.attachView(this,this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public ChargePresenter getPresenter() {
        return new ChargePresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.head_img_back:
                finish();
                break;
            case R.id.recharge_text_protocol:
                Intent intentProtocol = new Intent(this,CustomWebAty.class);
                intentProtocol.putExtra("type",4);
                startActivity(intentProtocol);
                break;
            case R.id.recharge_btn_next:
//                Intent intent = new Intent(this,ChargeDrawResultAty.class);
//                intent.putExtra("type",0);
//                startActivity(intent);
                mPresenter.charge();
                break;
        }
    }
}
