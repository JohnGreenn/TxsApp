package com.hpkj.txsapp.http.request;

import com.hjq.http.config.IRequestApi;

/**
 * desc：banner请求
 * author：Glq
 * time：2021/07/26 16:36
 */
public class BannerApi implements IRequestApi {

    @Override
    public String getApi() {
        return "v2/Jiekou/banner";
    }

    private String name;

    public BannerApi setBname(String name) {
        this.name = name;
        return this;
    }
}
