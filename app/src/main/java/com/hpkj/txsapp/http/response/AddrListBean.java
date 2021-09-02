package com.hpkj.txsapp.http.response;

import java.util.List;

/**
 * desc：地址列表数据
 * author：Glq
 * time：2021/08/19 11:16
 */
public class AddrListBean {
    /**
     * total : 3
     * per_page : 20
     * current_page : 1
     * last_page : 1
     * data : [{"id":5,"uid":5,"name":"房间","mobile":"1578584839393","province":"安徽省","city":"合肥市","district":"瑶海区","addr":"城东街道晋级赛开始上课","is_default":1,"update_time":0},{"id":4,"uid":5,"name":"复习","mobile":"168585849393","province":"安徽省","city":"合肥市","district":"肥东县","addr":"大酒店几点结束看看上课","is_default":1,"update_time":0},{"id":3,"uid":5,"name":"小强","mobile":"155858499339","province":"安徽省","city":"合肥市","district":"包河区","addr":"附近的计算机三级","is_default":1,"update_time":0}]
     */
    private int total;
    private String per_page;
    private int current_page;
    private int last_page;
    private List<AddrDetailBean> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getPer_page() {
        return per_page;
    }

    public void setPer_page(String per_page) {
        this.per_page = per_page;
    }

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public int getLast_page() {
        return last_page;
    }

    public void setLast_page(int last_page) {
        this.last_page = last_page;
    }

    public List<AddrDetailBean> getData() {
        return data;
    }

    public void setData(List<AddrDetailBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 5
         * uid : 5
         * name : 房间
         * mobile : 1578584839393
         * province : 安徽省
         * city : 合肥市
         * district : 瑶海区
         * addr : 城东街道晋级赛开始上课
         * is_default : 1
         * update_time : 0
         */
        private int id;
        private int uid;
        private String name;
        private String mobile;
        private String province;
        private String city;
        private String district;
        private String addr;
        private int is_default;
        private int update_time;
        private int tag_type;

        public int getTag_type() {
            return tag_type;
        }

        public void setTag_type(int tag_type) {
            this.tag_type = tag_type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public int getIs_default() {
            return is_default;
        }

        public void setIs_default(int is_default) {
            this.is_default = is_default;
        }

        public int getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(int update_time) {
            this.update_time = update_time;
        }
    }
}
