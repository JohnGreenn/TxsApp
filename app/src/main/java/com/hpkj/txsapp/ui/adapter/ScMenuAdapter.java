package com.hpkj.txsapp.ui.adapter;
/**
 * 描述：
 * fileName：com.hpkj.sheplive.adapter
 * author：Hujm
 * 添加版本：V4.2.12
 * time：2020/01/05 15:20
 */

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.hpkj.txsapp.R;
import com.hpkj.txsapp.http.response.CateGoryBean;

import java.util.List;

/**
 * 左侧菜单ListView的适配器
 *
 * @author Administrator
 */
public class ScMenuAdapter extends BaseAdapter {
    private Context context;
    private int selectItem = 0;
    private List<CateGoryBean> list;

    public ScMenuAdapter(Context context,List<CateGoryBean> list) {
        this.list = list;
        this.context = context;
    }

    public int getSelectItem() {
        return selectItem;
    }

    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int arg0) {
        return list.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int arg0,View arg1,ViewGroup arg2) {
        ViewHolder holder = null;
        if(arg1 == null) {
            holder = new ViewHolder();
            arg1 = View.inflate(context,R.layout.item_sc_menu,null);
            holder.tv_name = arg1.findViewById(R.id.item_name);
            holder.left_ico = arg1.findViewById(R.id.item_left_ico);
            arg1.setTag(holder);
        } else {
            holder = (ViewHolder) arg1.getTag();
        }
        if(arg0 == selectItem) {
            //holder.tv_name.setBackgroundColor(Color.WHITE);
            holder.tv_name.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
            holder.tv_name.setTextColor(context.getResources().getColor(R.color.c333333));
            holder.left_ico.setBackgroundColor(context.getResources().getColor(R.color.cFFDC91));
            holder.left_ico.setVisibility(View.VISIBLE);
        } else {
            //holder.tv_name.setBackgroundColor(context.getResources().getColor(R.color.color_f2f2f2));
            holder.tv_name.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
            holder.tv_name.setTextColor(context.getResources().getColor(R.color.c999999));
            holder.left_ico.setVisibility(View.INVISIBLE);
            //holder.left_ico.setBackgroundColor(context.getResources().getColor(R.color.c999999));

        }
        holder.tv_name.setText(list.get(arg0).getTypeName());
        holder.tv_name.setTag(list.get(arg0).getId());
        return arg1;
    }

    public class ViewHolder {
        private TextView tv_name;
        private View left_ico;
    }
}