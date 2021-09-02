package com.hpkj.txsapp.ui.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.hpkj.txsapp.R;
import com.hpkj.txsapp.app.AppActivity;
import com.hpkj.txsapp.app.TitleBarFragment;
import com.hpkj.txsapp.databinding.TestFragmentBinding;
import com.hpkj.txsapp.ui.adapter.DemoAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * desc：测试recyclerview
 * author：Glq
 * time：2021/07/27 11:17
 */
public class TestListFragment extends TitleBarFragment<AppActivity, TestFragmentBinding> {

    private List<String> mDatas;
    //private DemoAdapter adapter;

    public static TestListFragment newInstance() {
        return new TestListFragment();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.test_fragment;
    }

    @Override
    protected void initView() {

        mDatas = new ArrayList<>();
        for (int i = 'A'; i < 'Z'; i++) {
            mDatas.add("" + (char) i);
        }

        binding.rvTestList.setLayoutManager(new LinearLayoutManager(getContext()));
        DemoAdapter adapter = new DemoAdapter(R.layout.test_item,mDatas);
        binding.rvTestList.setAdapter(adapter);

    }

    @Override
    protected void initData() {

        // 设置新的数据方法
        //adapter.setNewInstance(analogData());


    }

}
