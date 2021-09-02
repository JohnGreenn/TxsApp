package com.hpkj.txsapp.ui.activity;

import com.hpkj.txsapp.R;
import com.hpkj.txsapp.app.AppActivity;
import com.hpkj.txsapp.app.AppFragment;
import com.hpkj.txsapp.base.FragmentPagerAdapter;
import com.hpkj.txsapp.databinding.ActivityOrderBinding;
import com.hpkj.txsapp.ui.fragment.OrderFragment;
import com.hpkj.txsapp.ui.utils.ClickUtil;

/**
 * desc：activity -> 我的订单
 * author：Glq
 * edition：txs1.0
 * time：2021/9/1 14:58
 */
public class OrderActivity extends AppActivity<ActivityOrderBinding> {

    private FragmentPagerAdapter<AppFragment<?,?>> mPagerAdapter;
    static final int NUM_ITEMS = 5;
    //"全部","待付款","待发货","待收货","已完成"
    private String[][] titileList = new String[][]{{"全部","99"},{"待付款","0"},{"待发货","1"},{"待收货","2"},{"已完成","3"}};

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order;
    }

    @Override
    protected void initView() {

        binding.setClick(new ClickUtil());


        mPagerAdapter = new FragmentPagerAdapter<>(this);
        for(int i = 0; i < NUM_ITEMS; i++) {
            mPagerAdapter.addFragment(OrderFragment.newInstance(Integer.valueOf(titileList[i][1])),titileList[i][0]);
        }

        binding.vpMePager.setAdapter(mPagerAdapter);
        binding.tlMeTab.setupWithViewPager(binding.vpMePager);

    }

    @Override
    protected void initData() {

    }
}