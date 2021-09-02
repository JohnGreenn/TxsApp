package com.hpkj.txsapp.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.hpkj.txsapp.R;
import com.hpkj.txsapp.databinding.ItemGoodslistBinding;
import com.hpkj.txsapp.databinding.ItemScGoodsBinding;
import com.hpkj.txsapp.http.response.CateGoryBean;
import com.hpkj.txsapp.http.response.ShopGoodsListBean;
import com.hpkj.txsapp.ui.utils.ClickUtil;

import org.jetbrains.annotations.NotNull;

/**
 * desc：分类右边商品分类列表
 * author：Glq
 * time：2021/08/26 10:06
 */
public class CategoryGoodsAdapter extends BaseQuickAdapter<CateGoryBean.ChildTypeBean, BaseDataBindingHolder<ItemScGoodsBinding>> {

    public CategoryGoodsAdapter() {
        super(R.layout.item_sc_goods);
    }


    @Override
    protected void convert(@NotNull BaseDataBindingHolder<ItemScGoodsBinding> holder,CateGoryBean.ChildTypeBean data) {
        // 获取 Binding
        ItemScGoodsBinding binding = holder.getDataBinding();

        if (binding != null) {
            binding.setData(data);
            binding.setClick(new ClickUtil());
            binding.executePendingBindings();
        }

    }
}
