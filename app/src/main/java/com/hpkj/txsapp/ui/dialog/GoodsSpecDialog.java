package com.hpkj.txsapp.ui.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hpkj.txsapp.R;
import com.hpkj.txsapp.aop.SingleClick;
import com.hpkj.txsapp.app.AppAdapter;
import com.hpkj.txsapp.base.BaseAdapter;
import com.hpkj.txsapp.base.BaseDialog;
import com.hpkj.txsapp.databinding.DialogGdSpecBinding;
import com.hpkj.txsapp.databinding.DialogGdSpecItemBinding;
import com.hpkj.txsapp.http.response.SpecificationsListBean;
import com.hpkj.txsapp.other.three.flowlayout.FlowLayout;
import com.hpkj.txsapp.other.three.flowlayout.TagAdapter;
import com.hpkj.txsapp.other.three.flowlayout.TagFlowLayout;
import com.hpkj.txsapp.ui.activity.SearchActivity;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *    desc: 商品规格选择dialog
 */
public final class GoodsSpecDialog {

    public static final class Builder
            extends BaseDialog.Builder<Builder>
            implements BaseAdapter.OnItemClickListener,
            View.OnLayoutChangeListener, Runnable {

        @SuppressWarnings("rawtypes")
        private OnListener mListener;
        private boolean mAutoDismiss = true;

        private final RecyclerView mRecyclerView;
        private final ImageView mCancelView;

        private final MenuAdapter mAdapter;

        private RoundedImageView mPic;
        private TextView mPrice;
        private LinearLayout llspecshow;
        DialogGdSpecItemBinding itemBinding;
        //DialogGdSpecBinding item;

        private TagAdapter mRecordsAdapter;

        public Builder(Context context) {
            super(context);

            setContentView(R.layout.dialog_gd_spec);
            //setContentView(item.getRoot());
            setAnimStyle(BaseDialog.ANIM_BOTTOM);

            mRecyclerView = findViewById(R.id.rv_menu_list);
            mCancelView  = findViewById(R.id.iv_gd_dialog_cancel);

            mPic = findViewById(R.id.riv_gd_dialog_pic);
            mPrice = findViewById(R.id.tv_gd_dialog_price);
            llspecshow = findViewById(R.id.ll_gd_spec);

            setOnClickListener(mCancelView);

            mAdapter = new MenuAdapter(getContext());
            mAdapter.setOnItemClickListener(this);
            //mRecyclerView.setAdapter(mAdapter);
            //加载规格

        }

/*        @Override
        public Builder setGravity(int gravity) {
            switch (gravity) {
                // 如果这个是在中间显示的
                case Gravity.CENTER:
                case Gravity.CENTER_VERTICAL:
                    // 重新设置动画
                    setAnimStyle(BaseDialog.ANIM_SCALE);
                    break;
                default:
                    break;
            }
            return super.setGravity(gravity);
        }*/

/*        public Builder setPrice(@StringRes int id) {
            return setPrice(getString(id));
        }*/

        public Builder setPrice(CharSequence text) {
            mPrice.setText(text);
            return this;
        }

        public Builder setPic(@StringRes int id) {
            return setPic(getString(id));
        }

        public Builder setPic(CharSequence text) {

            Glide.with(getContext())
                    .load(text)
                    .circleCrop()
                    .into(mPic);
            //mPic.setText(text);
            return this;
        }

/*        public Builder setSpecData(int... ids) {
            List<SpecificationsListBean> data = new ArrayList<>(ids.length);
            for (int id : ids) {
                data.add(getString(id));
            }
            return setSpecData(data);
        }*/

        public Builder setSpecData(List<SpecificationsListBean> dataList) {

            for(int i = 0; i <dataList.size() ; i++) {
                View viewAll =  LayoutInflater.from(getContext()).inflate(
                        R.layout.dialog_gd_spec_item,null);

                if(viewAll.getParent()!=null){
                    llspecshow.removeAllViews();
                }
                //加载标题
                String mSpecname = dataList.get(i).getName();
                ((TextView) viewAll.findViewById(R.id.tv_gd_spec_item_title)).setText(mSpecname);

                //加载规格
                TagFlowLayout tagFlow = viewAll.findViewById(R.id.fl_gd_spec);

/*                if(mRecordsAdapter != null) {
                    mRecordsAdapter.setData(dataList.get(i).getValues());
                    mRecordsAdapter.notifyDataChanged();
                }*/

                //创建历史标签适配器
                //为标签设置对应的内容
                mRecordsAdapter = new TagAdapter<SpecificationsListBean.ValuesBean>(dataList.get(i).getValues()) {
                    @Override
                    public View getView(FlowLayout parent,int position,SpecificationsListBean.ValuesBean valuesBean) {
                        TextView tv = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.tv_spec,
                                tagFlow,false);

                        //为标签设置对应的内容
                        tv.setText(valuesBean.getSpecificationsName());
                        return tv;
                    }
                };

                tagFlow.setOnTagClickListener((view,position,parent) -> {

                    TextView tvTag = findViewById(R.id.tv_spec_tag);
                    tvTag.setBackgroundResource(R.drawable.btn_spec_tag_select);
                    tvTag.setTextColor(getResources().getColor(R.color.common_confirm_text_color));
                });


                tagFlow.setAdapter(mRecordsAdapter);

                llspecshow.addView(viewAll);
            }






            //View parent = view.getParent();



            //mPic.setText(text);
            return this;
        }





        public Builder setList(int... ids) {
            List<String> data = new ArrayList<>(ids.length);
            for (int id : ids) {
                data.add(getString(id));
            }
            return setList(data);
        }

        public Builder setList(String... data) {
            return setList(Arrays.asList(data));
        }

        @SuppressWarnings("all")
        public Builder setList(List data) {
            mAdapter.setData(data);
            mRecyclerView.addOnLayoutChangeListener(this);
            return this;
        }

/*        public Builder setCancel(@StringRes int id) {
            return setCancel(getString(id));
        }

        public Builder setCancel(CharSequence text) {
            mCancelView.setText(text);
            return this;
        }*/

        public Builder setAutoDismiss(boolean dismiss) {
            mAutoDismiss = dismiss;
            return this;
        }

        @SuppressWarnings("rawtypes")
        public Builder setListener(OnListener listener) {
            mListener = listener;
            return this;
        }

        @SingleClick
        @Override
        public void onClick(View view) {
            if (mAutoDismiss) {
                dismiss();
            }

            if (view == mCancelView) {
                if (mListener != null) {
                    mListener.onCancel(getDialog());
                }
            }
        }

        /**
         * {@link BaseAdapter.OnItemClickListener}
         */
        @SuppressWarnings("all")
        @Override
        public void onItemClick(RecyclerView recyclerView, View itemView, int position) {
            if (mAutoDismiss) {
                dismiss();
            }

            if (mListener != null) {
                mListener.onSelected(getDialog(), position, mAdapter.getItem(position));
            }
        }

        /**
         * {@link View.OnLayoutChangeListener}
         */
        @Override
        public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            mRecyclerView.removeOnLayoutChangeListener(this);
            // 这里一定要加延迟，如果不加在 Android 9.0 上面会导致 setLayoutParams 无效
            post(this);
        }

        @Override
        public void run() {
            final ViewGroup.LayoutParams params = mRecyclerView.getLayoutParams();
            final int maxHeight = getScreenHeight() / 4 * 3;
            if (mRecyclerView.getHeight() > maxHeight) {
                if (params.height != maxHeight) {
                    params.height = maxHeight;
                    mRecyclerView.setLayoutParams(params);
                }
            } else {
                if (params.height != ViewGroup.LayoutParams.WRAP_CONTENT) {
                    params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                    mRecyclerView.setLayoutParams(params);
                }
            }
        }

        /**
         *  获取屏幕的高度
         */
        private int getScreenHeight() {
            Resources resources = getResources();
            DisplayMetrics outMetrics = resources.getDisplayMetrics();
            return outMetrics.heightPixels;
        }
    }

    private static final class MenuAdapter extends AppAdapter<Object> {

        private MenuAdapter(Context context) {
            super(context);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder();
        }

        private final class ViewHolder extends AppAdapter<?>.ViewHolder {

            private final TextView mTextView;
            private final View mLineView;

            ViewHolder() {
                super(R.layout.menu_item);
                mTextView = (TextView) findViewById(R.id.tv_menu_text);
                mLineView = findViewById(R.id.v_menu_line);
            }

            @Override
            public void onBindView(int position) {
                mTextView.setText(getItem(position).toString());

                if (position == 0) {
                    // 当前是否只有一个条目
                    if (getItemCount() == 1) {
                        mLineView.setVisibility(View.GONE);
                    } else {
                        mLineView.setVisibility(View.VISIBLE);
                    }
                } else if (position == getItemCount() - 1) {
                    mLineView.setVisibility(View.GONE);
                } else {
                    mLineView.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public interface OnListener<T> {

        /**
         * 选择条目时回调
         */
        void onSelected(BaseDialog dialog, int position, T t);

        /**
         * 点击取消时回调
         */
        default void onCancel(BaseDialog dialog) {}
    }
}