package com.hpkj.txsapp.ui.fragment;

import android.view.View;

import com.hpkj.txsapp.R;
import com.hpkj.txsapp.app.TitleBarFragment;
import com.hpkj.txsapp.databinding.FragmentSearchBinding;
import com.hpkj.txsapp.ui.activity.MainActivity;

/**
 * desc：
 * author：Glq
 * time：2021/08/05 17:44
 */
public class SearchFragment extends TitleBarFragment<MainActivity, FragmentSearchBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_search;
    }

    @Override
    protected void initView() {
        binding.setClick(this);

    }

    @Override
    protected void initData() {

    }

    //取消点击事件
    public void clickExit(View view) {
        finish();
    }

    //点击搜搜
    public void clickSearch(View view,int flg) {

    }
}
