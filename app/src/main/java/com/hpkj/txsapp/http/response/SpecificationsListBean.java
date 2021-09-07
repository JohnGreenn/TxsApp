package com.hpkj.txsapp.http.response;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import java.util.ArrayList;

/**
 * 描述：自营商城规格属性
 * 文件：SpecificationsListBean.java
 * 作者：Glq
 * 时间：2021/9/03 10:15
 */
public class SpecificationsListBean {
    /**
     * id : 1
     * name : 颜色
     * ownGoods : 1
     * values : [{"id":0,"ownSpecifications":1,"specificationsName":"红色"},{"id":0,"ownSpecifications":1,"specificationsName":"蓝色"},{"id":0,"ownSpecifications":1,"specificationsName":"绿色"},{"id":0,"ownSpecifications":1,"specificationsName":"黑色"},{"id":0,"ownSpecifications":2,"specificationsName":"正方形"},{"id":0,"ownSpecifications":2,"specificationsName":"三角形"},{"id":0,"ownSpecifications":2,"specificationsName":"圆形"}]
     */

    private int id;
    private String name;
    private int ownGoods;
    private ArrayList<ValuesBean> values;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOwnGoods() {
        return ownGoods;
    }

    public void setOwnGoods(int ownGoods) {
        this.ownGoods = ownGoods;
    }

    public ArrayList<ValuesBean> getValues() {
        return values;
    }

    public void setValues(ArrayList<ValuesBean> values) {
        this.values = values;
    }

    public static class ValuesBean extends BaseObservable {
        /**
         * id : 0
         * ownSpecifications : 1
         * specificationsName : 红色
         */


        private int id;
        private int ownSpecifications;
        private String specificationsName;
        private boolean ky;//是否可用
        private boolean xz;//是否选中


        @Bindable
        public boolean isKy() {
            return ky;
        }

        public void setKy(boolean ky) {
            this.ky = ky;
            notifyPropertyChanged(BR.ky);
        }

        @Bindable
        public boolean isXz() {
            return xz;
        }

        public void setXz(boolean xz) {
            this.xz = xz;
            notifyPropertyChanged(BR.xz);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getOwnSpecifications() {
            return ownSpecifications;
        }

        public void setOwnSpecifications(int ownSpecifications) {
            this.ownSpecifications = ownSpecifications;
        }

        public String getSpecificationsName() {
            return specificationsName;
        }

        public void setSpecificationsName(String specificationsName) {
            this.specificationsName = specificationsName;
        }


    }
}
