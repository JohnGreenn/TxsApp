package com.hpkj.txsapp.widget.view;

/**
 * 描述：
 * fileName：com.hpkj.sheplive.mvp.view
 * author：GLQ
 * time：2020/08/10 9:54
 */

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * 带滚动监听的scrollview
 */
public class GradationScrollView extends ScrollView {
    private GestureDetector mGestureDetector;
    private boolean canScroll;

    public interface ScrollViewListener {
        void onScrollChanged(GradationScrollView scrollView,int x,int y,int oldx,int oldy);
    }

    private ScrollViewListener scrollViewListener = null;

    public GradationScrollView(Context context) {
        super(context);
    }

    public GradationScrollView(Context context,AttributeSet attrs,int defStyle) {
        super(context,attrs,defStyle);
    }

    public GradationScrollView(Context context,AttributeSet attrs) {
        super(context,attrs);
        mGestureDetector = new GestureDetector(context,new YScrollDetector());
        canScroll = true;
        setFadingEdgeLength(0);
    }

    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }

    @Override
    protected void onScrollChanged(int x,int y,int oldx,int oldy) {
        super.onScrollChanged(x,y,oldx,oldy);
        if(scrollViewListener != null) {
            scrollViewListener.onScrollChanged(this,x,y,oldx,oldy);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(ev.getAction() == MotionEvent.ACTION_UP)
            canScroll = true;
        return super.onInterceptTouchEvent(ev) && mGestureDetector.onTouchEvent(ev);
    }

    // Return false if we're scrolling in the x direction
    class YScrollDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onScroll(MotionEvent e1,MotionEvent e2,float distanceX,float distanceY) {
            if(canScroll)
                if(Math.abs(distanceY) >= Math.abs(distanceX))
                    canScroll = true;
                else
                    canScroll = false;
            return canScroll;
        }
    }
}
