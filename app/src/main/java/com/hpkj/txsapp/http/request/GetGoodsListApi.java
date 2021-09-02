package com.hpkj.txsapp.http.request;

import com.hjq.http.annotation.HttpHeader;
import com.hjq.http.config.IRequestApi;
import com.hpkj.txsapp.http.model.ScServer;

/**
 * desc：商品列表
 * author：Glq
 * time：2021/07/26 16:36
 */
public class GetGoodsListApi extends ScServer implements IRequestApi {

    @Override
    public String getApi() {
        return "api/SelfGoods/SelfGoodsListByTag";
    }

    private String labelId;//标签
    private int sortType;//排序类型
    private int pageIndex;//页码
    private int pageSize;//分页大小

    @HttpHeader
    private String RequestId;// 加密头

    public  GetGoodsListApi setHeaderPass(String RequestId) {
        this.RequestId = RequestId;
        return this;
    }

    public GetGoodsListApi setLabel(String labelId) {
        this.labelId = labelId;
        return this;
    }

    public GetGoodsListApi setSortType(int sortType) {
        this.sortType = sortType;
        return this;
    }

    public GetGoodsListApi setIndex(int pageIndex) {
        this.pageIndex = pageIndex;
        return this;
    }

    public GetGoodsListApi setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

}
