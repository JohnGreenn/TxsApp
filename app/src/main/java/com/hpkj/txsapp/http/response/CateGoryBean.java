package com.hpkj.txsapp.http.response;

import java.util.List;

/**
 * Desc：
 * author：Christiano
 * gitee:
 * time：2021/04/16 15:50
 */
public class CateGoryBean {

    /**
     * id : 25
     * typeName : 大类1
     * mallId : -1
     * enableSelect : true
     * childType : [{"id":1,"typeName":"推荐","mallId":25,"enableSelect":true,"childType":[]},{"id":2,"typeName":"面膜","mallId":25,"enableSelect":true,"childType":[]},{"id":3,"typeName":"护肤套装","mallId":25,"enableSelect":true,"childType":[]},{"id":4,"typeName":"洁面","mallId":25,"enableSelect":true,"childType":[]},{"id":5,"typeName":"乳液面霜","mallId":25,"enableSelect":true,"childType":[]},{"id":6,"typeName":"精华液","mallId":25,"enableSelect":true,"childType":[]},{"id":7,"typeName":"爽肤水","mallId":25,"enableSelect":true,"childType":[]},{"id":8,"typeName":"眼霜","mallId":25,"enableSelect":true,"childType":[]},{"id":9,"typeName":"粉底粉饼","mallId":25,"enableSelect":true,"childType":[]},{"id":10,"typeName":"隔离香水","mallId":25,"enableSelect":true,"childType":[]},{"id":11,"typeName":"口红唇膏","mallId":25,"enableSelect":true,"childType":[]}]
     */

    private int id;
    private String typeName;
    private int mallId;
    private boolean enableSelect;
    private List<ChildTypeBean> childType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getMallId() {
        return mallId;
    }

    public void setMallId(int mallId) {
        this.mallId = mallId;
    }

    public boolean isEnableSelect() {
        return enableSelect;
    }

    public void setEnableSelect(boolean enableSelect) {
        this.enableSelect = enableSelect;
    }

    public List<ChildTypeBean> getChildType() {
        return childType;
    }

    public void setChildType(List<ChildTypeBean> childType) {
        this.childType = childType;
    }

    public class ChildTypeBean {
        /**
         * id : 1
         * typeName : 推荐
         * mallId : 25
         * enableSelect : true
         * childType : []
         */

        private int id;
        private String typeName;
        private int mallId;
        private boolean enableSelect;

        private String typePic;

        //private List<?> childType;

        public String getTypePic() {
            return typePic;
        }

        public void setTypePic(String typePic) {
            this.typePic = typePic;
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public int getMallId() {
            return mallId;
        }

        public void setMallId(int mallId) {
            this.mallId = mallId;
        }

        public boolean isEnableSelect() {
            return enableSelect;
        }

        public void setEnableSelect(boolean enableSelect) {
            this.enableSelect = enableSelect;
        }

//    public List<?> getChildType() {
//        return childType;
//    }
//
//    public void setChildType(List<?> childType) {
//        this.childType = childType;
//    }
    }


}
