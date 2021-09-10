package com.hpkj.txsapp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hpkj.txsapp.R;
import com.hpkj.txsapp.widget.view.ReturnGoodsView;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        addView();
    }
    private void addView() {
        ReturnGoodsView view = new ReturnGoodsView(this);
        view.setStatus();
    }
}