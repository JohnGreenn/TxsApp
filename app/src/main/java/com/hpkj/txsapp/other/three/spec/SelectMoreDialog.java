package com.hpkj.txsapp.other.three.spec;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hpkj.txsapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * desc：选择对话框
 * author：Glq
 * edition：txs1.0
 * time：2021/9/6 18:04
 */
public class SelectMoreDialog extends Dialog implements View.OnClickListener {
    private Context context;
    private int w, h;
    private ImageView iv_dismiss_dialog;
    //商品参数
    private ImageView iv_goods_pic;
    private TextView tv_goods_price;
    private String pic_url;
    private int repertory_counts;
    //
    private LinearLayout ln_add_view;
    private ArrayList<SpecsGroupAdapter> adapterList;
    private ArrayList<List<Integer>> selectList;
    //数量选择
    private ImageView iv_minus_counts;
    private TextView tv_counts;
    private ImageView iv_plus_counts;
    private int counts = 1;
    //确定等
    private TextView tv_sure;
    //
    private Data data;
    private List<Data.SpecKeyBean> specKeyList = new ArrayList<>();
    private List<Data.SpecsGroupBean> specsGroupList = new ArrayList<>();
    //
    private List<String> selectSpecsGroupList;
    private List<String> changeSpecsGroupList;
    private List<List<String>> allSpecsGroupList;

    public SelectMoreDialog(Context context, Data data) {
        super(context, R.style.SizeDialog);
        this.context = context;
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.data = data;
        specKeyList = data.getSpecKey();
        specsGroupList = data.getSpecsGroup();
        Window window = this.getWindow();
        window.setGravity(Gravity.BOTTOM);
        w = (int) (context.getResources().getDisplayMetrics().widthPixels);
        h = (int) (context.getResources().getDisplayMetrics().heightPixels * 900 / 1280);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_select_more);
        initView();
        initEvent();
        this.getWindow().setLayout(w, h);
    }

    private void initView() {
        ln_add_view = (LinearLayout) findViewById(R.id.ln_add_view);
        iv_dismiss_dialog = (ImageView) findViewById(R.id.iv_dismiss_dialog);
        iv_goods_pic = (ImageView) findViewById(R.id.iv_goods_pic);
        tv_goods_price = (TextView) findViewById(R.id.tv_goods_price);
        //区分立即购买、加入购物车
        tv_sure = (TextView) findViewById(R.id.tv_sure);
        //数量选择
        iv_minus_counts = (ImageView) findViewById(R.id.iv_minus_counts);
        tv_counts = (TextView) findViewById(R.id.tv_counts);
        iv_plus_counts = (ImageView) findViewById(R.id.iv_plus_counts);
        counts = Integer.parseInt(tv_counts.getText().toString());
        if (specsGroupList.size() > 0 || specsGroupList != null) {
            selectSpecsGroupList = specsGroupList.get(0).getGoods_spec();
            Glide.with(context).load(specsGroupList.get(0).getImg()).into(iv_goods_pic);
            tv_goods_price.setText(specsGroupList.get(0).getPrice());
            repertory_counts = Integer.parseInt(specsGroupList.get(0).getRepertory());
        }
        addView();
    }

    private void addView() {
        adapterList = new ArrayList<>();
        //规格组合的第一个 为选择
        if (specsGroupList.size() > 0 || specsGroupList != null) {
            selectSpecsGroupList = specsGroupList.get(0).getGoods_spec();

            changeSpecsGroupList = new ArrayList<>();
            changeSpecsGroupList.addAll(selectSpecsGroupList);
        }

        //后台所给的所有规格组合的集合
        allSpecsGroupList = new ArrayList<>();
        for (Data.SpecsGroupBean specsGroupBean : specsGroupList) {
            List<String> list = specsGroupBean.getGoods_spec();
            allSpecsGroupList.add(list);
        }

        selectList = new ArrayList<>();
        for (int i = 0; i < specKeyList.size(); i++) {
            List<Integer> list = new ArrayList<>();
            //获取规格
            List<String> specKeyString = specKeyList.get(i).getSpec_key();
            for (int j = 0; j < specKeyString.size(); j++) {
                if (specKeyString.get(j).equals(selectSpecsGroupList.get(i))) {
                    list.add(j, 1);
                } else {
                    list.add(j, 0);
                }
            }
            selectList.add(i, list);
        }
        //添加View
        for (int i = 0; i < specKeyList.size(); i++) {
            //AddView
            View view = LayoutInflater.from(context).inflate(R.layout.item_specs_key, null);
            TextView tvSpecKey = (TextView) view.findViewById(R.id.tv_spec_key);
            CustomListView customListView = (CustomListView) view.findViewById(R.id.custom_list_view);
            //
            Data.SpecKeyBean specKeyBean = specKeyList.get(i);
            //各规格属性联动
            getSetting(i, specKeyBean);
            //设置数据
            tvSpecKey.setText(specKeyBean.getSpec_name());
            SpecsGroupAdapter specGroupAdapter = new SpecsGroupAdapter(context, specKeyBean.getSpec_key(), selectList.get(i));
            adapterList.add(specGroupAdapter);
            customListView.setAdapter(specGroupAdapter);
            final int finalI = i;
            specGroupAdapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    int clickFormat = finalI;
                    Data.SpecKeyBean clickSpecKeyBean = specKeyList.get(clickFormat);
                    //步骤1：先处理点击事件
                    if (selectList.get(clickFormat).get(position) != 2) {
                        //遍历一下
                        for (int i = 0; i < selectList.get(clickFormat).size(); i++) {
                            switch (selectList.get(clickFormat).get(i)) {
                                case 0:
                                    if (i == position) {
                                        selectList.get(clickFormat).set(i, 1);
                                    }
                                    break;
                                case 1:
                                    selectList.get(clickFormat).set(i, 0);
                                    break;
                                case 2:
                                    break;
                            }
                        }
                    }

                    //点击之后的  各规格的选择状态
                    List<String> stringsList = new ArrayList<>();
                    stringsList = clickSpecKeyBean.getSpec_key();
                    if (selectList.get(clickFormat).contains(1)) {
                        for (int g = 0; g < selectList.get(clickFormat).size(); g++) {
                            if (selectList.get(clickFormat).get(g) == 1) {
                                changeSpecsGroupList.set(clickFormat, stringsList.get(g));
                            }
                        }
                    } else {
                        changeSpecsGroupList.set(clickFormat, "未选");
                    }

                    //根据选择的组合 设置价格，库存，图片
                    if (!changeSpecsGroupList.contains("未选")) {
                        StringBuilder sb = new StringBuilder();
                        for (String s : changeSpecsGroupList) {//
                            sb.append(s).append(",");
                        }
                        //这样就可以把集合转化为字符串了
                        String newString = sb.toString();
                        for (Data.SpecsGroupBean specBean : specsGroupList) {
                            StringBuilder sbSpec = new StringBuilder();
                            for (String s : specBean.getGoods_spec()) {
                                sbSpec.append(s).append(",");
                            }
                            //这样就可以把集合转化为字符串了
                            String specString = sbSpec.toString();
                            if (newString.contains(specString)) {
                                pic_url = specBean.getImg();
                                Glide.with(context).load(pic_url).into(iv_goods_pic);
                                tv_goods_price.setText(specBean.getPrice());
                                repertory_counts = Integer.parseInt(specBean.getRepertory());
                                counts = 1;
                                tv_counts.setText(counts + "");
                                iv_minus_counts.setImageResource(R.mipmap.icon_minus_light);
                                if (repertory_counts == 1) {
                                    iv_plus_counts.setImageResource(R.mipmap.icon_plus_light);
                                } else {
                                    iv_plus_counts.setImageResource(R.mipmap.icon_plus_deep);
                                }
                            }
                        }
                    }

                    for (int i = 0; i < specKeyList.size(); i++) {
                        Data.SpecKeyBean specKeyBean = specKeyList.get(i);
                        //各规格属性联动
                        getSetting(i, specKeyBean);
                        adapterList.get(i).notifyDataSetChanged();
                    }
                }
            });

            ln_add_view.addView(view);
        }
    }

    //各规格属性联动
    private void getSetting(int position, Data.SpecKeyBean specKeyBean) {
        ArrayList<List<String>> list = new ArrayList<>();
        list.addAll(allSpecsGroupList);

        //不含有已选规格属性的属性组合的数组
        ArrayList<List<String>> remove_list = new ArrayList<>();
        //遍历数据中 所有规则属性的组合
        for (int goods_i = 0; goods_i < list.size(); goods_i++) {
            List<String> goodsList = list.get(goods_i);
            //遍历选中组合
            for (int select_i = 0; select_i < changeSpecsGroupList.size(); select_i++) {
                //去掉一个规格
                if (select_i == position) {

                } else {
                    if (!changeSpecsGroupList.get(select_i).equals(goodsList.get(select_i))) {
                        if (!changeSpecsGroupList.get(select_i).equals("未选")) {
                            remove_list.add(list.get(goods_i));
                        }
                    }
                }
            }
        }
        Log.e("young","remove_list==="+remove_list.toString());
        //除掉不含有已选规格属性的属性组合的数组  得到在包含此规格外 其他规格已选属性的组合的数组
        list.removeAll(remove_list);
        Log.e("young","list==="+list.toString());
        //aloneString组合为 该规格下 所能有的全部属性
        ArrayList<String> aloneString = new ArrayList<>();
        for (int j = 0; j < list.size(); j++) {
            List<String> specialList = list.get(j);
            aloneString.add(specialList.get(position));
        }
        Log.e("young","aloneString==="+aloneString.toString());
        //通过这些字段组合 去对比此规格的所有样式  然后设置 是否有此规格组合
        for (int m = 0; m < specKeyBean.getSpec_key().size(); m++) {
            if (!aloneString.contains(specKeyBean.getSpec_key().get(m))) {
                selectList.get(position).set(m, 2);
            } else {
                switch (selectList.get(position).get(m)) {
                    case 0:
                        selectList.get(position).set(m, 0);
                        break;
                    case 1:
                        selectList.get(position).set(m, 1);
                        break;
                    case 2:
                        selectList.get(position).set(m, 0);
                        break;
                }
            }
        }

    }

    private void initEvent() {
        iv_dismiss_dialog.setOnClickListener(this);
        iv_minus_counts.setOnClickListener(this);
        iv_plus_counts.setOnClickListener(this);
        tv_sure.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_dismiss_dialog:
                dismiss();
                break;
            case R.id.iv_minus_counts:
                MinusCounts();
                break;
            case R.id.iv_plus_counts:
                PlusCounts();
                break;
            case R.id.tv_sure:
                dismiss();
                break;
            /*case R.id.tv_buy_now:
                dismiss();
                break;*/
        }
    }


    private void MinusCounts() {
        if (counts == 1) {

        } else {
            if (counts == repertory_counts) {
                iv_plus_counts.setImageResource(R.mipmap.icon_plus_deep);
            }
            counts = counts - 1;
            tv_counts.setText(counts + "");
            if (counts == 1) {
                iv_minus_counts.setImageResource(R.mipmap.icon_minus_light);
            }
        }
    }

    private void PlusCounts() {
        if (counts == repertory_counts) {
            iv_plus_counts.setImageResource(R.mipmap.icon_plus_light);
        } else {
            if (counts == 1) {
                iv_minus_counts.setImageResource(R.mipmap.icon_minus_deep);
            }
            counts = counts + 1;
            tv_counts.setText(counts + "");
            if (counts == repertory_counts) {
                iv_plus_counts.setImageResource(R.mipmap.icon_plus_light);
            }
        }
    }


}
