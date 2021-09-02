package com.hpkj.txsapp.http.model;

import com.hjq.http.config.IRequestServer;
import com.hjq.http.model.BodyType;
import com.hpkj.txsapp.app.AppConfig;

/**
 *    author : glq
 *    desc   : 服务器配置
 */
public class RequestServer implements IRequestServer {

    @Override
    public String getHost() {
        return AppConfig.getHostUrl();
    }

    @Override
    public String getPath() {
        return "";
    }

    @Override
    public BodyType getType() {
        // 以表单的形式提交参数
        return BodyType.FORM;
    }
}