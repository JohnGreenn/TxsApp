package com.hpkj.txsapp.ui.fragment;

import android.os.Bundle;

import com.hpkj.txsapp.R;
import com.hpkj.txsapp.app.TitleBarFragment;
import com.hpkj.txsapp.databinding.FragmentOrderBinding;
import com.hpkj.txsapp.ui.activity.MainActivity;
import com.hpkj.txsapp.ui.activity.OrderActivity;

/**
 * desc：
 * author：Glq
 * time：2021/09/01 9:52
 */
public class OrderFragment extends TitleBarFragment<OrderActivity, FragmentOrderBinding> {

    public static OrderFragment newInstance(int type) {
        OrderFragment fragment = new OrderFragment();
        Bundle args = new Bundle();
        args.putInt("type",type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_order;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
