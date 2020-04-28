package com.crf.ix.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.crf.ix.R;
import com.crf.ix.base.BaseActivity;
import com.crf.ix.presenter.RegisterPresenter;
import com.crf.ix.presenter.contract.RegisterContract;
import com.crf.ix.utils.StringUtils;
import com.crf.ix.utils.ToastUtil;
import com.crf.ix.widget.dialog.ConfirmDialog;

import java.sql.Time;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: RegisterAty
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/8/28 14:01
 */
public class RegisterAty extends BaseActivity<RegisterPresenter,Object> implements View.OnClickListener,RegisterContract.View {
    private ImageView imgBack;
    private TextView textTitle;
    private TextView textRight;

    private String phoneNum;

    private EditText editCode;
    private TextView textSendCode;

    private EditText editPassword;

    private TextView textProtocol;
    private ImageView imgReveal;
    private Button btnRegister;
    private boolean showPassword = false;

    @Override
    public int getLayoutId() {
        return R.layout.aty_register;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initView() {
        imgBack = (ImageView)findViewById(R.id.head_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView)findViewById(R.id.head_text_title);
        textTitle.setText("注册");
        textRight = (TextView)findViewById(R.id.head_text_right);
        textRight.setVisibility(View.INVISIBLE);

        editCode = (EditText)findViewById(R.id.register_edit_code);
        textSendCode = (TextView)findViewById(R.id.register_text_send_code);
        textSendCode.setOnClickListener(this);

        editPassword = (EditText)findViewById(R.id.register_edit_password);
        imgReveal = (ImageView)findViewById(R.id.register_img_reveal);
        imgReveal.setOnClickListener(this);

        textProtocol = (TextView)findViewById(R.id.register_text_protocol);
        textProtocol.setOnClickListener(this);
        String content = "点击“完成注册”即表示您已同意《IX用户协议》";
        textProtocol.setOnClickListener(this);
        textProtocol.setText(StringUtils.matcherSearchText(Color.RED,content,"《IX用户协议》"));

        btnRegister = (Button)findViewById(R.id.register_btn_register);
        btnRegister.setOnClickListener(this);

        mPresenter.attachView(this,this);

    }

    @Override
    public RegisterPresenter getPresenter() {
        return new RegisterPresenter();
    }

    @Override
    protected void initData() {
        phoneNum = getIntent().getStringExtra("phone");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.head_img_back:
                finish();
                break;
            case R.id.register_text_send_code:
                if (time < 60){
                    return;
                }else{
                    startTask();
                    mPresenter.sendCode("13476183516");
                }
                break;
            case R.id.register_btn_register:
                mPresenter.register("13476183516","539742","12345678");
                break;
            case R.id.register_text_protocol:
                Intent intentProtocol = new Intent(this,CustomWebAty.class);
                intentProtocol.putExtra("type",3);
                startActivity(intentProtocol);
                break;
            case R.id.register_img_reveal:
                ToastUtil.showShortToast(this,"正在开发中");
                if (showPassword){
                    showPassword = false;
                    editPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    imgReveal.setImageResource(R.drawable.hide);
                }else{
                    showPassword = true;
                    editPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    imgReveal.setImageResource(R.drawable.reveal);
                }
                break;
        }
    }

    @Override
    public void showDataSuccess(Object datas) {
        super.showDataSuccess(datas);
        final  ConfirmDialog dialog = new ConfirmDialog(this,"20元现金红包已返现至您的账户余额，绑定银行卡可随时提现，完成银行存管账户卡通还可获得10元现金红包","我知道了");
        dialog.setClicklistener(new ConfirmDialog.ClickListenerInterface() {
            @Override
            public void doConfirm() {
                Intent intent = new Intent(RegisterAty.this,RegisterResultAty.class);
                startActivity(intent);
                dialog.dismiss();
            }
        });
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    private int time = 60;
    ScheduledThreadPoolExecutor scheduledThreadPool;
    //倒计时
    private void startTask(){
        scheduledThreadPool = new ScheduledThreadPoolExecutor(2);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                time --;
                handler.sendEmptyMessage(0);
            }
        },0,1, TimeUnit.SECONDS);
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (time <= 0){
                scheduledThreadPool.shutdownNow();
                scheduledThreadPool = null;
                time = 60;
                textSendCode.setText("立即发送");
            }else{
                textSendCode.setText(time+"s后发送");
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (scheduledThreadPool != null){
            scheduledThreadPool.shutdownNow();
            scheduledThreadPool = null;
        }
    }
}
