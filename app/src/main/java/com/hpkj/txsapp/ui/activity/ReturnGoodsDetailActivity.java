package com.hpkj.txsapp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.hpkj.txsapp.R;
import com.hpkj.txsapp.app.AppActivity;
import com.hpkj.txsapp.databinding.ActivityReturnGoodsDetailBinding;
import com.hpkj.txsapp.databinding.LayoutReturngoodsBinding;

/**
 * desc：退货详情
 * author：Glq
 * edition：txs1.0
 * time：2021/9/8 10:18
 */
public class ReturnGoodsDetailActivity extends AppActivity<ActivityReturnGoodsDetailBinding> {

    private int rgtype = 0;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_return_goods_detail;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

        rgtype = 3;

        LayoutReturngoodsBinding lrgBind = DataBindingUtil.inflate(LayoutInflater.from(getActivity()),R.layout.layout_returngoods,getActivity().findViewById(android.R.id.content),false);
        if(rgtype==2) {
            lrgBind.ivHandle.setImageDrawable(getResources().getDrawable(R.drawable.return_goods_finish));
            lrgBind.lineHandleLeft.setAlpha(1f);
            lrgBind.lineHandleRight.setAlpha(1f);
        }else if(rgtype==3){
            lrgBind.ivCenterReturn.setImageDrawable(getResources().getDrawable(R.drawable.return_goods_finish));
            lrgBind.lineCenterReturnLeft.setAlpha(1f);
            lrgBind.lineCenterReturnRight.setAlpha(1f);
        }else if(rgtype==4){
            lrgBind.ivEnterprise.setImageDrawable(getResources().getDrawable(R.drawable.return_goods_finish));
            lrgBind.lineEnterpriseLeft.setAlpha(1f);
            lrgBind.lineEnterpriseRight.setAlpha(1f);
        }else if(rgtype==5){
            lrgBind.ivMostRight.setImageDrawable(getResources().getDrawable(R.drawable.return_goods_finish));
            lrgBind.lineMostRight.setAlpha(1f);
        }

    }
}