package com.hpkj.txsapp.http.response;

/**
 * desc：
 * author：Glq
 * time：2021/08/19 15:50
 */
public class LoginBean {
    /**
     * id : 5
     * mobile : 15555182321
     * pass : e10adc3949ba59abbe56e057f20f883e
     * nickname : null
     * mem_status : null
     * status : null
     * vip_qudao : null
     * yaoqingma : null
     * create_time : null
     * pid : null
     * tb_status : -1
     * mycode : 51518
     * pcode : null
     * tcode : null
     * tm_id : null
     */
    private int id;
    private String mobile;
    private String pass;
    private String nickname;
    private int mem_status;
    private int status;
    private int vip_qudao;
    private String yaoqingma;
    private int create_time;
    private int pid;
    private int ppid;
    private int tb_status;//淘宝是否授权
    private String mycode;
    private String pcode;
    private String tcode;
    private int is_vip;//是否是黑卡会员
    private float total_income;
    /*渠道ID*/
    private String tm_id;
    /*会员ID*/
    private String tb_special_id;
    private String userid;
    private String token;

    private double vit_val;
    private int act_val;
    private int pre_val;

    private String usesig;
    private String avatar;
    private int upgProgress;
    private double amount;
    private double amountTbk;
    private int sex;
    private int uptime;
    private int taobao_user_id;
    private String alipay_account;
    private String alipay_realname;
    private String wxUnionId;
    private String sub_code;
    private String unionid;
    private String referer_token;

    private String vip_time;//会员时间
    private String vip_pay_time;//会员支付时间
    private int is_zxvip;//是否是尊享会员

    public int getIs_zxvip() {
        return is_zxvip;
    }

    public void setIs_zxvip(int is_zxvip) {
        this.is_zxvip = is_zxvip;
    }

    public String getVip_pay_time() {
        return vip_pay_time == null||vip_pay_time.equalsIgnoreCase("") ?"~~" : vip_pay_time;
    }

    public void setVip_pay_time(String vip_pay_time) {
        this.vip_pay_time = vip_pay_time;
    }


    public String getVip_time() {
        return vip_time == null ||vip_time.equalsIgnoreCase("")? "~~" : vip_time;
    }

    public void setVip_time(String vip_time) {
        this.vip_time = vip_time;
    }

    public String getReferer_token() {
        return referer_token;
    }

    public void setReferer_token(String referer_token) {
        this.referer_token = referer_token;
    }

    public String getTb_special_id() {
        return tb_special_id;
    }

    public void setTb_special_id(String tb_special_id) {
        this.tb_special_id = tb_special_id;
    }

    public int getId() {
        return id;
    }

    public int getIs_vip() {
        return is_vip;
    }

    public void setIs_vip(int is_vip) {
        this.is_vip = is_vip;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getMem_status() {
        return mem_status;
    }

    public void setMem_status(int mem_status) {
        this.mem_status = mem_status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getVip_qudao() {
        return vip_qudao;
    }

    public void setVip_qudao(int vip_qudao) {
        this.vip_qudao = vip_qudao;
    }

    public String getYaoqingma() {
        return yaoqingma;
    }

    public void setYaoqingma(String yaoqingma) {
        this.yaoqingma = yaoqingma;
    }

    public int getCreate_time() {
        return create_time;
    }

    public void setCreate_time(int create_time) {
        this.create_time = create_time;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getTb_status() {
        return tb_status;
    }

    public void setTb_status(int tb_status) {
        this.tb_status = tb_status;
    }

    public String getMycode() {
        return mycode;
    }

    public void setMycode(String mycode) {
        this.mycode = mycode;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getTcode() {
        return tcode;
    }

    public void setTcode(String tcode) {
        this.tcode = tcode;
    }

    public String getTm_id() {
        return tm_id;
    }

    public void setTm_id(String tm_id) {
        this.tm_id = tm_id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public double getVit_val() {
        return vit_val;
    }

    public void setVit_val(double vit_val) {
        this.vit_val = vit_val;
    }

    public int getAct_val() {
        return act_val;
    }

    public void setAct_val(int act_val) {
        this.act_val = act_val;
    }

    public int getPre_val() {
        return pre_val;
    }

    public void setPre_val(int pre_val) {
        this.pre_val = pre_val;
    }

    public String getUsesig() {
        return usesig;
    }

    public void setUsesig(String usesig) {
        this.usesig = usesig;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getUpgProgress() {
        return upgProgress;
    }

    public void setUpgProgress(int upgProgress) {
        this.upgProgress = upgProgress;
    }

    public int getPpid() {
        return ppid;
    }

    public void setPpid(int ppid) {
        this.ppid = ppid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmountTbk() {
        return amountTbk;
    }

    public void setAmountTbk(double amountTbk) {
        this.amountTbk = amountTbk;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getUptime() {
        return uptime;
    }

    public void setUptime(int uptime) {
        this.uptime = uptime;
    }

    public int getTaobao_user_id() {
        return taobao_user_id;
    }

    public void setTaobao_user_id(int taobao_user_id) {
        this.taobao_user_id = taobao_user_id;
    }

    public String getAlipay_account() {
        return alipay_account;
    }

    public void setAlipay_account(String alipay_account) {
        this.alipay_account = alipay_account;
    }

    public String getAlipay_realname() {
        return alipay_realname;
    }

    public void setAlipay_realname(String alipay_realname) {
        this.alipay_realname = alipay_realname;
    }

    public String getWxUnionId() {
        return wxUnionId;
    }

    public void setWxUnionId(String wxUnionId) {
        this.wxUnionId = wxUnionId;
    }

    public String getSub_code() {
        return sub_code;
    }

    public void setSub_code(String sub_code) {
        this.sub_code = sub_code;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public float getTotal_income() {
        return total_income;
    }

    public void setTotal_income(float total_income) {
        this.total_income = total_income;
    }
}
