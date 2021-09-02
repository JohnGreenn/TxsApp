package com.hpkj.txsapp.ui.utils;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.hpkj.txsapp.http.response.ShopGoodsListBean;
import com.hpkj.txsapp.ui.activity.GoodsDetailActivity;
import com.hpkj.txsapp.ui.activity.OrderActivity;
import com.hpkj.txsapp.ui.activity.SearchActivity;

/**
 * desc：点击事件处理
 * author：Glq
 * time：2021/07/29 9:49
 */
public class ClickUtil {

    /**
     * 设置图片显示
     *
     * @param imageView
     * @param url
     * @param moren     默认图片
     */
    @BindingAdapter(value = {"url","imgdefault"}, requireAll = false)
    public static void imageLoader(ImageView imageView,String url,Drawable moren) {
        if(null != url && (url.startsWith("http:") || url.startsWith("https:"))) {
            SimpleUtils.loadImageForView(imageView.getContext(),imageView,url,moren);
        } else {
            SimpleUtils.loadImageForView(imageView.getContext(),imageView,"http:" + url,moren);
        }
    }

    public void showGoodsDetail(View view,int goodsid) {
        Intent intent = new Intent(view.getContext(),GoodsDetailActivity.class);
        intent.putExtra("gid",goodsid);
        view.getContext().startActivity(intent);
    }

    public void toSearch(View view) {
        Intent intent = new Intent(view.getContext(), SearchActivity.class);
        view.getContext().startActivity(intent);
    }

    public int getUserMems() {
        int memstatus = 3;//用户等级
        return memstatus;
    }

    public String finalprice(int type,ShopGoodsListBean bean) {

        //type=1 尊 type=2 标

        int memstatus = 3;//用户等级
        String showprice = null;

        if(type==1){
            if(memstatus>2) {
                showprice = bean.getPriceList().get(2).getShowPrice();
            }else{
                //如果不是尊享会员显示***
                showprice = "***";
            }
        }else if(type==2){
            showprice = bean.getPriceList().get(1).getShowPrice();
        }

        return showprice == null ? "-" : showprice;
    }

    public void toOrder(View view) {
        Intent intent = new Intent(view.getContext(), OrderActivity.class);
        view.getContext().startActivity(intent);
    }


}
