package com.hpkj.txsapp.ui.fragment;

import android.view.View;

import com.hpkj.txsapp.R;
import com.hpkj.txsapp.app.TitleBarFragment;
import com.hpkj.txsapp.databinding.FragmentMyBinding;
import com.hpkj.txsapp.ui.activity.AddrDeliveryActivity;
import com.hpkj.txsapp.ui.activity.MainActivity;
import com.hpkj.txsapp.ui.activity.PaySuccessActivity;
import com.hpkj.txsapp.ui.utils.ClickUtil;

/**
 * desc：我的页面
 * author：Glq
 * edition：txs1.0
 * time：2021/8/24 9:08
 */
public class MyFragment extends TitleBarFragment<MainActivity, FragmentMyBinding> {

    public static MyFragment newInstance() {
        return new MyFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView() {

        binding.setClick(new ClickUtil());

        binding.btnToaddr.setOnClickListener(v -> startActivity(AddrDeliveryActivity.class));
        binding.llFeedback.setOnClickListener(v -> startActivity(PaySuccessActivity.class));

    }

    @Override
    protected void initData() {

    }
}
