package com.hpkj.txsapp.app;


import com.gyf.immersionbar.ImmersionBar;
import com.hjq.http.listener.OnHttpListener;
import com.hpkj.txsapp.action.ToastAction;
import com.hpkj.txsapp.base.BaseFragment;
import com.hpkj.txsapp.http.model.HttpData;

import okhttp3.Call;

/**
 *    author : glq
 *    desc   : 业务 Fragment 基类
 */
public abstract class AppFragment<A extends AppActivity,T> extends BaseFragment<A,T>
        implements ToastAction, OnHttpListener<Object> {

    /** 状态栏沉浸 */
    private ImmersionBar mImmersionBar;



    /**
     * 当前加载对话框是否在显示中
     */
    public boolean isShowDialog() {
        A activity = getAttachActivity();
        if (activity != null) {
            return activity.isShowDialog();
        }

        return false;
    }

    /**
     * 显示加载对话框
     */
    public void showDialog() {
        A activity = getAttachActivity();
        if (activity != null) {
            activity.showDialog();
        }
    }

    /**
     * 隐藏加载对话框
     */
    public void hideDialog() {
        A activity = getAttachActivity();
        if (activity != null) {
            activity.hideDialog();
        }
    }

    /**
     * {@link OnHttpListener}
     */

    @Override
    public void onStart(Call call) {
        showDialog();
    }

    @Override
    public void onSucceed(Object result) {
        if (result instanceof HttpData) {
            toast(((HttpData<?>) result).getInfo());
        }
    }

    @Override
    public void onFail(Exception e) {
        toast(e.getMessage());
    }

    @Override
    public void onEnd(Call call) {
        hideDialog();
    }
}