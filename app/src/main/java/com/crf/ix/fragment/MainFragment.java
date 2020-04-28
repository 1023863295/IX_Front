package com.crf.ix.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.crf.ix.base.BaseFragment;
import com.crf.ix.presenter.MainFragmentPresenter;
import com.crf.ix.presenter.contract.MainFragmentContract;
import com.crf.ix.ui.OpenAccountAty;
import com.crf.ix.R;
import com.crf.ix.utils.GlideImageLoader;
import com.crf.ix.utils.ToastUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: MainFragment
 * @Description: java类描述
 * @Author: liuliang
 * @CreateDate: 2018/9/3 15:04
 */
public class MainFragment extends BaseFragment<MainFragmentPresenter,Object> implements View.OnClickListener,MainFragmentContract.View{
    private TextView btnJump;
    private Banner banner;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View RootView) {
        btnJump = (TextView)RootView.findViewById(R.id.main_btn);
        btnJump.setOnClickListener(this);

        banner = (Banner)RootView.findViewById(R.id.main_banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        List<String> images = new ArrayList<>();
        images.add("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1537428661&di=b3a8e51505c35011c46ca48386e672d2&src=http://imgsrc.baidu.com/imgad/pic/item/32fa828ba61ea8d3d8d6c33f9c0a304e251f5810.jpg");
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1537438737089&di=8b13c3f2428e05ec4196807bf47c332b&imgtype=0&src=http%3A%2F%2Ffa.topitme.com%2Fa%2Fa2%2F8a%2F1130147841d058aa2al.jpg");
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1537438737089&di=2003d597f180f5f738bbcc67a12e5135&imgtype=0&src=http%3A%2F%2Ffile29.mafengwo.net%2FM00%2F7B%2F34%2FwKgBpVYdGOiAS71LAABuKaLQB_887.groupinfo.w600.jpeg");
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1537438737088&di=9c6ecd95fbf51da71d0b06991a6ed571&imgtype=0&src=http%3A%2F%2Fr.bstatic.com%2Fimages%2Fhotel%2Fmax1024x768%2F175%2F17552195.jpg");

        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default);
        //设置标题集合（当banner样式有显示title时）
//        banner.setBannerTitles(titles);
        //设置图片集合
        banner.setImages(images);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                ToastUtil.showShortToast(getActivity(),""+position);
            }
        });

        mPresenter.attachView(this,getActivity());
    }

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_main;
    }

    @Override
    public MainFragmentPresenter getPresenter() {
        return new MainFragmentPresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_btn:
                Intent intent = new Intent(this.getContext(), OpenAccountAty.class);
                startActivity(intent);
                break;
        }

    }
}
