package com.hpkj.txsapp.http.response;

/**
 * desc：封装图片
 * author：Glq
 * time：2021/08/04 15:57
 */
public class ImgListBean {

    public String imgUrl;

    public ImgListBean(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
