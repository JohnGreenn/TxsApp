package com.hpkj.txsapp.http.request;

import com.hjq.http.config.IRequestApi;

/**
 * desc：
 * author：Glq
 * time：2021/08/19 13:23
 */
public class AddrListApi implements IRequestApi {

    @Override
    public String getApi() {
        return "v2/Jiekou/memberAddrList";
    }

    private int page;
    private int pageSize;

    public AddrListApi setPage(int page) {
        this.page = page;
        return this;
    }

    public AddrListApi setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

}