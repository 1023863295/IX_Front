package com.crf.ix.ui;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.crf.ix.R;
import com.crf.ix.base.BaseActivity;
import com.crf.ix.presenter.WithDrawPresenter;
import com.crf.ix.presenter.contract.WithDrawContrtact;
import com.crf.ix.utils.StringUtils;
import com.crf.ix.utils.ToastUtil;
import com.crf.ix.widget.view.ClearEditText;

/**
 * @ClassName: WithdrawAty
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/7 16:21
 */
public class WithdrawAty extends BaseActivity<WithDrawPresenter,Object> implements View.OnClickListener,WithDrawContrtact.View{
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
        textTitle.setText("提现");
        textRight = (TextView) findViewById(R.id.head_text_right);
        textRight.setVisibility(View.INVISIBLE);

        textLable = (TextView)findViewById(R.id.recharge_text_lable);
        textLable.setText("到账银行卡");
        textBank = (TextView)findViewById(R.id.recharge_text_bankname);
        textTips = (TextView)findViewById(R.id.recharge_text_tips);
        textTips.setText("2小时到账");
        editAmount = (ClearEditText)findViewById(R.id.recharge_edit_amount);
        textAll = (TextView)findViewById(R.id.recharge_text_all);
        textAll.setVisibility(View.VISIBLE);
        textAll.setOnClickListener(this);
        textAll.setText(StringUtils.matcherSearchText(Color.RED,"账户余额：400.90   全部提现","全部提现"));
        btnNext = (Button)findViewById(R.id.recharge_btn_next);
        btnNext.setOnClickListener(this);
        btnNext.setText("确定");
        checkBox = (CheckBox) findViewById(R.id.recharge_rb);
        checkBox.setVisibility(View.GONE);
        textProtocol = (TextView)findViewById(R.id.recharge_text_protocol);
        textProtocol.setVisibility(View.GONE);

        mPresenter.attachView(this,this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public WithDrawPresenter getPresenter() {
        return new WithDrawPresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.head_img_back:
                finish();
                break;
            case R.id.recharge_text_all:
                ToastUtil.showShortToast(this,"正在开发");
                break;
            case R.id.recharge_btn_next:
                Intent intent = new Intent(this,InputPasswordAty.class);
//                intent.putExtra("type",1);
                startActivity(intent);
                mPresenter.withDraw();
                break;
        }
    }
}
