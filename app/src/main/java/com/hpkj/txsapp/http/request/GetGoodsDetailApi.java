package com.hpkj.txsapp.http.request;

import com.hjq.http.annotation.HttpHeader;
import com.hjq.http.config.IRequestApi;
import com.hpkj.txsapp.http.model.ScServer;

/**
 * desc：商品详情请求
 * author：Glq
 * time：2021/07/26 16:36
 */
public class GetGoodsDetailApi extends ScServer implements IRequestApi {

    @Override
    public String getApi() {
        return "api/SelfGoods/Goods";
    }

    private int gid;//

    @HttpHeader
    private String RequestId;// 加密头

    public GetGoodsDetailApi setHeaderPass(String RequestId) {
        this.RequestId = RequestId;
        return this;
    }

    public GetGoodsDetailApi setGid(int gid) {
        this.gid = gid;
        return this;
    }

}
