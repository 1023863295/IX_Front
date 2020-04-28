package com.crf.ix.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.crf.ix.R;
import com.crf.ix.base.BaseActivity;
import com.crf.ix.utils.StringUtils;
import com.crf.ix.utils.ToastUtil;
import com.crf.ix.widget.dialog.CustomDialog;

/**
 * @ClassName: BuyBondAty
 * @Description: java类描述 购买债权页面
 * @Author: liuliang
 * @CreateDate: 2018/9/26 17:24
 */
public class BuyBondAty extends BaseActivity implements View.OnClickListener{
    private ImageView imgBack;
    private TextView textTitle;
    private TextView textRight;

    private Button btnBuy;
    private TextView textTips;

    @Override
    public int getLayoutId() {
        return R.layout.aty_buy_bond;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initView() {
        imgBack = (ImageView)findViewById(R.id.head_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView)findViewById(R.id.head_text_title);
        textTitle.setText("购买债券");
        textRight = (TextView)findViewById(R.id.head_text_right);
        textRight.setVisibility(View.GONE);

        btnBuy = (Button)findViewById(R.id.buy_bond_btn_buy);
        btnBuy.setOnClickListener(this);

        textTips = (TextView)findViewById(R.id.buy_bond_text_protocol);
        textTips.setText(StringUtils.matcherSearchText(Color.GRAY,
                "购买即视为同意《出借人服务协议》、《借款协议》、《借款协议》补充协议、《数字证书服务协议》、《出借人信息真实性及资金合法性承诺函》",
                "购买即视为同意"));
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
            case R.id.buy_bond_btn_buy:
                showDataSuccess(null);
                break;
        }
    }

    @Override
    public void showDataSuccess(Object datas) {
        super.showDataSuccess(datas);
        CustomDialog customDialog = new CustomDialog(this);
        customDialog.setTitle("余额不足");
        customDialog.setContent("当前账户余额低于购买金额，需先充才能购买该债权。");
        customDialog.setPositiveName("取消");
        customDialog.setNegativeName("充值");
        customDialog.setListener(new CustomDialog.OnCloseListener() {
            @Override
            public void onClick(Dialog dialog, boolean confirm) {
                if (confirm){
                    ToastUtil.showShortToast(BuyBondAty.this,confirm+"正在开发");
                }else{
                    ToastUtil.showShortToast(BuyBondAty.this,confirm+"正在开发");
                }

            }
        });

        customDialog.show();
    }
}
