package com.hpkj.txsapp.other;

/**
 * 描述：定义水平方向的距离
 * fileName：com.hpkj.sheplive.mvp.view
 * author：GLQ
 * time：2021/03/11 16:52
 */

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 定义水平方向的距离
 */
public class HorizontalItemDecoration extends RecyclerView.ItemDecoration {
    private int space;//定义2个Item之间的距离
    //private int spanCount;//每行几个

    public HorizontalItemDecoration(int space, Context mContext) {
        this.space = dip2px(space,mContext);
        //this.spanCount = spanCount;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        //int column = position % spanCount;
        int totalCount = parent.getAdapter().getItemCount();
        if (position == 0) {//第一个
            outRect.left = 0;
            outRect.right = space / 2;
        } else if (position == totalCount - 1) {//最后一个
            outRect.left = space / 2;
            outRect.right = 0;
        } else {//中间其它的
            outRect.left = space / 2;
            outRect.right = space / 2;
        }

//        if(column == 0) {
//            outRect.set(space,space,space / 2,0);
//        } else {
//            outRect.set(space / 2,space,space,0);
//        }
    }

    public int dip2px(float dpValue,Context context) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}

