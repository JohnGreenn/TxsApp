package com.hpkj.txsapp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.hpkj.txsapp.R;
import com.hpkj.txsapp.app.AppActivity;
import com.hpkj.txsapp.app.AppFragment;
import com.hpkj.txsapp.base.FragmentPagerAdapter;
import com.hpkj.txsapp.databinding.ActivityAfterSalesBinding;
import com.hpkj.txsapp.databinding.HomeTopBinding;
import com.hpkj.txsapp.databinding.ItemAfterSalesBinding;
import com.hpkj.txsapp.databinding.ItemAfterSalesIngBinding;
import com.hpkj.txsapp.databinding.ItemAfterSalesRecordBinding;
import com.hpkj.txsapp.ui.fragment.OrderFragment;

public class AfterSalesActivity extends AppActivity<ActivityAfterSalesBinding> {

    private FragmentPagerAdapter<AppFragment<?,?>> mPagerAdapter;
    static final int NUM_ITEMS = 3;
    //"售后申请","处理中","申请记录"
    private String[][] titileList = new String[][]{{"售后申请","99"},{"处理中","0"},{"申请记录","1"}};

    @Override
    protected int getLayoutId() {
        return R.layout.activity_after_sales;
    }

    @Override
    protected void initView() {

        //HomeTopBinding topBinding= DataBindingUtil.inflate(LayoutInflater.from(getActivity()),R.layout.home_top,getActivity().findViewById(android.R.id.content),false);

        mPagerAdapter = new FragmentPagerAdapter<>(this);
        for(int i = 0; i < NUM_ITEMS; i++) {
            mPagerAdapter.addFragment(OrderFragment.newInstance(Integer.valueOf(titileList[i][1])),titileList[i][0]);
        }

        binding.vpAftersalesPager.setAdapter(mPagerAdapter);
        binding.tlAftersalesTab.setupWithViewPager(binding.vpAftersalesPager);


        //涉及到的几个页面
        ItemAfterSalesBinding item1;//售后申请
        ItemAfterSalesIngBinding item2;//售后处理中
        ItemAfterSalesRecordBinding item3;//售后记录



    }

    @Override
    protected void initData() {

    }
}