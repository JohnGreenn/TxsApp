package com.hpkj.txsapp.other;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/AndroidProject
 *    time   : 2019/07/25
 *    desc   : 图片选择列表分割线
 */
public final class GridSpaceDecoration extends RecyclerView.ItemDecoration {

    private final int spacing;

    public GridSpaceDecoration(int space) {
        spacing = space;
    }

    @Override
    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {}

    @SuppressWarnings("all")
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        int position = recyclerView.getChildAdapterPosition(view);
        int spanCount = ((GridLayoutManager) recyclerView.getLayoutManager()).getSpanCount();
        int column = position % spanCount;

        int cc = ((BaseQuickAdapter) recyclerView.getAdapter()).getHeaderLayoutCount();
        if(cc > 0) {
            if(position == 0) {
                outRect.set(0,0,0,0);
            } else {
                if(column == 0) {
                    outRect.set(spacing / 2,spacing,spacing,0);
                } else {
                    outRect.set(spacing,spacing,spacing / 2,0);
                }
            }
        } else {
            if(column == 1) {
                outRect.set(spacing/2,spacing,spacing,0);
            } else {
                outRect.set(spacing,spacing,spacing/2,0);
            }
        }

        /*// 每一行的最后一个才留出右边间隙
        if ((position + 1) % spanCount == 0) {
            rect.right = mSpace;
        }

        // 只有第一行才留出顶部间隙
        if (position < spanCount) {
            rect.top = mSpace;
        }

        rect.bottom = mSpace;
        rect.left = mSpace;*/
    }

    @Override
    public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {}
}