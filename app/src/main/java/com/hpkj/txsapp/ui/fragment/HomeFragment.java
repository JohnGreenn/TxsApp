package com.hpkj.txsapp.ui.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewTreeObserver;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.gyf.immersionbar.ImmersionBar;
import com.hjq.http.EasyHttp;
import com.hjq.http.listener.HttpCallback;
import com.hjq.http.listener.OnHttpListener;
import com.hjq.toast.ToastUtils;
import com.hpkj.txsapp.R;
import com.hpkj.txsapp.app.AppFragment;
import com.hpkj.txsapp.app.TitleBarFragment;
import com.hpkj.txsapp.base.FragmentPagerAdapter;
import com.hpkj.txsapp.databinding.FragmentHomeBinding;
import com.hpkj.txsapp.databinding.HomeTopBinding;
import com.hpkj.txsapp.http.model.HttpData;
import com.hpkj.txsapp.http.request.BannerApi;
import com.hpkj.txsapp.http.request.GetGoodsListApi;
import com.hpkj.txsapp.http.response.ShopGoodsListBean;
import com.hpkj.txsapp.http.response.StartBean;
import com.hpkj.txsapp.http.response.DataBean;
import com.hpkj.txsapp.other.EncryptUtil;
import com.hpkj.txsapp.other.GridSpaceDecoration;
import com.hpkj.txsapp.ui.activity.GoodsDetailActivity;
import com.hpkj.txsapp.ui.activity.MainActivity;
import com.hpkj.txsapp.ui.adapter.GoodsListAdapter;
import com.hpkj.txsapp.ui.adapter.ImageAdapter;
import com.hpkj.txsapp.ui.utils.ClickUtil;
import com.hpkj.txsapp.widget.layout.XCollapsingToolbarLayout;
import com.hpkj.txsapp.widget.view.GradationScrollView;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * desc：首页 Fragment
 * author：Glq
 * time：2021/07/23 10:26
 */
public final class HomeFragment extends TitleBarFragment<MainActivity, FragmentHomeBinding> implements XCollapsingToolbarLayout.OnScrimsListener, OnRefreshLoadMoreListener, GradationScrollView.ScrollViewListener {

    private FragmentPagerAdapter<AppFragment<?,?>> mPagerAdapter;
    private GoodsListAdapter mAdapter;
    private int index = 1;
    private int size = 20;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {


        //binding.vpHomePager.setAdapter(mPagerAdapter);
        //binding.tlHomeTab.setupWithViewPager(binding.vpHomePager);

        // 给这个 ToolBar 设置顶部内边距，才能和 TitleBar 进行对齐
        ImmersionBar.setTitleBar(getAttachActivity(), binding.tbHomeTitle);

        //设置渐变监听


        binding.setClick(new ClickUtil());


        binding.rvHomeGoodslist.setLayoutManager(new GridLayoutManager(getContext(),2));
        mAdapter = new GoodsListAdapter();
        binding.rvHomeGoodslist.setAdapter(mAdapter);
        //binding.findRecycler.setLayoutManager(manager);
        // 添加分割线
        binding.rvHomeGoodslist.addItemDecoration(new GridSpaceDecoration((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics())));
        //binding.findRecycler.addItemDecoration(new GridSpaceItemDecoration(2,10,10));
        binding.rlHomeRefresh.setOnRefreshLoadMoreListener(this);


        initListener();

    }

    @Override
    protected void initData() {

        //获取列表数据
        getGoodslist();

        EasyHttp.post(this)
                .api(new BannerApi()
                        .setBname("home_banner"))
                .request(new HttpCallback<HttpData<ArrayList<StartBean>>>(this) {

                    @Override
                    public void onSucceed(HttpData<ArrayList<StartBean>> result) {
                        //ToastUtils.show("banner 请求成功，请看日志");

                        HomeTopBinding topBinding= DataBindingUtil.inflate(LayoutInflater.from(getActivity()),R.layout.home_top,getActivity().findViewById(android.R.id.content),false);



                        if(mAdapter.getHeaderLayoutCount()==0) {
                            mAdapter.addHeaderView(topBinding.getRoot());
                        }

                        topBinding.homeBanner.setAdapter(new ImageAdapter(result.getData()));

                        /*topBinding.homeBanner.setAdapter(new BannerImageAdapter<DataBean>(DataBean.getTestData3()) {

                            @Override
                            public void onBindView(BannerImageHolder holder,DataBean data,int position,int size) {

                                int cc  =position;
                                //图片加载自己实现
                                Glide.with(holder.itemView)
                                        .load(data.imageUrl)
                                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                                        .into(holder.imageView);
                            }
                        })
                        .setIndicator(new CircleIndicator(getContext()));*/

                        //binding.banner1.setIndicator(new CircleIndicator(getContext()));
                        //添加画廊效果
                        //binding.banner1.setBannerGalleryEffect(18, 10);
                        //添加透明效果(画廊配合透明效果更棒)
                        //binding.banner1.addPageTransformer(new AlphaPageTransformer());

                    }
                });
    }

    public void getGoodslist() {

        EasyHttp.get(this)
                .api(new GetGoodsListApi()
                        .setHeaderPass(EncryptUtil.getRequestId(5).trim())
                        .setLabel("11")
                        .setSortType(-1)
                        .setIndex(index)
                        .setPageSize(size))
                .request(new OnHttpListener<HttpData<ArrayList<ShopGoodsListBean>>>(){
                    @Override
                    public void onSucceed(HttpData<ArrayList<ShopGoodsListBean>> result) {
                        //super.onSucceed(result);
                        //ToastUtils.show("商品列表请求成功");
                        if(index==1){
                            mAdapter.setNewInstance(result.getData());
                        } else {
                            if(result.getData() == null || result.getData().size() == 0){
                                binding.rlHomeRefresh.finishRefresh();
                                binding.rlHomeRefresh.finishLoadMoreWithNoMoreData();//解决没有更多数据的时候，还显示了loading
                                binding.rlHomeRefresh.setNoMoreData(true);
                            } else {
                                mAdapter.addData(result.getData());
                                binding.rlHomeRefresh.finishLoadMore();
                            }
                        }

                    }

                    @Override
                    public void onFail(Exception e) {

                    }
                });

    }

    /**
     * CollapsingToolbarLayout 渐变回调
     *
     * {@link XCollapsingToolbarLayout.OnScrimsListener}
     */
    @SuppressLint("RestrictedApi")
    @Override
    public void onScrimsStateChange(XCollapsingToolbarLayout layout,boolean shown) {
        if (shown) {
            //binding.tvHomeAddress.setTextColor(ContextCompat.getColor(getAttachActivity(), R.color.black));
            binding.tvHomeHint.setBackgroundResource(R.drawable.home_search_bar_gray_bg);
            binding.tvHomeHint.setTextColor(ContextCompat.getColor(getAttachActivity(), R.color.black60));
            //binding.ivHomeSearch.setSupportImageTintList(ColorStateList.valueOf(getColor(R.color.common_icon_color)));
            getStatusBarConfig().statusBarDarkFont(true).init();
        } else {
            //binding.tvHomeAddress.setTextColor(ContextCompat.getColor(getAttachActivity(), R.color.white));
            binding.tvHomeHint.setBackgroundResource(R.drawable.home_search_bar_white_bg);
            binding.tvHomeHint.setTextColor(ContextCompat.getColor(getAttachActivity(), R.color.c999999));
            //binding.ivHomeSearch.setSupportImageTintList(ColorStateList.valueOf(getColor(R.color.white)));
            getStatusBarConfig().statusBarDarkFont(false).init();
        }
    }

    @Override
    public void onRefresh(@NonNull @NotNull RefreshLayout refreshLayout) {
        postDelayed(() -> {
            //mAdapter.clear;
            index = 1;
            initData();
            binding.rlHomeRefresh.finishRefresh();
        }, 1000);
    }

    @Override
    public void onLoadMore(@NonNull @NotNull RefreshLayout refreshLayout) {
        postDelayed(() -> {
            index++;
            getGoodslist();
            binding.rlHomeRefresh.finishRefresh();
        }, 1000);
    }

    private void initListener() {
        // 获取顶部图片高度后，设置滚动监听
        ViewTreeObserver treeObserver = binding.tbHomeTitle.getViewTreeObserver();
        treeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                binding.tbHomeTitle.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                //imageHeight = binding.goodsDetailBanner.getHeight();
                binding.scrollView.setScrollViewListener(HomeFragment.this);
            }
        });
    }

    @Override
    public void onScrollChanged(GradationScrollView scrollView,int x,int y,int oldx,int oldy) {
        if(y <= 0) {
            //设置渐变的头部的背景颜色
            binding.tbHomeTitle.setBackgroundColor(Color.argb((int) 0,255,255,255));
            //binding.tbHomeTitle.setTitleColor(Color.TRANSPARENT);
        } else if(y > 0 ) {
            //滑动距离小于banner图的高度时，设置背景和字体颜色颜色透明度渐变
            //float scale = (float) y / imageHeight;
            //int alpha = (int) (scale * 255);
            binding.tbHomeTitle.setBackgroundColor(Color.BLUE);
            //binding.tbHomeTitle.setBackgroundColor(Color.argb((int) alpha,255,255,255));
            //binding.tbHomeTitle.setTitleColor(Color.argb(alpha,1,24,28));
        } else {
            //滑动到banner下面设置普通颜色
            binding.tbHomeTitle.setBackgroundColor(Color.WHITE);
            //binding.tbHomeTitle.setTitleColor(Color.parseColor("#333333"));
        }
    }
}
