package com.crf.ix.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.crf.ix.R;
import com.crf.ix.base.BaseActivity;
import com.crf.ix.utils.PopupwindowUtil;
import com.crf.ix.widget.view.OptionItemView;

/**
 * @ClassName: BondDetailAty
 * @Description: java类描述 债券详情
 * @Author: liuliang
 * @CreateDate: 2018/9/26 18:02
 */
public class BondDetailAty extends BaseActivity implements View.OnClickListener{
    private ImageView imgBack;
    private TextView textTitle;
    private TextView textRight;

    private OptionItemView optionPlan; //还款计划
    private OptionItemView optionDetail; //查看详情
    private Button btnBuy; //立即购买

    @Override
    public int getLayoutId(){
        return R.layout.aty_bond_detail;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initView() {
        imgBack = (ImageView)findViewById(R.id.head_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView)findViewById(R.id.head_text_title);
        textTitle.setText("债权详情");
        textRight = (TextView)findViewById(R.id.head_text_right);
        textRight.setVisibility(View.GONE);

        optionPlan = (OptionItemView)findViewById(R.id.bond_detail_option_plan);
        optionPlan.setOnClickListener(this);
        optionDetail = (OptionItemView)findViewById(R.id.bond_detail_option_detail);
        optionDetail.setOnClickListener(this);

        btnBuy = (Button)findViewById(R.id.bond_detail_btn_buy);
        btnBuy.setOnClickListener(this);
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
            case R.id.bond_detail_option_plan:
                Intent intentPlan = new Intent(this,RepaymentPlanAty.class);
                startActivity(intentPlan);
                break;
            case R.id.bond_detail_option_detail:
                Intent intentBorroewer = new Intent(this,BorrowerDetailAty.class);
                startActivity(intentBorroewer);
                break;
            case R.id.bond_detail_btn_buy:
                Intent intent = new Intent(this,BuyBondAty.class);
                startActivity(intent);
                break;
        }
    }

}
