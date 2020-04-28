package com.crf.ix.ui;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.crf.ix.R;
import com.crf.ix.adapter.LQRAdapterForRecyclerView;
import com.crf.ix.adapter.LQRViewHolderForRecyclerView;
import com.crf.ix.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: RepaymentPlanAty
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/27 11:06
 */
public class RepaymentPlanAty extends BaseActivity implements View.OnClickListener{
    private ImageView imgBack;
    private TextView textTitle;
    private TextView textRight;

    private RecyclerView recyclerView;
    private LQRAdapterForRecyclerView<Object> mAdapter;
    private List<Object> listDate;

    @Override
    public int getLayoutId() {
        return R.layout.aty_repayment_plan;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initView() {
        imgBack = (ImageView)findViewById(R.id.head_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView)findViewById(R.id.head_text_title);
        textTitle.setText("还款计划");
        textRight = (TextView)findViewById(R.id.head_text_right);
        textRight.setVisibility(View.GONE);

        recyclerView = (RecyclerView)findViewById(R.id.repayment_plan_recycleview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        listDate = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            listDate.add(new Object());
        }
        mAdapter = new LQRAdapterForRecyclerView<Object>(this,listDate,R.layout.payment_plan_list_item) {
            @Override
            public void convert(LQRViewHolderForRecyclerView helper, Object item, int position) {

            }
        };

        recyclerView.setAdapter(mAdapter);

        DividerItemDecoration divider = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this,R.drawable.custom_divider));
        recyclerView.addItemDecoration(divider);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

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
