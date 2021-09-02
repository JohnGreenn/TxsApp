package com.hpkj.txsapp.ui.fragment;

import android.util.TypedValue;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import com.hjq.http.EasyHttp;
import com.hjq.http.listener.OnHttpListener;
import com.hpkj.txsapp.R;
import com.hpkj.txsapp.app.TitleBarFragment;
import com.hpkj.txsapp.databinding.FragmentFindBinding;
import com.hpkj.txsapp.databinding.FragmentTopAdsBinding;
import com.hpkj.txsapp.databinding.FragmentTopBannerBinding;
import com.hpkj.txsapp.http.model.HttpData;
import com.hpkj.txsapp.http.request.BannerApi;
import com.hpkj.txsapp.http.request.GetGoodsListApi;
import com.hpkj.txsapp.http.response.ShopGoodsListBean;
import com.hpkj.txsapp.http.response.StartBean;
import com.hpkj.txsapp.other.EncryptUtil;
import com.hpkj.txsapp.other.GridSpaceDecoration;
import com.hpkj.txsapp.ui.activity.MainActivity;
import com.hpkj.txsapp.ui.adapter.GoodsListAdapter;
import com.hpkj.txsapp.ui.adapter.ImageAdapter;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.transformer.AlphaPageTransformer;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * desc：brvah 使用范例
 * author：Glq
 * time：2021/07/27 17:08
 */
public class FindFragment extends TitleBarFragment<MainActivity, FragmentFindBinding> implements OnRefreshLoadMoreListener {

    private List<String> mDatas;
    private GoodsListAdapter mAdapter;
    private int index = 1;
    private int size = 20;
    FragmentTopBannerBinding itemTop = null;
    Banner banner;

    public static FindFragment newInstance() {
        return new FindFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_find;
    }


    @Override
    protected void initView() {

        GridLayoutManager manager = new GridLayoutManager(getActivity(),2);
        int spacing = getResources().getDimensionPixelSize(R.dimen.dp_10);
        /*manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return mAdapter.hasHeaderLayout() || mAdapter.hasFooterLayout() ? manager.getSpanCount() : 1;
            }
        });*/
        //binding.findRecycler.setLayoutManager(manager);
        //binding.findRecycler.addItemDecoration(new HorizontalItemDecoration(spacing,getContext()));


        binding.findRecycler.setLayoutManager(new GridLayoutManager(getContext(),2));
        mAdapter = new GoodsListAdapter();
        binding.findRecycler.setAdapter(mAdapter);
        //binding.findRecycler.setLayoutManager(manager);
        // 添加分割线
        binding.findRecycler.addItemDecoration(new GridSpaceDecoration((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics())));
        //binding.findRecycler.addItemDecoration(new GridSpaceItemDecoration(2,10,10));
        binding.rlFindRefresh.setOnRefreshLoadMoreListener(this);
    }

    @Override
    protected void initData() {

        EasyHttp.post(this)
                .api(new BannerApi()
                        .setBname("home_banner"))
                .request(new OnHttpListener<HttpData<ArrayList<StartBean>>>() {

                    @Override
                    public void onSucceed(HttpData<ArrayList<StartBean>> result) {
                        //ToastUtils.show("banner 请求成功，请看日志");
                        /*添加头部*/
                        //View view = getLayoutInflater().inflate(R.layout.fragment_top_banner, null, false);
                        //banner = view.getRootView().findViewById(R.id.shop_banner);
                        itemTop = DataBindingUtil.inflate(LayoutInflater.from(getActivity()),R.layout.fragment_top_banner,getActivity().findViewById(android.R.id.content),false);

                        if(mAdapter.getHeaderLayoutCount()==0) {
                            mAdapter.addHeaderView(itemTop.getRoot());
                            //头部增加图标
                            addAds();
                        }

                        itemTop.shopBanner.setAdapter(new ImageAdapter(result.getData()));
                        itemTop.shopBanner.setIndicator(new CircleIndicator(getContext()));
                        //添加画廊效果
                        itemTop.shopBanner.setBannerGalleryEffect(18, 10);
                        //添加透明效果(画廊配合透明效果更棒)
                        itemTop.shopBanner.addPageTransformer(new AlphaPageTransformer());
                    }

                    @Override
                    public void onFail(Exception e) {

                    }
                });

        //获取列表数据
        getGoodslist();

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
                                binding.rlFindRefresh.finishRefresh();
                                binding.rlFindRefresh.finishLoadMoreWithNoMoreData();//解决没有更多数据的时候，还显示了loading
                                binding.rlFindRefresh.setNoMoreData(true);
                            } else {
                                mAdapter.addData(result.getData());
                                binding.rlFindRefresh.finishLoadMore();
                            }
                        }

                    }

                    @Override
                    public void onFail(Exception e) {

                    }
                });

    }

    public void addAds() {

        FragmentTopAdsBinding itemAdsBind = DataBindingUtil.inflate(LayoutInflater.from(getActivity()),R.layout.fragment_top_ads,getActivity().findViewById(android.R.id.content),false);
        mAdapter.addHeaderView(itemAdsBind.getRoot());

    }


    /**
     * 模拟数据
     */
    private List<String> analogData() {
        mDatas = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            mDatas.add("hello:" +i);
        }
        return mDatas;
    }

    @Override
    public void onRefresh(@NonNull @NotNull RefreshLayout refreshLayout) {
        postDelayed(() -> {
            //mAdapter.clear;
            index = 1;
            initData();
            binding.rlFindRefresh.finishRefresh();
        }, 1000);
    }

    @Override
    public void onLoadMore(@NonNull @NotNull RefreshLayout refreshLayout) {
        postDelayed(() -> {
            index++;
            getGoodslist();
            binding.rlFindRefresh.finishRefresh();
        }, 1000);
    }


}
