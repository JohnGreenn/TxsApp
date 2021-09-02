package com.hpkj.txsapp.http.response;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 * fileName：com.hpkj.sheplive.entity
 * author：GLQ
 * time：2020/05/29 16:24
 */
public class ShopGoodsDetailBean extends BaseObservable {

    /**
     * baseInfo : {"id":3,"goodName":"测试商品3","ownShop":0,"price":20,"priceVip":15,"goodDesc":"测试商品3","sortId":2,"showSalesVolume":100,"stock":900,"createTime":"2020-05-27T13:26:41","fullAmountFreeShipping":20,"fullPieceFreeShipping":2,"freight":22,"locationProvince":"江苏省","locationCity":"南京市"}
     * shopInfo : {"shopName":"自营商城","logo":null,"authFile":null}
     * imageList : ["www.baidu.com3"]
     * videoList : []
     * specificationsList : [{"id":1,"name":"颜色","ownGoods":1,"values":[{"id":0,"ownSpecifications":1,"specificationsName":"红色"},{"id":0,"ownSpecifications":1,"specificationsName":"蓝色"},{"id":0,"ownSpecifications":1,"specificationsName":"绿色"},{"id":0,"ownSpecifications":1,"specificationsName":"黑色"},{"id":0,"ownSpecifications":2,"specificationsName":"正方形"},{"id":0,"ownSpecifications":2,"specificationsName":"三角形"},{"id":0,"ownSpecifications":2,"specificationsName":"圆形"}]},{"id":2,"name":"形状","ownGoods":1,"values":[{"id":0,"ownSpecifications":1,"specificationsName":"红色"},{"id":0,"ownSpecifications":1,"specificationsName":"蓝色"},{"id":0,"ownSpecifications":1,"specificationsName":"绿色"},{"id":0,"ownSpecifications":1,"specificationsName":"黑色"},{"id":0,"ownSpecifications":2,"specificationsName":"正方形"},{"id":0,"ownSpecifications":2,"specificationsName":"三角形"},{"id":0,"ownSpecifications":2,"specificationsName":"圆形"}]}]
     * selfGoodsSpecificationsList : [{"id":4,"specificationsId":1,"specificationsValue":3,"price":20,"priceVip":10,"stock":1000,"goodId":3}]
     */

    private BaseInfoBean baseInfo;
    private ShopInfoBean shopInfo;
    private List<String> imageList;
    private List<String> videoList;
    private CommentBean comment;
    private List<SpecificationsListBean> specificationsList;
    private List<SelfGoodsSpecificationsListBean> selfGoodsSpecificationsList;
    private int commentTotal;
    private CreditDeductionInfoBean creditDeductionInfo;
    private List<PriceListBean> priceList;

    public List<PriceListBean> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<PriceListBean> priceList) {
        this.priceList = priceList;
    }

    //public static List

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

    public CommentBean getComment() {
        return comment;
    }

    public void setComment(CommentBean comment) {
        this.comment = comment;
    }

    public int getCommentTotal() {
        return commentTotal;
    }

    public void setCommentTotal(int commentTotal) {
        this.commentTotal = commentTotal;
    }

    public BaseInfoBean getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfoBean baseInfo) {
        this.baseInfo = baseInfo;
    }

    public ShopInfoBean getShopInfo() {
        return shopInfo;
    }

    public void setShopInfo(ShopInfoBean shopInfo) {
        this.shopInfo = shopInfo;
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

    public List<String> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<String> videoList) {
        this.videoList = videoList;
    }

    public List<SpecificationsListBean> getSpecificationsList() {
        return specificationsList;
    }

    public void setSpecificationsList(List<SpecificationsListBean> specificationsList) {
        this.specificationsList = specificationsList;
    }

    public List<SelfGoodsSpecificationsListBean> getSelfGoodsSpecificationsList() {
        return selfGoodsSpecificationsList;
    }

    public void setSelfGoodsSpecificationsList(List<SelfGoodsSpecificationsListBean> selfGoodsSpecificationsList) {
        this.selfGoodsSpecificationsList = selfGoodsSpecificationsList;
    }

    public CreditDeductionInfoBean getCreditDeductionInfo() {
        return creditDeductionInfo;
    }

    public void setCreditDeductionInfo(CreditDeductionInfoBean creditDeductionInfo) {
        this.creditDeductionInfo = creditDeductionInfo;
    }

    public static class CreditDeductionInfoBean implements Parcelable {
        /**
         * credit : 6004
         * availableCredit : 305
         * deductionAmount : 30.5
         */

        private int credit;
        private int availableCredit;
        private double deductionAmount;

        public int getCredit() {
            return credit;
        }

        public void setCredit(int credit) {
            this.credit = credit;
        }

        public int getAvailableCredit() {
            return availableCredit;
        }

        public void setAvailableCredit(int availableCredit) {
            this.availableCredit = availableCredit;
        }

        public double getDeductionAmount() {
            return deductionAmount;
        }

        public void setDeductionAmount(double deductionAmount) {
            this.deductionAmount = deductionAmount;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest,int flags) {
            dest.writeInt(this.credit);
            dest.writeInt(this.availableCredit);
            dest.writeDouble(this.deductionAmount);
        }

        public CreditDeductionInfoBean() {
        }

        protected CreditDeductionInfoBean(Parcel in) {
            this.credit = in.readInt();
            this.availableCredit = in.readInt();
            this.deductionAmount = in.readDouble();
        }

        public static final Creator<CreditDeductionInfoBean> CREATOR = new Creator<CreditDeductionInfoBean>() {
            @Override
            public CreditDeductionInfoBean createFromParcel(Parcel source) {
                return new CreditDeductionInfoBean(source);
            }

            @Override
            public CreditDeductionInfoBean[] newArray(int size) {
                return new CreditDeductionInfoBean[size];
            }
        };
    }

    public static class BaseInfoBean extends BaseObservable implements Parcelable {
        /**
         * id : 3
         * goodName : 测试商品3
         * ownShop : 0
         * price : 20
         * priceVip : 15
         * goodDesc : 测试商品3
         * sortId : 2
         * showSalesVolume : 100
         * stock : 900
         * createTime : 2020-05-27T13:26:41
         * fullAmountFreeShipping : 20
         * fullPieceFreeShipping : 2
         * freight : 22
         * locationProvince : 江苏省
         * locationCity : 南京市
         */

        private int credit;
        private String creditPrice;//积分抵扣价格
        private double sharePrice;
        private int id;
        private String goodName;
        private int ownShop;
        private double price;
        private double priceVip;
        private String goodDesc;
        private int sortId;
        private int showSalesVolume;
        private int stock;
        private String createTime;
        private int fullAmountFreeShipping;
        private int fullPieceFreeShipping;
        private int freight;
        private String locationProvince;
        private String locationCity;
        private String showPrice;
        private String shareUrl;
        private List<GoodsTagListBean> goodsTagList;

        private boolean showShareAndCredit; //是否显示分享赚和积分抵扣
        private boolean usePostConfig; //是否使用签约快递
        private boolean useAddress; //是否使用独立地址
        private boolean editAddress; //是否可以编辑地址
        //        private String staticProvince; //独立地址省份
//        private String staticCity; //独立地址城市
//        private String StaticAddress; //独立地址城市
        private int stepCount; //增加个数

        public int getStepCount() {
            return stepCount;
        }

        public void setStepCount(int stepCount) {
            this.stepCount = stepCount;
        }

        public boolean isEditAddress() {
            return editAddress;
        }

        public void setEditAddress(boolean editAddress) {
            this.editAddress = editAddress;
        }

        public boolean isUseAddress() {
            return useAddress;
        }

        public void setUseAddress(boolean useAddress) {
            useAddress = useAddress;
        }

//        public String getStaticProvince() {
//            return staticProvince;
//        }
//
//        public void setStaticProvince(String staticProvince) {
//            this.staticProvince = staticProvince;
//        }
//
//        public String getStaticCity() {
//            return staticCity;
//        }
//
//        public void setStaticCity(String staticCity) {
//            this.staticCity = staticCity;
//        }
//
//        public String getStaticAddress() {
//            return StaticAddress;
//        }
//
//        public void setStaticAddress(String staticAddress) {
//            StaticAddress = staticAddress;
//        }

        public boolean isUsePostConfig() {
            return usePostConfig;
        }

        public void setUsePostConfig(boolean usePostConfig) {
            this.usePostConfig = usePostConfig;
        }



        public boolean isShowShareAndCredit() {
            return showShareAndCredit;
        }

        public void setShowShareAndCredit(boolean showShareAndCredit) {
            showShareAndCredit = showShareAndCredit;
        }

        public List<GoodsTagListBean> getGoodsTagList() {
            return goodsTagList;
        }

        public void setGoodsTagList(List<GoodsTagListBean> goodsTagList) {
            this.goodsTagList = goodsTagList;
        }

        public static class GoodsTagListBean {
            /**
             * id : 1
             * tagName : 假一赔十
             * isCheck : true
             */

            private int id;
            private String tagName;
            private boolean isCheck;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTagName() {
                return tagName;
            }

            public void setTagName(String tagName) {
                this.tagName = tagName;
            }

            public boolean isIsCheck() {
                return isCheck;
            }

            public void setIsCheck(boolean isCheck) {
                this.isCheck = isCheck;
            }
        }

        public String getCreditPrice() {
            return creditPrice == null ? "0.00" : creditPrice;
        }

        public void setCreditPrice(String creditPrice) {
            this.creditPrice = creditPrice;
        }

        public String getShareUrl() {
            return shareUrl;
        }

        public void setShareUrl(String shareUrl) {
            this.shareUrl = shareUrl;
        }

        public String getShowPrice() {
            return showPrice;
        }

        public void setShowPrice(String showPrice) {
            this.showPrice = showPrice;
        }

        /*添加购物车时的购买数量*/
        private int priNum = 1;

        public int getCredit() {
            return credit;
        }

        public double getSharePrice() {
            return sharePrice;
        }

        public void setSharePrice(double sharePrice) {
            this.sharePrice = sharePrice;
        }

        public void setCredit(int credit) {
            this.credit = credit;
        }

        @Bindable
        public int getPriNum() {
            return priNum;
        }

        public void setPriNum(int priNum) {
            this.priNum = priNum;
            //notifyPropertyChanged(BR.priNum);
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

        public int getOwnShop() {
            return ownShop;
        }

        public void setOwnShop(int ownShop) {
            this.ownShop = ownShop;
        }

        @Bindable
        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
            //notifyPropertyChanged(BR.price);
        }

        public double getPriceVip() {
            return priceVip;
        }

        public void setPriceVip(double priceVip) {
            this.priceVip = priceVip;
        }

        public String getGoodDesc() {
            return goodDesc;
        }

        public void setGoodDesc(String goodDesc) {
            this.goodDesc = goodDesc;
        }

        public int getSortId() {
            return sortId;
        }

        public void setSortId(int sortId) {
            this.sortId = sortId;
        }

        public int getShowSalesVolume() {
            return showSalesVolume;
        }

        public long getShowSalesVolumeL() {
            return Long.valueOf(showSalesVolume);
        }

        public void setShowSalesVolume(int showSalesVolume) {
            this.showSalesVolume = showSalesVolume;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getFullAmountFreeShipping() {
            return fullAmountFreeShipping;
        }

        public void setFullAmountFreeShipping(int fullAmountFreeShipping) {
            this.fullAmountFreeShipping = fullAmountFreeShipping;
        }

        public int getFullPieceFreeShipping() {
            return fullPieceFreeShipping;
        }

        public void setFullPieceFreeShipping(int fullPieceFreeShipping) {
            this.fullPieceFreeShipping = fullPieceFreeShipping;
        }

        public int getFreight() {
            return freight;
        }

        public void setFreight(int freight) {
            this.freight = freight;
        }

        public String getLocationProvince() {
            return locationProvince;
        }

        public void setLocationProvince(String locationProvince) {
            this.locationProvince = locationProvince;
        }

        public String getLocationCity() {
            return locationCity;
        }

        public void setLocationCity(String locationCity) {
            this.locationCity = locationCity;
        }

        public BaseInfoBean() {
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest,int flags) {
            dest.writeInt(this.credit);
            dest.writeString(this.creditPrice);
            dest.writeDouble(this.sharePrice);
            dest.writeInt(this.id);
            dest.writeString(this.goodName);
            dest.writeInt(this.ownShop);
            dest.writeDouble(this.price);
            dest.writeDouble(this.priceVip);
            dest.writeString(this.goodDesc);
            dest.writeInt(this.sortId);
            dest.writeInt(this.showSalesVolume);
            dest.writeInt(this.stock);
            dest.writeString(this.createTime);
            dest.writeInt(this.fullAmountFreeShipping);
            dest.writeInt(this.fullPieceFreeShipping);
            dest.writeInt(this.freight);
            dest.writeString(this.locationProvince);
            dest.writeString(this.locationCity);
            dest.writeString(this.showPrice);
            dest.writeString(this.shareUrl);
            //dest.writeList(this.goodsTagList);
            dest.writeByte(this.showShareAndCredit ? (byte) 1 : (byte) 0);
            dest.writeByte(this.usePostConfig ? (byte) 1 : (byte) 0);
            dest.writeByte(this.useAddress ? (byte) 1 : (byte) 0);
            dest.writeByte(this.editAddress ? (byte) 1 : (byte) 0);
            dest.writeInt(this.priNum);
            dest.writeInt(this.stepCount);
        }

        protected BaseInfoBean(Parcel in) {
            this.credit = in.readInt();
            this.creditPrice = in.readString();
            this.sharePrice = in.readDouble();
            this.id = in.readInt();
            this.goodName = in.readString();
            this.ownShop = in.readInt();
            this.price = in.readDouble();
            this.priceVip = in.readDouble();
            this.goodDesc = in.readString();
            this.sortId = in.readInt();
            this.showSalesVolume = in.readInt();
            this.stock = in.readInt();
            this.createTime = in.readString();
            this.fullAmountFreeShipping = in.readInt();
            this.fullPieceFreeShipping = in.readInt();
            this.freight = in.readInt();
            this.locationProvince = in.readString();
            this.locationCity = in.readString();
            this.showPrice = in.readString();
            this.shareUrl = in.readString();
            //this.goodsTagList = new ArrayList<GoodsTagListBean>();
            //in.readList(this.goodsTagList,GoodsTagListBean.class.getClassLoader());
            this.showShareAndCredit = in.readByte() != 0;
            this.usePostConfig = in.readByte() != 0;
            this.useAddress = in.readByte() != 0;
            this.editAddress = in.readByte() != 0;
            this.priNum = in.readInt();
            this.stepCount = in.readInt();
        }

        public static final Creator<BaseInfoBean> CREATOR = new Creator<BaseInfoBean>() {
            @Override
            public BaseInfoBean createFromParcel(Parcel source) {
                return new BaseInfoBean(source);
            }

            @Override
            public BaseInfoBean[] newArray(int size) {
                return new BaseInfoBean[size];
            }
        };
    }

    public static class ShopInfoBean implements Parcelable {
        /**
         * shopName : 自营商城
         * logo : null
         * authFile : null
         */

        private String shopName;
        private String logo;
        //private String authFile;
        private int shopId;
        private ArrayList<String> authFile;
        private int mallId;

        public int getMallId() {
            return mallId;
        }

        public void setMallId(int mallId) {
            this.mallId = mallId;
        }

        public ArrayList<String> getAuthFile() {
            return authFile;
        }

        public void setAuthFile(ArrayList<String> authFile) {
            this.authFile = authFile;
        }

        public int getShopId() {
            return shopId;
        }

        public void setShopId(int shopId) {
            this.shopId = shopId;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

//        public String getAuthFile() {
//            return authFile;
//        }
//
//        public void setAuthFile(String authFile) {
//            this.authFile = authFile;
//        }

        public ShopInfoBean() {
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest,int flags) {
            dest.writeString(this.shopName);
            dest.writeString(this.logo);
            dest.writeInt(this.shopId);
            dest.writeStringList(this.authFile);
            dest.writeInt(this.mallId);
        }

        protected ShopInfoBean(Parcel in) {
            this.shopName = in.readString();
            this.logo = in.readString();
            this.shopId = in.readInt();
            this.authFile = in.createStringArrayList();
            this.mallId = in.readInt();
        }

        public static final Creator<ShopInfoBean> CREATOR = new Creator<ShopInfoBean>() {
            @Override
            public ShopInfoBean createFromParcel(Parcel source) {
                return new ShopInfoBean(source);
            }

            @Override
            public ShopInfoBean[] newArray(int size) {
                return new ShopInfoBean[size];
            }
        };
    }

    public static class CommentBean {
        /**
         * commentId : 6
         * evaluate : 1
         * descriptionMatch : 5
         * logisticsSpeed : 5
         * serviceAttitude : 5
         * commentText : 测试评论
         * createUser : 蜡笔-测试账号
         * commentTime : 06/18/2020 15:45:15
         * spDesc : 配触摸屏:五寸800*480 配套线:不配 内存存储:512M+4G
         * skuId : 21
         * topMust : 0
         * headImg : /upload/avatar/5.png
         */

        private int commentId;
        private int evaluate;
        private int descriptionMatch;
        private int logisticsSpeed;
        private int serviceAttitude;
        private String commentText;
        private String createUser;
        private String commentTime;
        private String spDesc;
        private int skuId;
        private int topMust;
        private String headImg;

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public int getEvaluate() {
            return evaluate;
        }

        public void setEvaluate(int evaluate) {
            this.evaluate = evaluate;
        }

        public int getDescriptionMatch() {
            return descriptionMatch;
        }

        public void setDescriptionMatch(int descriptionMatch) {
            this.descriptionMatch = descriptionMatch;
        }

        public int getLogisticsSpeed() {
            return logisticsSpeed;
        }

        public void setLogisticsSpeed(int logisticsSpeed) {
            this.logisticsSpeed = logisticsSpeed;
        }

        public int getServiceAttitude() {
            return serviceAttitude;
        }

        public void setServiceAttitude(int serviceAttitude) {
            this.serviceAttitude = serviceAttitude;
        }

        public String getCommentText() {
            return commentText;
        }

        public void setCommentText(String commentText) {
            this.commentText = commentText;
        }

        public String getCreateUser() {
            return createUser;
        }

        public void setCreateUser(String createUser) {
            this.createUser = createUser;
        }

        public String getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(String commentTime) {
            this.commentTime = commentTime;
        }

        public String getSpDesc() {
            return spDesc;
        }

        public void setSpDesc(String spDesc) {
            this.spDesc = spDesc;
        }

        public int getSkuId() {
            return skuId;
        }

        public void setSkuId(int skuId) {
            this.skuId = skuId;
        }

        public int getTopMust() {
            return topMust;
        }

        public void setTopMust(int topMust) {
            this.topMust = topMust;
        }

        public String getHeadImg() {
            return headImg;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }
    }


    public static class SelfGoodsSpecificationsListBean {
        /**
         * id : 4
         * specificationsId : 1
         * specificationsValue : 3
         * price : 20
         * priceVip : 10
         * stock : 1000
         * goodId : 3
         */

        private int id;
        private int specificationsId;
        private int specificationsValue;
        private int price;
        private int priceVip;
        private int stock;
        private int goodId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSpecificationsId() {
            return specificationsId;
        }

        public void setSpecificationsId(int specificationsId) {
            this.specificationsId = specificationsId;
        }

        public int getSpecificationsValue() {
            return specificationsValue;
        }

        public void setSpecificationsValue(int specificationsValue) {
            this.specificationsValue = specificationsValue;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getPriceVip() {
            return priceVip;
        }

        public void setPriceVip(int priceVip) {
            this.priceVip = priceVip;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public int getGoodId() {
            return goodId;
        }

        public void setGoodId(int goodId) {
            this.goodId = goodId;
        }
    }
}
