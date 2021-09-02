package com.hpkj.txsapp.http.response;

/**
 * desc：
 * author：Glq
 * time：2021/08/19 11:17
 */
public class AddrDetailBean {
    /**
     * id : 107
     * uid : 5
     * name : 耶耶耶
     * mobile : 199999999
     * province : 安徽省
     * city : 合肥市
     * district : 庐阳区
     * addr : 更高的广泛的规划打发打发
     * tag_type : 9
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
    private int tag_type;
    private int is_default;
    private int update_time;

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

    public int getTag_type() {
        return tag_type;
    }

    public void setTag_type(int tag_type) {
        this.tag_type = tag_type;
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
