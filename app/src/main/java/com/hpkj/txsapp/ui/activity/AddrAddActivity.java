package com.hpkj.txsapp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.hpkj.txsapp.R;
import com.hpkj.txsapp.app.AppActivity;
import com.hpkj.txsapp.base.BaseDialog;
import com.hpkj.txsapp.databinding.ActivityAddrAddBinding;
import com.hpkj.txsapp.ui.dialog.AddressDialog;

/**
 * 描述：新增收货地址
 * 作者：GLQ
 * 添加版本：txs 1.0
 * 时间：2021/8/19 17:27
 * -------------------------------
 */
public class AddrAddActivity extends AppActivity<ActivityAddrAddBinding> {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_addr_add;
    }

    @Override
    protected void initView() {

        binding.addrAddArea.setOnClickListener(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {

        // 选择地区对话框
        new AddressDialog.Builder(this)
                .setTitle(getString(R.string.address_title))
                // 设置默认省份
                //.setProvince("广东省")
                // 设置默认城市（必须要先设置默认省份）
                //.setCity("广州市")
                // 不选择县级区域
                //.setIgnoreArea()
                .setListener(new AddressDialog.OnListener() {

                    @Override
                    public void onSelected(BaseDialog dialog, String province, String city, String area) {
                        toast(province + city + area);
                    }

                    @Override
                    public void onCancel(BaseDialog dialog) {
                        toast("取消了");
                    }
                })
                .show();

    }
}