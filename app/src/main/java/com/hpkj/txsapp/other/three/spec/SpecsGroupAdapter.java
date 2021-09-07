package com.hpkj.txsapp.other.three.spec;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hpkj.txsapp.R;

import java.util.List;

/**
 * desc：规格适配器
 * author：Glq
 * edition：txs1.0
 * time：2021/9/6 18:02
 */
public class SpecsGroupAdapter extends CustomAdapter {
    private LayoutInflater mInflater;
    private Context context;
    private List<String> spec_key;
    private List<Integer> hashMap;

    public SpecsGroupAdapter(Context context, List<String> spec_key, List<Integer> hashMap) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.spec_key = spec_key;
        this.hashMap=hashMap;
    }

    @Override
    public int getCount() {
        return spec_key.size();
    }

    @Override
    public Object getItem(int position) {
        return spec_key.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if (convertView == null) {
            holder = new Holder();
            convertView = mInflater.inflate(R.layout.item_specs_group, parent, false);
            holder.tv = (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.tv.setText(spec_key.get(position));
        switch (hashMap.get(position)) {
            case 0:
                holder.tv.setBackgroundDrawable(setShape("#000000", "#ffffff"));
                holder.tv.setTextColor(Color.parseColor("#333333"));
                break;
            case 1:
                holder.tv.setBackgroundDrawable(setShape("#ff5000", "#ffffff"));
                holder.tv.setTextColor(Color.parseColor("#ff5000"));
                break;
            case 2:
                holder.tv.setBackgroundDrawable(setShape("#999999", "#ffffff"));
                holder.tv.setTextColor(Color.parseColor("#cccccc"));
                break;
        }
        return convertView;
    }

    class Holder {
        private TextView tv;
    }

    //设置
    private GradientDrawable setShape(String stroke, String fill) {
        int strokeWidth = 2; // 2 边框宽度
        int roundRadius = 5; // 5 圆角半径
        int strokeColor = Color.parseColor(stroke);//边框颜色
        int fillColor = Color.parseColor(fill);//内部填充颜色

        GradientDrawable gd = new GradientDrawable();//创建drawable
        gd.setColor(fillColor);
        gd.setCornerRadius(roundRadius);
        gd.setStroke(strokeWidth, strokeColor);
        return gd;
    }
}
