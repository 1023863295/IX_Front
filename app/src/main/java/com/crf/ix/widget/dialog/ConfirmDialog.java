package com.crf.ix.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.crf.ix.R;

/**
 * @ClassName: ConfirmDialog
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/5 14:30
 */

public class ConfirmDialog extends Dialog {

    private Context context;
    private String content;
    private String confirmButtonText;
    private ClickListenerInterface clickListenerInterface;

    public interface ClickListenerInterface {

        public void doConfirm();

//        public void doCancel();
    }

    public ConfirmDialog(Context context, String content, String confirmButtonText) {
        super(context, R.style.dialog);
        this.context = context;
        this.content = content;
        this.confirmButtonText = confirmButtonText;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        init();
    }

    public void init() {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_confirm, null);
        setContentView(view);

        TextView tvContent = (TextView) view.findViewById(R.id.dialog_confirm_title);
        TextView tvConfirm = (TextView) view.findViewById(R.id.dialog_confirm_yes);

        tvContent.setText(content);
        tvConfirm.setText(confirmButtonText);

        tvConfirm.setOnClickListener(new clickListener());

        Window dialogWindow = getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        DisplayMetrics d = context.getResources().getDisplayMetrics(); // 获取屏幕宽、高用
        lp.width = (int) (d.widthPixels * 0.7); // 高度设置为屏幕的0.6
        dialogWindow.setAttributes(lp);
    }

    public void setClicklistener(ClickListenerInterface clickListenerInterface) {
        this.clickListenerInterface = clickListenerInterface;
    }

    private class clickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            int id = v.getId();
            switch (id) {
                case R.id.dialog_confirm_yes:
                    clickListenerInterface.doConfirm();
                    break;
            }
        }
    };



}