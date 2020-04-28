package com.crf.ix.ui;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.crf.ix.R;
import com.crf.ix.base.BaseActivity;
import com.crf.ix.presenter.OpenAccountPresenter;
import com.crf.ix.presenter.contract.OpenAccontContract;
import com.crf.ix.widget.dialog.CustomDialog;
import com.crf.ix.widget.view.ClearEditText;

/**
 * @ClassName: OpenAccountAty
 * @Description: 开存款账号
 * @Author: liuliang
 * @CreateDate: 2018/8/31 14:38
 */
public class OpenAccountAty extends BaseActivity<OpenAccountPresenter,Object> implements View.OnClickListener,OpenAccontContract.View {
    private ImageView imgBack;
    private TextView textTitle;
    private TextView textRight;

    private ClearEditText editName;
    private ClearEditText editId;
    private ClearEditText editCardNo;
    private ClearEditText editPhone;
    private EditText editCode; //验证码

    private CheckBox checkBox;
    private Button btnOpen;
    private Boolean isAgree; //是否同意

    @Override
    public int getLayoutId() {
        return R.layout.aty_open_account;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initView() {
        imgBack = (ImageView)findViewById(R.id.head_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView)findViewById(R.id.head_text_title);
        textTitle.setText("开通存管账户");
        textRight = (TextView)findViewById(R.id.head_text_right);
        textRight.setVisibility(View.VISIBLE);
        textRight.setText("支持银行");
        textRight.setOnClickListener(this);

        editName = (ClearEditText) findViewById(R.id.open_account_edit_name);
        editId = (ClearEditText)findViewById(R.id.open_account_edit_id);
        editCardNo = (ClearEditText)findViewById(R.id.open_account_edit_card_no);
        editPhone = (ClearEditText)findViewById(R.id.open_account_edit_phone);
        editCode = (EditText)findViewById(R.id.open_account_edit_code);


        checkBox = (CheckBox)findViewById(R.id.open_account_cb);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isAgree = isChecked;
            }
        });
        btnOpen = (Button)findViewById(R.id.open_account_btn_open);
        btnOpen.setOnClickListener(this);

        mPresenter.attachView(this,this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public OpenAccountPresenter getPresenter() {
        return new OpenAccountPresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.head_img_back:
                finish();
                break;
            case R.id.head_text_right:
                Intent intentBanks = new Intent(this,CustomWebAty.class);
                startActivity(intentBanks);
                break;
            case R.id.open_account_btn_open:
               mPresenter.openAccount(editName.getText().toString(),
                       editId.getText().toString(),
                       editCardNo.getText().toString(),
                       editPhone.getText().toString(),
                       editCode.getText().toString());
                break;
        }

    }

    @Override
    public void showDataSuccess(Object datas) {
        super.showDataSuccess(datas);
        CustomDialog customDialog = new CustomDialog(this);
        customDialog.setTitle("存管账户关联");
        customDialog.setContent("您在上海银行已开通存管账户，现可将当前账号与该存管账户关联。");
        customDialog.setPositiveName("立即关联");
        customDialog.setNegativeName("暂不关联");
        customDialog.setListener(new CustomDialog.OnCloseListener() {
            @Override
            public void onClick(Dialog dialog, boolean confirm) {
                if (confirm){
                    Intent intent = new Intent(OpenAccountAty.this,OpenAccountSuccessAty.class);
                    startActivity(intent);
                }else{

                }

            }
        });

        customDialog.show();

    }
}
