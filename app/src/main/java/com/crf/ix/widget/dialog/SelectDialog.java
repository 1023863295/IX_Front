package com.crf.ix.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.crf.ix.R;

/**
 * @ClassName: SelectDialog
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/5 15:38
 */
public class SelectDialog extends Dialog implements View.OnClickListener{
    private TextView contentTxt;
    private TextView submitTxt;
    private TextView cancelTxt;


    private Context mContext;
    private String content;
    private OnCloseListener listener;
    private String positiveName;
    private String negativeName;


    public SelectDialog(Context context) {
        super(context);
        this.mContext = context;
    }

    public SelectDialog(Context context, int themeResId, String content) {
        super(context, themeResId);
        this.mContext = context;
        this.content = content;
    }

    public SelectDialog(Context context, int themeResId, String content, OnCloseListener listener) {
        super(context, themeResId);this.mContext = context;

        this.content = content;
        this.listener = listener;
    }

    protected SelectDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.mContext = context;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public SelectDialog setPositiveButton(String name){
        this.positiveName = name;
        return this;
    }

    public SelectDialog setNegativeButton(String name){
        this.negativeName = name;
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_select);
        setCanceledOnTouchOutside(false);
        initView();
    }

    private void initView(){
        contentTxt = (TextView)findViewById(R.id.content);
        submitTxt = (TextView)findViewById(R.id.submit);
        submitTxt.setOnClickListener(this);
        cancelTxt = (TextView)findViewById(R.id.cancel);
        cancelTxt.setOnClickListener(this);

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
        lp.width = (int) (d.widthPixels * 0.7); // 高度设置为屏幕的0.6
        dialogWindow.setAttributes(lp);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cancel:
                if(listener != null){
                    listener.onClick(this, false);
                }
                this.dismiss();
                break;
            case R.id.submit:
                if(listener != null){
                    listener.onClick(this, true);
                }
                break;
        }
    }

    public void setListener(OnCloseListener listener) {
        this.listener = listener;
    }

    public interface OnCloseListener{
        void onClick(Dialog dialog, boolean confirm);
    }
}
