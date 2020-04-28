package com.crf.ix.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.crf.ix.R;
import com.crf.ix.base.BaseFragment;
import com.crf.ix.presenter.MineFragmentPresenter;
import com.crf.ix.presenter.contract.MineFragmentContract;
import com.crf.ix.ui.CustomWebAty;
import com.crf.ix.ui.LoginAty;
import com.crf.ix.ui.RechargeAty;
import com.crf.ix.ui.SettingsAty;
import com.crf.ix.ui.UserInfoAty;
import com.crf.ix.ui.WithdrawAty;
import com.crf.ix.widget.view.OptionItemView;

/**
 * @ClassName: MineFragment
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/3 15:06
 */
public class MineFragment extends BaseFragment<MineFragmentPresenter,Object> implements View.OnClickListener,MineFragmentContract.View{
    private TextView textUserInfo;
    private TextView textRecharge;
    private TextView textWithDraw; //提现


    private TextView textMessages;

    private OptionItemView itemLogin;
    private OptionItemView itemRedpackets;
    private OptionItemView itemLends; //我的出借
    private OptionItemView itemCashFlow; //现金流水
    private OptionItemView itemFaq; //常见问题
    private OptionItemView itemSetting;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View RootView) {

        textMessages = (TextView)RootView.findViewById(R.id.mine_user_messages);
        textMessages.setOnClickListener(this);
        textUserInfo = (TextView)RootView.findViewById(R.id.mine_user_info);
        textUserInfo.setOnClickListener(this);
        textRecharge = (TextView)RootView.findViewById(R.id.mine_text_recharge);
        textRecharge.setOnClickListener(this);
        textWithDraw = (TextView)RootView.findViewById(R.id.mine_text_withdraw);
        textWithDraw.setOnClickListener(this);

        itemLogin = (OptionItemView)RootView.findViewById(R.id.mine_item_login);
        itemLogin.setOnClickListener(this);
        itemRedpackets = (OptionItemView)RootView.findViewById(R.id.mine_red_packets);
        itemRedpackets.setOnClickListener(this);

        itemLends = (OptionItemView)RootView.findViewById(R.id.mine_lend);
        itemLends.setOnClickListener(this);
        itemCashFlow = (OptionItemView)RootView.findViewById(R.id.mine_cash_flow);
        itemCashFlow.setOnClickListener(this);
        itemFaq = (OptionItemView)RootView.findViewById(R.id.mine_common_questions);
        itemFaq.setOnClickListener(this);

        itemSetting = (OptionItemView)RootView.findViewById(R.id.mine_setting);
        itemSetting.setOnClickListener(this);

        mPresenter.attachView(this,getActivity());
    }

    @Override
    public MineFragmentPresenter getPresenter() {
        return new MineFragmentPresenter();
    }

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_user_messages:
                Intent intentMsg = new Intent(getActivity(),CustomWebAty.class);
                intentMsg.putExtra("type",2);
                startActivity(intentMsg);
                break;
            case R.id.mine_user_info:
                Intent intentUser = new Intent(getActivity(), UserInfoAty.class);
                startActivity(intentUser);
                break;
            case R.id.mine_text_recharge:
                Intent intentRecharge = new Intent(getActivity(), RechargeAty.class);
                startActivity(intentRecharge);
                break;
            case R.id.mine_text_withdraw:
                Intent intentWithDraw = new Intent(getActivity(), WithdrawAty.class);
                startActivity(intentWithDraw);
                break;
            case R.id.mine_item_login:
                Intent intent = new Intent(this.getContext(), LoginAty.class);
                startActivity(intent);
                break;
            case R.id.mine_red_packets:
                break;
            case R.id.mine_lend:
                break;
            case R.id.mine_cash_flow:
                break;
            case R.id.mine_common_questions:
                Intent intentFaq = new Intent(getActivity(), CustomWebAty.class);
                intentFaq.putExtra("type",1);
                startActivity(intentFaq);
                break;
            case R.id.mine_setting:
                Intent setIntent = new Intent(getActivity(), SettingsAty.class);
                getActivity().startActivity(setIntent);
                break;
        }

    }
}
