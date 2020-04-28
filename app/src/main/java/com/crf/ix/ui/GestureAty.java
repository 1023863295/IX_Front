package com.crf.ix.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.crf.ix.R;
import com.crf.ix.base.BaseActivity;
import com.crf.ix.widget.view.GestureLockViewGroup;

/**
 * @ClassName: GestureAty
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/8/30 13:12
 */
public class GestureAty extends BaseActivity implements View.OnClickListener{
    private ImageView imgBack;
    private TextView textTitle;
    private TextView textRight;

    private GestureLockViewGroup gestureLockViewGroup;

    @Override
    public int getLayoutId() {
        return R.layout.aty_gesture;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initView() {
        imgBack = (ImageView)findViewById(R.id.head_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView)findViewById(R.id.head_text_title);
        textTitle.setText("设置手势密码");
        textRight = (TextView)findViewById(R.id.head_text_right);
        textRight.setVisibility(View.INVISIBLE);


        gestureLockViewGroup = (GestureLockViewGroup)findViewById(R.id.gesture_viewgroup);
        gestureLockViewGroup.setAnswer(new int[]{1,2,3,4,5,6});
        gestureLockViewGroup.setOnGestureLockViewListener(new GestureLockViewGroup.OnGestureLockViewListener() {
            @Override
            public void onBlockSelected(int cId) {

            }

            @Override
            public void onGestureEvent(boolean matched) {

            }

            @Override
            public void onUnmatchedExceedBoundary() {

            }
        });
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
        }

    }
}
