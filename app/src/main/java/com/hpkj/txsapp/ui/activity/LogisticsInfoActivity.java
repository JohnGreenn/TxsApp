package com.hpkj.txsapp.ui.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hpkj.txsapp.R;
import com.hpkj.txsapp.app.AppActivity;
import com.hpkj.txsapp.databinding.ActivityLogisticsInfoBinding;
import com.hpkj.txsapp.other.three.logistics.LogisticsInfoBean;
import com.hpkj.txsapp.other.three.logistics.LogisticsStatus;
import com.hpkj.txsapp.other.three.logistics.TimeLineAdapter;
import com.hpkj.txsapp.other.three.logistics.TimeLineDivider;

import java.util.ArrayList;
import java.util.List;

/**
 * desc：物流信息
 * author：Glq
 * time：2021/09/14 15:28
 */
public class LogisticsInfoActivity extends AppActivity<ActivityLogisticsInfoBinding> {

    private List<LogisticsInfoBean> dataBeanList = new ArrayList<>();
    private TimeLineAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_logistics_info;
    }

    @Override

    protected void initView() {
        adapter = new TimeLineAdapter(dataBeanList,this);
        binding.rvLogistics.setLayoutManager(new LinearLayoutManager(this));
        binding.rvLogistics.addItemDecoration(setDivider());
        binding.rvLogistics.setAdapter(adapter);
    }

    /**
     * 设置分割线
     * @return
     */
    protected RecyclerView.ItemDecoration setDivider() {
        return new TimeLineDivider(this,dataBeanList);
    }

    @Override
    protected void initData() {
        dataBeanList.add(new LogisticsInfoBean("[收货地址，xxxxxxx]",LogisticsStatus.RECEIVING,"02-11","10:00"));
        dataBeanList.add(new LogisticsInfoBean("运输中x1",LogisticsStatus.TRANSPORTING,"02-10","12:00"));
        dataBeanList.add(new LogisticsInfoBean("小主，\n运输中x2",LogisticsStatus.TRANSPORTING,"02-10","12:10"));
        dataBeanList.add(new LogisticsInfoBean("小主，\n\n运输中x3",LogisticsStatus.TRANSPORTING,"02-10","12:20"));
        dataBeanList.add(new LogisticsInfoBean("小主，\n运输中x4",LogisticsStatus.TRANSPORTING,"02-10","12:30"));
        dataBeanList.add(new LogisticsInfoBean("已发货",LogisticsStatus.DELIVERED,"02-10","10:00"));
        dataBeanList.add(new LogisticsInfoBean("备货中",LogisticsStatus.STOCK_UP,"02-09","12:00"));
        dataBeanList.add(new LogisticsInfoBean("订单支付成功，系统正在处理",LogisticsStatus.ORDERED,"02-09","10:10"));
        dataBeanList.add(new LogisticsInfoBean("订单创建成功，等待支付",LogisticsStatus.TIPS,"02-09","10:00"));

        adapter.notifyDataSetChanged();
    }
}
