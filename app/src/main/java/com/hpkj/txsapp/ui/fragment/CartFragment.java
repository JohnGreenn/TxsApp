package com.hpkj.txsapp.ui.fragment;

import androidx.annotation.NonNull;

import com.gyf.immersionbar.ImmersionBar;
import com.hpkj.txsapp.R;
import com.hpkj.txsapp.app.TitleBarFragment;
import com.hpkj.txsapp.databinding.FragmentCartBinding;
import com.hpkj.txsapp.databinding.FragmentFindBinding;
import com.hpkj.txsapp.ui.activity.MainActivity;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;

/**
 * desc：
 * author：Glq
 * time：2021/08/25 15:41
 */
public class CartFragment extends TitleBarFragment<MainActivity, FragmentCartBinding> implements OnRefreshLoadMoreListener {

    public static CartFragment newInstance() {
        return new CartFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cart;
    }

    @Override
    protected void initView() {

        // 给这个 ToolBar 设置顶部内边距，才能和 TitleBar 进行对齐
        ImmersionBar.setTitleBar(getAttachActivity(), binding.titleBar);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {

    }
}
