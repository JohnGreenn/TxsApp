package com.hpkj.txsapp.http.request;

import com.hjq.http.config.IRequestApi;

/**
 *    author : glq
 *    time   : 2021/08/19
 *    desc   : 用户登录
 */
public final class LoginApi implements IRequestApi {

    @Override
    public String getApi() {
        return "user/login/index.html";
    }

    /** 手机号 */
    private String mobile;
    /** 登录密码 */
    private String password;

    public LoginApi setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public LoginApi setPassword(String password) {
        this.password = password;
        return this;
    }
}