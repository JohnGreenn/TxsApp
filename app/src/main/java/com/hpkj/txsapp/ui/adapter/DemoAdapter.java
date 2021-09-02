package com.hpkj.txsapp.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.hpkj.txsapp.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * desc：brvah 快速使用
 * author：Glq
 * time：2021/07/27 13:47
 */
public class DemoAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public DemoAdapter(int layoutResId,List<String> list) {
        super(layoutResId,list);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder helper,String item) {
        //helper.setText(R.id.tv_picker_name,"This is an Item, pos: "+ (helper.getAdapterPosition() - getHeaderLayoutCount()));
        helper.setText(R.id.id_num,"This is :"+item);
    }
}
