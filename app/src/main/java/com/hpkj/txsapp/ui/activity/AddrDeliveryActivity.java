package com.hpkj.txsapp.ui.activity;


import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.View;

import com.hjq.http.EasyHttp;
import com.hjq.http.listener.OnHttpListener;
import com.hpkj.txsapp.R;
import com.hpkj.txsapp.app.AppActivity;
import com.hpkj.txsapp.databinding.ActivityAddrDeliveryBinding;
import com.hpkj.txsapp.http.model.HttpData;
import com.hpkj.txsapp.http.request.AddrListApi;
import com.hpkj.txsapp.http.response.AddrListBean;
import com.hpkj.txsapp.ui.adapter.AddrListAdapter;


public class AddrDeliveryActivity extends AppActivity<ActivityAddrDeliveryBinding> {

    private AddrListAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_addr_delivery;
    }

    @Override
    protected void initView() {

        mAdapter = new AddrListAdapter();
        binding.rvAddrList.setAdapter(mAdapter);
        binding.rvAddrList.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.btnAddrAdd.setOnClickListener(this);

    }

    @Override
    protected void initData() {

        //获取列表数据
        getData();
    }

    private void getData() {

        EasyHttp.post(this)
                .api(new AddrListApi()
                        .setPage(1)
                        .setPageSize(10))
                .request(new OnHttpListener<HttpData<AddrListBean>>() {
                    @Override
                    public void onSucceed(HttpData<AddrListBean> result) {
                        mAdapter.setList(result.getData().getData());
                    }

                    @Override
                    public void onFail(Exception e) {
                        toast(e.toString());
                    }
                });
    }

    @Override
    public void onClick(View view) {
        startActivity(AddrAddActivity.class);
    }
}