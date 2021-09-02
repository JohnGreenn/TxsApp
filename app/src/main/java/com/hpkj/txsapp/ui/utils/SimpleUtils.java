package com.hpkj.txsapp.ui.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.hpkj.txsapp.R;
import com.hpkj.txsapp.app.AppApplication;

/**
 * 描述：图片加载辅助
 * author：GeLing
 */
public class SimpleUtils {
    private static RequestOptions options = new RequestOptions()
            //设置图片加载的优先级
            .priority(Priority.NORMAL)
            //缓存策略,跳过内存缓存【此处应该设置为false，否则列表刷新时会闪一下】
            .skipMemoryCache(false)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            //默认淡入淡出动画
//            .transform(new TranslateAnimation())
            //设置占位符,默认
            .placeholder(R.drawable.bg_empty)
            //设置错误符,默认
            .error(R.drawable.bg_empty);

    /*
     *
     * 简单的加载图片,依赖Glide
     * */
    public static void loadImageForView(Context context,ImageView imageView,String url,int srcimg) {
        options.placeholder(srcimg);
        options.error(srcimg);
        options.dontAnimate();
        Glide.with(AppApplication.activity).load(url).apply(options).into(imageView);
    }

    /*
     *
     * 简单的加载图片,依赖Glide
     * */
    public static void loadImageForView(Context context,ImageView imageView,String url,Drawable srcimg) {
        options.placeholder(srcimg);
        options.error(srcimg);
        options.dontAnimate();
        Glide.with(context).load(url).apply(options).into(imageView);
    }

    /*
     *
     * 多图加载,依赖Glide
     * */
    public static void loadImageForView(Context context,ImageView imageView,String url,Drawable srcimg,boolean mutilPic) {
        options.placeholder(srcimg);
        options.error(srcimg);
        options.dontAnimate();
        Glide.with(AppApplication.activity).load(url).apply(options).into(imageView);
    }

    /**
     * dp转px
     * 16dp - 48px
     * 17dp - 51px
     */
    public static int dip2px(Context context,float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) ((dpValue * scale) + 0.5f);
    }
}
