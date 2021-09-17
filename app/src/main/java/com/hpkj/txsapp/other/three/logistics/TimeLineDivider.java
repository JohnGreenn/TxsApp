package com.hpkj.txsapp.other.three.logistics;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.icu.text.Transliterator;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hpkj.txsapp.R;
import com.hpkj.txsapp.ui.utils.SimpleUtils;

import java.util.List;

/**
 * desc：时光轴
 * author：Glq
 * time：2021/09/14 15:16
 */
public class TimeLineDivider extends RecyclerView.ItemDecoration {

    private Context context;
    private Paint paint;
    /**
     * 设置 item  lef他方向的偏移量
     */
    private int leftOffset = 120;
    /**
     * 画的小图标的宽度
     */
    private int iconWidth = 50;
    /**
     * 画的小圆点的半径
     */
    private int circleRadius = 3;

    private int padding;
    private List<LogisticsInfoBean> dataBeanList;

    public TimeLineDivider(Context context, List<LogisticsInfoBean> logisticsInfoBeans) {
        this.context = context;
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(context.getResources().getColor(R.color.gray_deep));
        paint.setTextSize(16);
        paint.setTextAlign(Paint.Align.RIGHT);
        padding = SimpleUtils.dip2px(context,12);
        this.dataBeanList = logisticsInfoBeans;
    }

    @Override
    public void onDraw(@NonNull Canvas canvas,@NonNull RecyclerView parent,@NonNull RecyclerView.State state) {
        canvas.save();
        //先画分割线整体背景色
        canvas.drawColor(context.getResources().getColor(R.color.white));
        final int childCount = parent.getChildCount();
        for(int i = 0; i < childCount ; i++) {
            final View child = parent.getChildAt(i);

            //1.画 1 px 的竖线
            int startX = leftOffset - 30;
            int starty = child.getTop();
            int lineStopY = starty + padding;
            //画图形上半部分虚线
            int position = parent.getChildAdapterPosition(child);
            if(position==0){
                canvas.drawLine(startX, starty, startX, starty, paint);
            }else{
                canvas.drawLine(startX, starty, startX, lineStopY, paint);
            }
            //2.画图形

            LogisticsInfoBean bean = dataBeanList.get(position);
            Rect dst = new Rect(startX - iconWidth/2, lineStopY, startX + iconWidth/2, lineStopY + iconWidth);
            switch(bean.getStatus()) {
                case TIPS:
                    //画圆
                    canvas.drawCircle(startX, lineStopY + circleRadius, circleRadius, paint);
                    break;
                case ORDERED:
                    canvas.drawBitmap(BitmapFactory.decodeResource(context.getResources(),R.drawable.ic_order),null,dst,null);
                    break;
                case STOCK_UP:
                    canvas.drawBitmap(BitmapFactory.decodeResource(context.getResources(),R.drawable.ic_stockup),null,dst,null);
                    break;
                case DELIVERED:
                    canvas.drawBitmap(BitmapFactory.decodeResource(context.getResources(),R.drawable.ic_diliver),null,dst,null);
                    break;
                case TRANSPORTING:
                    canvas.drawBitmap(BitmapFactory.decodeResource(context.getResources(),R.drawable.ic_transporting),null,dst,null);
                    break;
                case RECEIVING:
                    canvas.drawBitmap(BitmapFactory.decodeResource(context.getResources(),R.drawable.ic_receive),null,dst,null);
                    break;
                default:
                    canvas.drawCircle(startX,lineStopY+circleRadius,circleRadius,paint);
                    break;
            }

            //画下半部分竖线
            if (position != dataBeanList.size() -1){
                if(bean.getStatus()==LogisticsStatus.TIPS){
                    canvas.drawLine(startX, lineStopY + 2*circleRadius, startX, child.getBottom(), paint);
                }else {
                    canvas.drawLine(startX, lineStopY + iconWidth, startX, child.getBottom(), paint);
                }
            }
            //3.画日期
            canvas.drawText(bean.getDate(),startX - iconWidth/2 - 10, lineStopY + iconWidth/2, paint);
            canvas.drawText(bean.getTime(),startX - iconWidth/2 - 10, lineStopY + iconWidth/2 + 20, paint);

        }

        canvas.restore();
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect,@NonNull View view,@NonNull RecyclerView parent,@NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect,view,parent,state);
        outRect.left = leftOffset;
    }
}
