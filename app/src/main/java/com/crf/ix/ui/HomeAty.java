package com.crf.ix.ui;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.crf.ix.base.BaseActivity;
import com.crf.ix.R;
import com.crf.ix.fragment.BondFragment;
import com.crf.ix.fragment.MainFragment;
import com.crf.ix.fragment.MineFragment;
import com.crf.ix.utils.AppInfo;
import com.crf.ix.utils.Base64Utils;
import com.crf.ix.utils.LogUtils;
import com.crf.ix.utils.PopupwindowUtil;
import com.crf.ix.utils.RSAUtils;
import com.crf.ix.utils.ToastUtil;
import com.crf.ix.widget.view.BottomBar;

import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;

import cn.jpush.android.api.JPushInterface;

/**
 * @ClassName: HomeAty
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/8/28 14:11
 */
public class HomeAty extends BaseActivity {
    private Fragment currentFragment;
//    private Fragment mainFragment;
//    private Fragment bondFragment;
//    private Fragment mineFragment;

    private BottomBar bottomBar;
    private View grayView;


    @Override
    public int getLayoutId() {
        return R.layout.aty_home;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initView() {
        grayView = (View)findViewById(R.id.home_gray_layout);
        bottomBar = (BottomBar)findViewById(R.id.home_bottom_bar);
        bottomBar.setContainer(R.id.home_fragment)
                .setTitleBeforeAndAfterColor("#999999","#050B4F")
                .setTitleSize(12)
                .setTitleIconMargin(6)
//                .setIconHeight(10)
//                .setIconWidth(10)
                .addItem(MainFragment.class,
                        "首页",
                        R.drawable.home_icon_normal,R.drawable.home_icon)
                .addItem(BondFragment.class,
                        "债券",
                        R.drawable.bound_icon_normal,R.drawable.bound_icon)
                .addItem(MineFragment.class,
                        "我的",
                        R.drawable.user_icon_normal,R.drawable.user_icon)
                .build();
//        FragmentTransaction transaction = getSupportFragmentManager()
//                .beginTransaction();
//        transaction.add(R.id.home_fragment,
// );
//        transaction.commit();

//        JPushInterface.setAlias(this,1,"liuliang");
        LogUtils.d("RegistrationID  "+JPushInterface.getRegistrationID(getApplicationContext()));

        try {
             byte[] date = RSAUtils.encryptByPublicKey("123456789liuliang".getBytes(),
                     "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCAuFyXO4O0/SUdfiZZTEzNngW0D8sYL9jga2pjjZDjoM1FJ5VzsaROEhl2ohrIv+E0CS5no4ED82anm4zxn2zwARNs8X2hZrcFAqQNeZ9PMs8KMdNF6Ji3SQPFtsa/jjvqst+PzTQxoETe3gyOIPwAeRa2UpBkEGfzuVwv0us4xQIDAQAB");
            LogUtils.d("home:"+new String(date));

            byte[] data2 = RSAUtils.decryptByPrivateKey(date,"MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIC4XJc7g7T9JR1+JllMTM2eBbQPyxgv2OBramONkOOgzUUnlXOxpE4SGXaiGsi/4TQJLmejgQPzZqebjPGfbPABE2zxfaFmtwUCpA15n08yzwox00XomLdJA8W2xr+OO+qy34/NNDGgRN7eDI4g/AB5FrZSkGQQZ/O5XC/S6zjFAgMBAAECgYB4gJ+lsMCPKkGZx6RNCuIHyDzcocBm5zwodEbH5hrTDpG8gN8nzRDdSZJu/jkG4KMKnOHFgkrgkPf0Run+tVo8TOYfj6462jrFzXnv7bnuOAtM4LbMjOiZS66BvPrzHiCq3XbxdmwKZ1AsWpwTrYw7ZWzFONSZp61lezHjqWMDgQJBAL7dCSmw7WYhfBaRd6qevBtBVFAKnAW+H5nJTqARFsd7taQyFwi8BWz46jEs656DEG60gU/myCARtX9tSR+/8OECQQCsph7+AaR9q8/liQa2J7e9ZhNUtd6GP0NtL4kULZuesvwBUm9Plcx1i+OsRmzMM8LBzQ0vUXP/bcrcSEp05zBlAkB7u2OTSYW9bfu5zbgcPieIK8Py183p0yU9V0nHbwyracGJnodcPDfwOzXnh02AR0tB2XbzS5N1ZsWYxEphcNdBAkEAkYUnpEMwKTjS746SmKBbj4llC8aLfC4AoBwr91UF0TrdjCO2bKc/gWhai0+Ezo1mP8GctmB6XDZngUpxb52ZvQJAIl9EsyvcdxHr2mQl4RaKHVcYua0kntXhzW4Xxy1DnWi/mRT2waE6tiCJu3dx3WfyRPeLRj9yWryhiYZSXBLYSQ==");
            LogUtils.d("home: "  +new String(data2));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void initData() {
//        mainFragment = new MainFragment();
//        bondFragment = new BondFragment();
//        mineFragment = new MineFragment();
//        currentFragment = mainFragment;
    }

    /**
     * fragment切换
     */
    public void switchContent(Fragment targetFragment) {
        if (currentFragment.equals(targetFragment)){
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        if (!targetFragment.isAdded()) {
            transaction
                    .hide(currentFragment)
                    .add(R.id.home_fragment, targetFragment)
                    .commit();
        } else {
            transaction
                    .hide(currentFragment)
                    .show(targetFragment)
                    .commit();
        }
        currentFragment = targetFragment;
    }

    public  void showPop(){
        grayView.setVisibility(View.VISIBLE);
        int h = getWindowManager().getDefaultDisplay().getHeight();
        int w = getWindowManager().getDefaultDisplay().getWidth();
        PopupwindowUtil.getInstance(this)
                .mBackground(new ColorDrawable(Color.TRANSPARENT))
                .mLoadView(R.layout.popup_bond)
                .mBackground(new BitmapDrawable())
                .mAnimationStyle(R.style.popwindow_bond_style)
                .mFocusable(true)
                .mOutsideTouchable(true)
                .mWidthHeight((int)(w*0.8), ViewGroup.LayoutParams.MATCH_PARENT)
                .mDisMissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        grayView.setVisibility(View.GONE);
                    }
                })
                .mViewAction(R.id.popup_bond_linear_text_confirm, new PopupwindowUtil.ViewAction<TextView>() {
                    @Override
                    public void action(PopupwindowUtil mPopupwindowUtil, TextView mView) {

                        ToastUtil.showLongToast(HomeAty.this, ""+mView.getId());
                    }
                })

//                .mClickAction(R.id.popup_bond_linear_text_confirm, new PopupwindowUtil.PopupAction() {
//                    @Override
//                    public void action(PopupWindow mPopupWindow, @Nullable View mContentView, @Nullable RadioGroup group, int checkedId) {
//                        Log.i("test",checkedId+":");
//                    }
//                })
                .showAtLocation(bottomBar, Gravity.RIGHT,0,0);
    }

}
