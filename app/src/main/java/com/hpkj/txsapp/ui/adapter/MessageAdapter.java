package com.hpkj.txsapp.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hpkj.txsapp.R;
import com.hpkj.txsapp.app.AppAdapter;
import com.hpkj.txsapp.http.response.ShopGoodsListBean;

import org.jetbrains.annotations.NotNull;

/**
 * desc：
 * author：Glq
 * time：2021/07/28 10:06
 */
public final class MessageAdapter extends AppAdapter<ShopGoodsListBean> {

    public MessageAdapter(Context context) {
        super(context);
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent,int viewType) {
        return new ViewHolder();
    }

    private final class ViewHolder extends AppAdapter<?>.ViewHolder {

        private final TextView mTextView;

        private ViewHolder() {
            super(R.layout.status_item);
            mTextView = findViewById(R.id.tv_status_text);
        }

        @Override
        public void onBindView(int position) {
            mTextView.setText(getItem(position).getGoodName());
        }
    }

}
