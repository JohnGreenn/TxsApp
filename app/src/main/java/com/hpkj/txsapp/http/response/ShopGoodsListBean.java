package com.hpkj.txsapp.http.response;

import java.util.List;

/**
 * 描述：
 * fileName：com.hpkj.sheplive.entity
 * author：GLQ
 * time：2020/05/29 10:58
 */
public class ShopGoodsListBean {

    /**
     * id : 3
     * goodName : 测试商品3
     * resUrl : www.baidu.com3
     * price : 20
     * priceVip : 15
     * showSalesVolume : 100
     */

    private int id;//商品ID
    private String goodName;//商品名称
    private String resUrl;//
    private double price;//
    private double priceVip;//
    private int showSalesVolume;//
    private int credit;//
    private String creditPrice;//积分抵扣价格
    private double sharePrice;//
    private String goodsType;
    private boolean showShareAndCredit; //是否显示分享赚和积分抵扣
    private List<PriceListBean> priceList;

    public boolean isShowShareAndCredit() {
        return showShareAndCredit;
    }

    public void setShowShareAndCredit(boolean showShareAndCredit) {
        this.showShareAndCredit = showShareAndCredit;
    }
    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public double getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(double sharePrice) {
        this.sharePrice = sharePrice;
    }

    public String getCreditPrice() {
        return creditPrice == null ? "0.00" : creditPrice;
    }

    public void setCreditPrice(String creditPrice) {
        this.creditPrice = creditPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPriceVip() {
        return priceVip;
    }

    public void setPriceVip(double priceVip) {
        this.priceVip = priceVip;
    }

    public int getShowSalesVolume() {
        return showSalesVolume;
    }

    public void setShowSalesVolume(int showSalesVolume) {
        this.showSalesVolume = showSalesVolume;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public List<PriceListBean> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<PriceListBean> priceList) {
        this.priceList = priceList;
    }

    public static class PriceListBean {
        /**
         * levelName : 普通会员
         * levelId : 1
         * price : 680
         * showPrice : 680.00
         */

        private String levelName;
        private int levelId;
        private double price;
        private String showPrice;

        public String getLevelName() {
            return levelName;
        }

        public void setLevelName(String levelName) {
            this.levelName = levelName;
        }

        public int getLevelId() {
            return levelId;
        }

        public void setLevelId(int levelId) {
            this.levelId = levelId;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getShowPrice() {
            return showPrice;
        }

        public void setShowPrice(String showPrice) {
            this.showPrice = showPrice;
        }
    }
}
