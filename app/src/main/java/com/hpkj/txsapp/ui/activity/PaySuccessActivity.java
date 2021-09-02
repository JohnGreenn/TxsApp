package com.hpkj.txsapp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.hpkj.txsapp.R;
import com.hpkj.txsapp.app.AppActivity;
import com.hpkj.txsapp.databinding.ActivityPaySuccessBinding;
import com.hpkj.txsapp.ui.fragment.HomeFragment;

/**
 * desc：支付成功页面
 * author：Glq
 * edition：txs1.0
 * time：2021/8/25 9:11
 */
public class PaySuccessActivity extends AppActivity<ActivityPaySuccessBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pay_success;
    }

    @Override
    protected void initView() {

        binding.ivPaysuccessEnter.setOnClickListener(v -> MainActivity.start(getActivity(),HomeFragment.class));

    }

    @Override
    protected void initData() {

    }
}