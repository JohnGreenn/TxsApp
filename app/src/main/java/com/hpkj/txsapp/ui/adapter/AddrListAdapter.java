package com.hpkj.txsapp.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.hpkj.txsapp.R;
import com.hpkj.txsapp.databinding.ItemAddrListBinding;
import com.hpkj.txsapp.databinding.ItemGoodslistBinding;
import com.hpkj.txsapp.http.response.AddrDetailBean;
import com.hpkj.txsapp.http.response.AddrListBean;
import com.hpkj.txsapp.http.response.ShopGoodsListBean;
import com.hpkj.txsapp.ui.utils.ClickUtil;

import org.jetbrains.annotations.NotNull;

/**
 * desc：
 * author：Glq
 * time：2021/08/19 13:48
 */
public class AddrListAdapter extends BaseQuickAdapter<AddrDetailBean, BaseDataBindingHolder<ItemAddrListBinding>> {


    public AddrListAdapter() {
        super(R.layout.item_addr_list);
    }


    @Override
    protected void convert(@NotNull BaseDataBindingHolder<ItemAddrListBinding> holder,AddrDetailBean data) {
        // 获取 Binding
        ItemAddrListBinding binding = holder.getDataBinding();

        if (binding != null) {
            binding.setData(data);
            binding.setClick(new ClickUtil());
            binding.executePendingBindings();
        }

    }
}
