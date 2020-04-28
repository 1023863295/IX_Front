package com.crf.ix.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.crf.ix.R;

/**
 * @ClassName: CustomDialog
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/5 16:18
 */
public class CustomDialog extends Dialog implements View.OnClickListener{

    private TextView titleTxt;
    private TextView contentTxt;
    private TextView submitTxt;
    private TextView cancelTxt;


    private Context mContext;
    private String title;
    private String content;
    private String positiveName;
    private String negativeName;

    private OnCloseListener listener;

    public CustomDialog(@NonNull Context context) {
//        super(context);
        super(context, R.style.dialog);
        this.mContext = context;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPositiveName(String positiveName) {
        this.positiveName = positiveName;
    }

    public void setNegativeName(String negativeName) {
        this.negativeName = negativeName;
    }

    public void setListener(OnCloseListener listener) {
        this.listener = listener;
    }

   public interface  OnCloseListener{
        void onClick(Dialog dialog, boolean confirm);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_custom);
//        setCanceledOnTouchOutside(false);
        initView();
    }

    private void initView(){
        titleTxt = (TextView)findViewById(R.id.dialog_custom_title);
        contentTxt = (TextView)findViewById(R.id.dialog_custom_content);
        submitTxt = (TextView)findViewById(R.id.dialog_custom_submit);
        submitTxt.setOnClickListener(this);
        cancelTxt = (TextView)findViewById(R.id.dialog_custom_cancel);
        cancelTxt.setOnClickListener(this);

        titleTxt.setText(title);
        contentTxt.setText(content);
        if(!TextUtils.isEmpty(positiveName)){
            submitTxt.setText(positiveName);
        }

        if(!TextUtils.isEmpty(negativeName)){
            cancelTxt.setText(negativeName);
        }

        Window dialogWindow = getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        DisplayMetrics d = mContext.getResources().getDisplayMetrics(); // 获取屏幕宽、高用
        lp.width = (int) (d.widthPixels * 0.8); // 高度设置为屏幕的0.6
        dialogWindow.setAttributes(lp);
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.dialog_custom_cancel:
                if(listener != null){
                    listener.onClick(this, false);
                }
                this.dismiss();
                break;
            case R.id.dialog_custom_submit:
                if(listener != null){
                    listener.onClick(this, true);
                }
                this.dismiss();
                break;
        }
    }
}
