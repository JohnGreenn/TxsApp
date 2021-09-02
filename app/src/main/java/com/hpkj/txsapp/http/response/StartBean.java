package com.hpkj.txsapp.http.response;

import com.google.gson.annotations.SerializedName;

/**
 * desc：
 * author：Glq
 * time：2021/07/26 16:50
 */
public class StartBean {
    private String title;//广告标题
    //    @SerializedName(value = "image", alternate = {"imglist"})
    //private String image;//广告图片
    private int jump_type;//跳转类型   1:APP内部页面  2:外部链接  3:淘宝客活动推广  4:具体商品  5:Schema
    private int app_screen_ads_play_second;//APP开屏广告播放时间（持续时间）
    private int app_screen_ads_close_second;//APP开屏广告可关闭时间
    private String start;//开始时间
    private String end;//结束时间
    private String schema;//jump_type为5时的Schema
    //        private String schema_link;//jump_type为5时的跳转Link  Banner和Schema 统一
    @SerializedName(value = "url", alternate = {"urllist"})
    private String url;//jump_type为2时的广告跳转链接
    private String description;//jump_type为2时的广告描述
    private int app_page_type;//jump_type为1时的跳转地址   1:会员商品主页  2:商学院
    //@SerializedName(value = "promotion_scene_id", alternate = {"schema_link"})
    private String promotion_scene_id;//jump_type为3和5时的淘宝活动ID
    private String schema_link;

    //@SerializedName(value = "activity_img_url", alternate = {"imglist"})
    private String activity_img_url;//jump_type为3和5时的淘宝活动图片URL
    private String app_mail_msg;//首页站内信广告
    private String image;//banner图片
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /*Banner 使用*/
    private int id;
    private int slide_id;
    private int status;
    private int list_order;
    private String target;
    private String content;
    private Object more;
    private String sid;

    /*弹窗*/
//    private String image;
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }

    public String getSchema_link() {
        return schema_link;
    }

    public void setSchema_link(String schema_link) {
        this.schema_link = schema_link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getJump_type() {
        return jump_type;
    }


    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public int getApp_page_type() {
        return app_page_type;
    }

    public void setApp_page_type(int app_page_type) {
        this.app_page_type = app_page_type;
    }

    public String getPromotion_scene_id() {
        return promotion_scene_id;
    }

    public void setPromotion_scene_id(String promotion_scene_id) {
        this.promotion_scene_id = promotion_scene_id;
    }

    public String getActivity_img_url() {
        return activity_img_url;
    }

    public void setJump_type(int jump_type) {
        this.jump_type = jump_type;
    }

    public int getApp_screen_ads_play_second() {
        return app_screen_ads_play_second;
    }

    public void setApp_screen_ads_play_second(int app_screen_ads_play_second) {
        this.app_screen_ads_play_second = app_screen_ads_play_second;
    }

    public int getApp_screen_ads_close_second() {
        return app_screen_ads_close_second;
    }

    public void setApp_screen_ads_close_second(int app_screen_ads_close_second) {
        this.app_screen_ads_close_second = app_screen_ads_close_second;
    }

    public void setActivity_img_url(String activity_img_url) {
        this.activity_img_url = activity_img_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "StartBean{" +
                "title='" + title + '\'' +
                ", jump_type=" + jump_type +
                ", app_screen_ads_play_second=" + app_screen_ads_play_second +
                ", app_screen_ads_close_second=" + app_screen_ads_close_second +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", schema='" + schema + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", app_page_type=" + app_page_type +
                ", promotion_scene_id='" + promotion_scene_id + '\'' +
                ", activity_img_url='" + activity_img_url + '\'' +
                ", app_mail_msg='" + app_mail_msg + '\'' +
                ", id=" + id +
                ", slide_id=" + slide_id +
                ", status=" + status +
                ", list_order=" + list_order +
                ", target='" + target + '\'' +
                ", content='" + content + '\'' +
                ", more=" + more +
                ", sid='" + sid + '\'' +
                '}';
    }

    public String getApp_mail_msg() {
        return app_mail_msg;
    }

    public void setApp_mail_msg(String app_mail_msg) {
        this.app_mail_msg = app_mail_msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSlide_id() {
        return slide_id;
    }

    public void setSlide_id(int slide_id) {
        this.slide_id = slide_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getList_order() {
        return list_order;
    }

    public void setList_order(int list_order) {
        this.list_order = list_order;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Object getMore() {
        return more;
    }

    public void setMore(Object more) {
        this.more = more;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

}
