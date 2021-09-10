package com.hpkj.txsapp.widget.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hpkj.txsapp.R;

/**
 * desc：退货自定view
 * author：Glq
 * time：2021/09/08 10:47
 */
public class ReturnGoodsView extends FrameLayout {

    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;
    private ImageView img5;

    private View line1;
    private View line2;
    private View line3;
    private View line4;
    private View line5;
    private View line6;
    private View line7;
    private View line8;





    public ReturnGoodsView(@NonNull Context context) {
        super(context);
        init(context,null);
    }

    public ReturnGoodsView(@NonNull Context context,@Nullable AttributeSet attrs) {
        super(context,attrs);
        init(context,attrs);
    }

    public ReturnGoodsView(@NonNull Context context,@Nullable AttributeSet attrs,int defStyleAttr) {
        super(context,attrs,defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context,AttributeSet attrs) {
        inflate(context,R.layout.layout_returngoods,this);
        line1 = findViewById(R.id.line_most_left);
        line2 = findViewById(R.id.line_handle_left);
        line3 = findViewById(R.id.line_handle_right);
        line4 = findViewById(R.id.line_center_return_left);
        line5 = findViewById(R.id.line_center_return_right);
        line6 = findViewById(R.id.line_enterprise_left);
        line7 = findViewById(R.id.line_enterprise_right);
        line8 = findViewById(R.id.line_most_right);

        img1 = findViewById(R.id.iv_most_left);
        img2 = findViewById(R.id.iv_handle);
        img3 = findViewById(R.id.iv_center_return);
        img4 = findViewById(R.id.iv_enterprise);
        img5 = findViewById(R.id.iv_most_right);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ReturnGoodsView);
        //根据状态显示：1：提交申请 2：处理申请 3：寄回商品 4：商家处理 5：换货成功
        int status = ta.getResourceId(R.styleable.ReturnGoodsView_return_status,1);

        if(status==2) {
            img2.setImageDrawable(getResources().getDrawable(R.drawable.return_goods_finish));
            line2.setAlpha(1f);
            line3.setAlpha(1f);
        }else if(status==3){
            img3.setImageDrawable(getResources().getDrawable(R.drawable.return_goods_finish));
            line4.setAlpha(1f);
            line5.setAlpha(1f);
        }else if(status==4){
            img4.setImageDrawable(getResources().getDrawable(R.drawable.return_goods_finish));
            line6.setAlpha(1f);
            line7.setAlpha(1f);
        }else if(status==5){
            img5.setImageDrawable(getResources().getDrawable(R.drawable.return_goods_finish));
            line8.setAlpha(1f);
        }

        ta.recycle();

    }

    public void setStatus(){
        line6.setAlpha(1f);
    }
}
