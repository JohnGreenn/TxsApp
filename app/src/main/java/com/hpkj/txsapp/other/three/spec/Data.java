package com.hpkj.txsapp.other.three.spec;


import java.util.List;

/**
 * Created by YangJane on 16/8/14.
 */

public class Data {

    /**
     * id : 1
     * price : 3400~3500
     * repertory : 22
     * img : http://www.ucicq.com/uploads/allimg/170304/03150NL5_0.jpeg
     * specKey : [{"id":"1","spec_name":"颜色","spec_key":["白色","红色","金色"]},{"id":"2","spec_name":"霸气","spec_key":["见闻色","武装色","霸王色"]},{"id":"3","spec_name":"尺寸","spec_key":["钻地","爬行","飞行"]}]
     * specsGroup : [{"id":"1","price":"3400.00","repertory":"22","goods_spec":["白色","见闻色","钻地"],"img":"http://img3.imgtn.bdimg.com/it/u=2247424153,1809959294&fm=11&gp=0.jpg"},{"id":"2","price":"3400.00","repertory":"22","goods_spec":["红色","见闻色","钻地"],"img":"http://www.005.tv/uploads/allimg/170208/1S92W191-19.jpg"},{"id":"3","price":"3400.00","repertory":"22","goods_spec":["红色","武装色","飞行"],"img":"http://imgsrc.baidu.com/forum/w=580/sign=92466e82763e6709be0045f70bc69fb8/71e24cd02f2eb938ae90e857dc628535e4dd6f98.jpg"},{"id":"4","price":"3400.00","repertory":"22","goods_spec":["红色","霸王色","飞行"],"img":"http://imgsrc.baidu.com/forum/w=580/sign=54bcb81c855494ee87220f111df4e0e1/768ca80f4bfbfbed0c060fdc71f0f736aec31fdc.jpg"},{"id":"5","price":"3400.00","repertory":"22","goods_spec":["金色","霸王色","爬行"],"img":"http://www.005.tv/uploads/allimg/170208/1S92S645-8.jpg"},{"id":"6","price":"3400.00","repertory":"22","goods_spec":["金色","霸王色","飞行"],"img":"http://zgsuixian.com/up/2017-2/201702051016251725888.jpg"}]
     */

    private String id;
    private String price;
    private String repertory;
    private String img;
    private List<SpecKeyBean> specKey;
    private List<SpecsGroupBean> specsGroup;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRepertory() {
        return repertory;
    }

    public void setRepertory(String repertory) {
        this.repertory = repertory;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<SpecKeyBean> getSpecKey() {
        return specKey;
    }

    public void setSpecKey(List<SpecKeyBean> specKey) {
        this.specKey = specKey;
    }

    public List<SpecsGroupBean> getSpecsGroup() {
        return specsGroup;
    }

    public void setSpecsGroup(List<SpecsGroupBean> specsGroup) {
        this.specsGroup = specsGroup;
    }

    public static class SpecKeyBean {
        /**
         * id : 1
         * spec_name : 颜色
         * spec_key : ["白色","红色","金色"]
         */

        private String id;
        private String spec_name;
        private List<String> spec_key;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSpec_name() {
            return spec_name;
        }

        public void setSpec_name(String spec_name) {
            this.spec_name = spec_name;
        }

        public List<String> getSpec_key() {
            return spec_key;
        }

        public void setSpec_key(List<String> spec_key) {
            this.spec_key = spec_key;
        }

        @Override
        public String toString() {
            return "SpecKeyBean{" +
                    "id='" + id + '\'' +
                    ", spec_name='" + spec_name + '\'' +
                    ", spec_key=" + spec_key +
                    '}';
        }
    }

    public static class SpecsGroupBean {
        /**
         * id : 1
         * price : 3400.00
         * repertory : 22
         * goods_spec : ["白色","见闻色","钻地"]
         * img : http://img3.imgtn.bdimg.com/it/u=2247424153,1809959294&fm=11&gp=0.jpg
         */

        private String id;
        private String price;
        private String repertory;
        private String img;
        private List<String> goods_spec;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getRepertory() {
            return repertory;
        }

        public void setRepertory(String repertory) {
            this.repertory = repertory;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public List<String> getGoods_spec() {
            return goods_spec;
        }

        public void setGoods_spec(List<String> goods_spec) {
            this.goods_spec = goods_spec;
        }

        @Override
        public String toString() {
            return "SpecsGroupBean{" +
                    "id='" + id + '\'' +
                    ", price='" + price + '\'' +
                    ", repertory='" + repertory + '\'' +
                    ", img='" + img + '\'' +
                    ", goods_spec=" + goods_spec +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Data{" +
                "id='" + id + '\'' +
                ", price='" + price + '\'' +
                ", repertory='" + repertory + '\'' +
                ", img='" + img + '\'' +
                ", specKey=" + specKey +
                ", specsGroup=" + specsGroup +
                '}';
    }
}

