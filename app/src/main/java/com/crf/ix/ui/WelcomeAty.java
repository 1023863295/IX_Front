package com.crf.ix.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.crf.ix.base.BaseActivity;
import com.crf.ix.R;

import org.w3c.dom.Text;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: WelcomeAty
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/8/28 14:12
 */
public class WelcomeAty extends BaseActivity {
    private TextView textTime;

    @Override
    public int getLayoutId() {
        return R.layout.aty_welcome;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initView() {

        textTime = (TextView)findViewById(R.id.welcome_text_time);
        textTime.setVisibility(View.INVISIBLE);
        ScheduledThreadPoolExecutor poolExecutor = new ScheduledThreadPoolExecutor(1);
        poolExecutor.schedule(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeAty.this,HomeAty.class);
                startActivity(intent);
            }
        },2, TimeUnit.SECONDS);

    }

    @Override
    protected void initData() {

    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
}
