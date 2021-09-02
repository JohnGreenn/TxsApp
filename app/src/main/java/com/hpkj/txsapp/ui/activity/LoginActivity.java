package com.hpkj.txsapp.ui.activity;

import android.view.View;

import com.hjq.http.EasyConfig;
import com.hjq.http.EasyHttp;
import com.hjq.http.listener.HttpCallback;
import com.hjq.toast.ToastUtils;
import com.hpkj.txsapp.R;
import com.hpkj.txsapp.aop.SingleClick;
import com.hpkj.txsapp.app.AppActivity;
import com.hpkj.txsapp.base.BaseActivity;
import com.hpkj.txsapp.databinding.ActivityLoginBinding;
import com.hpkj.txsapp.http.model.HttpData;
import com.hpkj.txsapp.http.request.BannerApi;
import com.hpkj.txsapp.http.request.LoginApi;
import com.hpkj.txsapp.http.response.LoginBean;
import com.hpkj.txsapp.http.response.StartBean;
import com.hpkj.txsapp.other.IntentKey;
import com.hpkj.txsapp.ui.adapter.ImageAdapter;
import com.hpkj.txsapp.ui.fragment.HomeFragment;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.transformer.AlphaPageTransformer;

import java.util.ArrayList;

public class LoginActivity extends AppActivity<ActivityLoginBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

        binding.btnLogin.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @SingleClick
    @Override
    public void onClick(View view) {

        EasyHttp.post(this)
                .api(new LoginApi()
                        .setMobile("15555182321")
                        .setPassword("123456")
                )

                .request(new HttpCallback<HttpData<LoginBean>>(this) {

                    @Override
                    public void onSucceed(HttpData<LoginBean> result) {
                        if(result.getCode()==200){
                            toast("登录成功");
                            // 更新 Token
                            EasyConfig.getInstance()
                                    .addParam("token", result.getData().getToken());
                            //存token
                            //IntentKey.TOKEN = result.getData().getToken();

                            postDelayed(() -> {
                                // 跳转到首页
                                MainActivity.start(getContext(),HomeFragment.class);
                                finish();
                            }, 1000);

                        }
                    }
                });


    }
}