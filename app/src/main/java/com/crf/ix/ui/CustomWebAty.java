package com.crf.ix.ui;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.crf.ix.R;
import com.crf.ix.base.BaseActivity;
import com.crf.ix.components.CustomWebViewClient;
import com.crf.ix.jsInterface.JSInterface;
import com.crf.ix.utils.WebConfigs;

/**
 * @ClassName: SupportBanksAty
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/4 10:50
 */
public class CustomWebAty extends BaseActivity implements View.OnClickListener{
    private ImageView imgBack;
    private TextView textTitle;
    private TextView textRight;

    private WebView mWebView;
    private CustomWebViewClient customWebViewClient;

    private LinearLayout linearLayout;

    private int TYPE = 0; // 0 支持银行;1，常见问题; 2，消息; 3,IX用户协议;4，用户快捷充值协议

    @Override
    public int getLayoutId() {
        return R.layout.aty_support_banks;
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

        linearLayout = (LinearLayout)findViewById(R.id.support_linear_container);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mWebView = new WebView(getApplicationContext());
        mWebView.setLayoutParams(params);
        linearLayout.addView(mWebView);
        WebConfigs.setDefaultConfig(mWebView,this);
        customWebViewClient = new CustomWebViewClient();
        mWebView.setWebViewClient(customWebViewClient);
        JSInterface  jsInterface = new JSInterface(this);
        mWebView.addJavascriptInterface(jsInterface,"android");


        switch (TYPE){
            case 0:
                textTitle.setText("支持银行");
                mWebView.loadUrl("http://10.194.11.187:8080/evaluate");
                break;
            case 1:
                textTitle.setText("常见问题");
                mWebView.loadUrl("http://10.194.11.187:8080/evaluate");
                break;
            case 2:
                textTitle.setText("消息");
                mWebView.loadUrl("http://10.194.11.187:8080/evaluate");
                break;
            case 3:
                textTitle.setText("IX用户协议");
                mWebView.loadUrl("http://10.194.11.187:8080/evaluate");
                break;
            case 4:
                textTitle.setText("用户快捷充值协议");
                mWebView.loadUrl("http://10.194.11.187:8080/evaluate");
                break;
        }
    }

    @Override
    protected void initData() {
        TYPE = getIntent().getIntExtra("type",0);
    }

    @Override
    protected void onDestroy() {
        //先让 WebView 加载null内容，然后移除 WebView，再销毁 WebView，最后置空。
        if (mWebView != null) {
            mWebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            mWebView.clearHistory();

            ((ViewGroup) mWebView.getParent()).removeView(mWebView);
            mWebView.destroy();
            mWebView = null;
        }
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.head_img_back:
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()){
            mWebView.goBack();
        }else{
            super.onBackPressed();
        }
    }
}
