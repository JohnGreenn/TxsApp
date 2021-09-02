package com.hpkj.txsapp.base;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;

import com.hpkj.txsapp.action.ActivityAction;
import com.hpkj.txsapp.action.BundleAction;
import com.hpkj.txsapp.action.ClickAction;
import com.hpkj.txsapp.action.HandlerAction;
import com.hpkj.txsapp.action.KeyboardAction;

import java.util.List;
import java.util.Random;

/**
 * desc：Activity 基类
 * author：Christiano
 * time：2021/07/21 17:48
 */

public abstract class BaseActivity<T> extends AppCompatActivity implements ActivityAction, ClickAction,
        HandlerAction, BundleAction, KeyboardAction {

    protected T binding;
    //protected Context mContext;
    /** Activity 回调集合 */
    private SparseArray<OnActivityCallback> mActivityCallbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //mContext = this;
        initActivity();
    }

    /**
     * 获取显示view的xml文件ID
     */
    protected abstract int getLayoutId();

    /**
     * 获取布局 ID
     */
    //protected abstract int getLayoutId();

    protected void initActivity() {
        initLayout();
        initBundleData();
        initView();
        initData();
    }


    /**
     * 从上一个界面拿到的数据
     */
    protected void initBundleData(){ };

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化布局
     */
    @SuppressWarnings("unchecked")
    protected void initLayout() {
        if (getLayoutId() > 0 ) {
            binding = (T) DataBindingUtil.setContentView(this,getLayoutId());
            //setContentView(getLayoutId());
            initSoftKeyboard();
        }
    }

    /**
     * 初始化软键盘
     */
    protected void initSoftKeyboard() {
        // 点击外部隐藏软键盘，提升用户体验
        getContentView().setOnClickListener(v -> {
            // 隐藏软键，避免内存泄漏
            hideKeyboard(getCurrentFocus());
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeCallbacks();
    }

    @Override
    public void finish() {
        // 隐藏软键，避免内存泄漏
        hideKeyboard(getCurrentFocus());
        super.finish();
    }

    /**
     * 如果当前的 Activity（singleTop 启动模式） 被复用时会回调
     */
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        // 设置为当前的 Intent，避免 Activity 被杀死后重启 Intent 还是最原先的那个
        setIntent(intent);
    }

    @Override
    public Bundle getBundle() {
        return getIntent().getExtras();
    }

    /**
     * 和 setContentView 对应的方法
     */
    public ViewGroup getContentView() {
        return findViewById(Window.ID_ANDROID_CONTENT);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        for (Fragment fragment : fragments) {
            // 这个 Fragment 必须是 BaseFragment 的子类，并且处于可见状态
            if (!(fragment instanceof BaseFragment) ||
                    fragment.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) {
                continue;
            }
            // 将按键事件派发给 Fragment 进行处理
            if (((BaseFragment<?,?>) fragment).dispatchKeyEvent(event)) {
                // 如果 Fragment 拦截了这个事件，那么就不交给 Activity 处理
                return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
        // 隐藏软键，避免内存泄漏
        hideKeyboard(getCurrentFocus());
        // 查看源码得知 startActivity 最终也会调用 startActivityForResult
        super.startActivityForResult(intent, requestCode, options);
    }

    /**
     * startActivityForResult 方法优化
     */

    public void startActivityForResult(Class<? extends Activity> clazz, OnActivityCallback callback) {
        startActivityForResult(new Intent(this, clazz), null, callback);
    }

    public void startActivityForResult(Intent intent, OnActivityCallback callback) {
        startActivityForResult(intent, null, callback);
    }

    public void startActivityForResult(Intent intent, @Nullable Bundle options, OnActivityCallback callback) {
        if (mActivityCallbacks == null) {
            mActivityCallbacks = new SparseArray<>(1);
        }
        // 请求码必须在 2 的 16 次方以内
        int requestCode = new Random().nextInt((int) Math.pow(2, 16));
        mActivityCallbacks.put(requestCode, callback);
        startActivityForResult(intent, requestCode, options);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        OnActivityCallback callback;
        if (mActivityCallbacks != null && (callback = mActivityCallbacks.get(requestCode)) != null) {
            callback.onActivityResult(resultCode, data);
            mActivityCallbacks.remove(requestCode);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public interface OnActivityCallback {

        /**
         * 结果回调
         *
         * @param resultCode        结果码
         * @param data              数据
         */
        void onActivityResult(int resultCode, @Nullable Intent data);
    }
}
