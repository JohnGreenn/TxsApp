package com.hpkj.txsapp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.hpkj.txsapp.R;
import com.hpkj.txsapp.app.AppActivity;
import com.hpkj.txsapp.databinding.ActivityAfterSalesBinding;
import com.hpkj.txsapp.databinding.HomeTopBinding;

public class AfterSalesActivity extends AppActivity<ActivityAfterSalesBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_after_sales;
    }

    @Override
    protected void initView() {

        //HomeTopBinding topBinding= DataBindingUtil.inflate(LayoutInflater.from(getActivity()),R.layout.home_top,getActivity().findViewById(android.R.id.content),false);


    }

    @Override
    protected void initData() {

    }
}