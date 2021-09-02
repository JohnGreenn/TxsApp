package com.hpkj.txsapp.ui.fragment;

import android.util.TypedValue;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;

import com.gyf.immersionbar.ImmersionBar;
import com.hjq.http.EasyHttp;
import com.hjq.http.listener.OnHttpListener;
import com.hpkj.txsapp.R;
import com.hpkj.txsapp.app.TitleBarFragment;
import com.hpkj.txsapp.databinding.FragmentCartBinding;
import com.hpkj.txsapp.databinding.FragmentCategoryBinding;
import com.hpkj.txsapp.http.model.HttpData;
import com.hpkj.txsapp.http.request.CategoryApi;
import com.hpkj.txsapp.http.request.GetGoodsDetailApi;
import com.hpkj.txsapp.http.response.CateGoryBean;
import com.hpkj.txsapp.http.response.ShopGoodsDetailBean;
import com.hpkj.txsapp.other.EncryptUtil;
import com.hpkj.txsapp.other.GridSpaceDecoration;
import com.hpkj.txsapp.ui.activity.MainActivity;
import com.hpkj.txsapp.ui.adapter.CategoryGoodsAdapter;
import com.hpkj.txsapp.ui.adapter.GoodsListAdapter;
import com.hpkj.txsapp.ui.adapter.ScMenuAdapter;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

/**
 * desc：
 * author：Glq
 * time：2021/08/25 15:41
 */
public class CategoryFragment extends TitleBarFragment<MainActivity, FragmentCategoryBinding> implements OnRefreshLoadMoreListener {

    private List<CateGoryBean> menuList = new ArrayList<>();
    private List<CateGoryBean.ChildTypeBean> homeList = new ArrayList<>();
    private ScMenuAdapter menuAdapter;
    private CategoryGoodsAdapter mAdapter;
    int catgreID = 0;
    private int bigId = 0;
    private int page = 1;

    public static CategoryFragment newInstance() {
        return new CategoryFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_category;
    }

    @Override
    protected void initView() {

        // 给这个 ToolBar 设置顶部内边距，才能和 TitleBar 进行对齐
        ImmersionBar.setTitleBar(getAttachActivity(), binding.tvHomeHint);


        menuAdapter = new ScMenuAdapter(getContext(),menuList);
        binding.lvMenu.setAdapter(menuAdapter);
        binding.lvMenu.setOnItemClickListener((parent,view,position,id) -> {
            page = 1;
            menuAdapter.setSelectItem(position);
            //binding.tvTitile.setText(menuList.get(position).getTypeName());
            catgreID = menuList.get(position).getId();
            bigId = position;
            //getData();
            getRightData();
            menuAdapter.notifyDataSetChanged();
        });


        //右边
        binding.lvScGoods.setLayoutManager(new GridLayoutManager(getContext(),3));
        mAdapter = new CategoryGoodsAdapter();
        binding.lvScGoods.setAdapter(mAdapter);
        //binding.findRecycler.setLayoutManager(manager);
        // 添加分割线
        binding.lvScGoods.addItemDecoration(new GridSpaceDecoration((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics())));


    }

    @Override
    protected void initData() {

        homeList.clear();

        getData();

    }

    private void getData(){

        EasyHttp.get(this)
                .api(new CategoryApi()
                        .setHeaderPass(EncryptUtil.getRequestId(5).trim()))
                .request(new OnHttpListener<HttpData<ArrayList<CateGoryBean>>>() {

                    @Override
                    public void onSucceed(HttpData<ArrayList<CateGoryBean>> result) {

                        //设置头部的名称
                        //binding.tvTitile.setText(value.getBaseData().get(0).getTypeName());
                        /*刷新数据*/
                        menuList.addAll(result.getData());
                        menuAdapter.notifyDataSetChanged();
                        catgreID = result.getData().get(0).getId();

                        for(int i = 0; i < result.getData().get(0).getChildType().size(); i++) {

                            homeList.add(result.getData().get(0).getChildType().get(i));
                            mAdapter.setList(result.getData().get(i).getChildType());
                            //mAdapter.setNewInstance(result.getData().get(i).getChildType());
                        }
                    }

                    @Override
                    public void onFail(Exception e) {
                        toast(e.toString());
                    }
                });
    }

    private void getRightData() {
        mAdapter.setList(menuList.get(bigId).getChildType());
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {

    }
}
