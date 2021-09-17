package com.hpkj.txsapp.other.three.logistics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hpkj.txsapp.R;

import java.util.List;

/**
 * desc：
 * author：Glq
 * time：2021/09/16 13:35
 */
public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineAdapter.ViewHolder> {

    private Context context;
    private List<LogisticsInfoBean> items;

    public TimeLineAdapter(List<LogisticsInfoBean> items, Context context) {
        this.items = items;
        this.context = context;
    }

    /**
     *  事件监听
     */
    private onItemClickListener onItemClickListener;
    private onItemLongClickListener onItemLongClickListener;

    public interface onItemClickListener{
        void  onItemClick(View view, int position);
    }
    public interface onItemLongClickListener{
        void  onItemLongClick(View view, int position);
    }

    public void  setOnItemClickListener (onItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
    public void  setOnItemLongClickListener (onItemLongClickListener onItemLongClickListener){
        this.onItemLongClickListener = onItemLongClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_timeline, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeLineAdapter.ViewHolder holder,@SuppressLint("RecyclerView") int position) {
        LogisticsInfoBean item = items.get(position);
        holder.tvItem.setText(item.getMessage());
        holder.tvTime.setText(item.getTime());
        holder.llLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener !=null){
                    onItemClickListener.onItemClick(view,position);
                }
            }
        });

        holder.llLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (onItemLongClickListener !=null){
                    onItemLongClickListener.onItemLongClick(view,position);
                }
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvItem;
        TextView tvTime;//时间
        RelativeLayout llLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tv_item);
            tvTime = itemView.findViewById(R.id.tv_time);
            llLayout = itemView.findViewById(R.id.ll_layout);
        }
    }
}
