package com.hpkj.txsapp.ui.activity;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.hpkj.txsapp.R;
import com.hpkj.txsapp.app.AppActivity;
import com.hpkj.txsapp.data.RecordsDao;
import com.hpkj.txsapp.databinding.ActivitySearchBinding;
import com.hpkj.txsapp.other.three.flowlayout.FlowLayout;
import com.hpkj.txsapp.other.three.flowlayout.TagAdapter;
import com.hpkj.txsapp.ui.utils.ClickUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * desc：搜索
 * author：Glq
 * edition：txs1.0
 * time：2021/8/25 13:38
 */
public class SearchActivity extends AppActivity<ActivitySearchBinding> {

    private RecordsDao mRecordsDao;
    //默然展示词条个数
    private final int DEFAULT_RECORD_NUMBER = 8;
    private List<String> recordList = new ArrayList<>();
    private List<String> mHotRecordList = new ArrayList<>();
    private TagAdapter mRecordsAdapter;
    private LinearLayout mHistoryContent;
    private TagAdapter mHotRecordsAdapter;
    private LinearLayout mHotContent;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {

        binding.setClick(this);

        String username = "007";
        //初始化数据库
        mRecordsDao = new RecordsDao(this,username);
        mHistoryContent = binding.getRoot().findViewById(R.id.ll_history_content);

        //-------------历史--------------
        //创建历史标签适配器
        //为标签设置对应的内容
        mRecordsAdapter = new TagAdapter<String>(recordList) {
            @Override
            public View getView(FlowLayout parent,int position,String s) {
                TextView tv = (TextView) LayoutInflater.from(SearchActivity.this).inflate(R.layout.tv_history,
                        binding.flSearchRecords,false);
                //为标签设置对应的内容
                tv.setText(s);
                return tv;
            }
        };
        binding.flSearchRecords.setAdapter(mRecordsAdapter);
        binding.flSearchRecords.setOnTagClickListener((view,position,parent) ->
        {
            //清空editText之前的数据
            binding.etSearch.setText("");
            //将获取到的字符串传到搜索结果界面,点击后搜索对应条目内容
            binding.etSearch.setText(recordList.get(position));
            binding.etSearch.setSelection(binding.etSearch.length());
            /*跳转界面*/
            //ClickUtil.toSearchResultsActivity(this,binding.sertchEdit.getText().toString(),flg);
        });
        //删除某个条目
        binding.flSearchRecords.setOnLongClickListener((view,position) -> showDialog("确定要删除该条历史记录？",(dialog,which) -> {
            //删除某一条记录
            mRecordsDao.deleteRecord(recordList.get(position));
        }));


        binding.tvSearch.setOnClickListener(v -> {

            String record = binding.etSearch.getText().toString().trim();
            if(!TextUtils.isEmpty(record)) {
                //添加数据
                mRecordsDao.addRecords(record);
            }
            if(binding.etSearch.getText().toString().trim().length() > 0) {
                /*跳转界面*/
                //ClickUtil.toSearchResultsActivity(this,binding.sertchEdit.getText().toString(),flg);
            } else {
                Toast.makeText(SearchActivity.this,"请输入关键字！",Toast.LENGTH_LONG).show();
            }
        });

    }

    private void showDialog(
            String dialogTitle,@NonNull DialogInterface.OnClickListener
            onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(SearchActivity.this);
        builder.setMessage(dialogTitle);
        builder.setPositiveButton("确定",onClickListener);
        builder.setNegativeButton("取消",null);
        builder.create().show();
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