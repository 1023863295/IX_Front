package com.crf.ix.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.crf.ix.adapter.LQRAdapterForRecyclerView;
import com.crf.ix.adapter.LQRViewHolder;
import com.crf.ix.adapter.LQRViewHolderForRecyclerView;
import com.crf.ix.adapter.OnItemClickListener;
import com.crf.ix.base.BaseFragment;
import com.crf.ix.R;
import com.crf.ix.ui.BondDetailAty;
import com.crf.ix.ui.BuyBondAty;
import com.crf.ix.ui.HomeAty;
import com.crf.ix.utils.ToastUtil;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: BondFragment
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/3 15:06
 */
public class BondFragment extends BaseFragment implements View.OnClickListener {
    private ImageView imgSelect;

    private TextView textRecomand;
    private TextView textRate;
    private TextView textDate;
    private TextView textPrice;
    private TextView textDiscount;

    private RefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private List<Object> listData;
    private LQRAdapterForRecyclerView<Object>  adapter;


    @Override
    protected void initData() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void initView(View RootView) {
        imgSelect = (ImageView)RootView.findViewById(R.id.fragment_bond_img_select);
        imgSelect.setOnClickListener(this);
        textRecomand = (TextView)RootView.findViewById(R.id.fragment_bond_text_recomand);
        textRecomand.setOnClickListener(this);
        textDate = (TextView)RootView.findViewById(R.id.fragment_bond_text_date);
        textDate.setOnClickListener(this);
        textRate = (TextView)RootView.findViewById(R.id.fragment_bond_text_rate);
        textRate.setOnClickListener(this);
        textPrice = (TextView)RootView.findViewById(R.id.fragment_bond_text_price);
        textPrice.setOnClickListener(this);
        textDiscount = (TextView)RootView.findViewById(R.id.fragment_bond_text_discount);
        textDiscount.setOnClickListener(this);

        refreshLayout = (RefreshLayout)RootView.findViewById(R.id.fragment_bond_refreshLayout);
        recyclerView = (RecyclerView)RootView.findViewById(R.id.bound_recyclerView);
        //设置 Header 为 贝塞尔雷达 样式
        refreshLayout.setRefreshHeader(new BezierRadarHeader(getContext()).setEnableHorizontalDrag(true));
        //设置 Footer 为 球脉冲 样式
        refreshLayout.setRefreshFooter(new BallPulseFooter(getContext()).setSpinnerStyle(SpinnerStyle.Scale));

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
            }
        });


        listData = new ArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            listData.add(new Object());
        }
        adapter = new LQRAdapterForRecyclerView<Object>(getActivity(), listData, R.layout.bond_list_item){
            @Override
            public void convert(LQRViewHolderForRecyclerView helper, Object item, int position) {
                TextView textNo = helper.getView(R.id.bond_list_item_text_no);
                textNo.setText("债券编号:X1000");
                helper.getView(R.id.bond_list_item_text_buy).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), BuyBondAty.class);
                        startActivity(intent);
                    }
                });
            }

        };
        //设置RecyclerView管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(LQRViewHolder helper, ViewGroup parent, View itemView, int position) {
                Intent intent = new Intent(getActivity(), BondDetailAty.class);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        DividerItemDecoration divider = new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.custom_divider));
        recyclerView.addItemDecoration(divider);
    }

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_bond;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fragment_bond_img_select:
                ((HomeAty)getActivity()).showPop();
                break;
            case R.id.fragment_bond_text_recomand:
                break;
            case R.id.fragment_bond_text_rate:
                break;
            case R.id.fragment_bond_text_date:
                break;
            case R.id.fragment_bond_text_price:
                break;
            case R.id.fragment_bond_text_discount:
                break;
        }
    }
}
