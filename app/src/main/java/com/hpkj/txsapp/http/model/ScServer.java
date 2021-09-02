package com.hpkj.txsapp.http.model;

import com.hjq.http.EasyConfig;
import com.hjq.http.config.IRequestServer;

/**
 * desc：商城服务器配置
 * author：Glq
 * time：2021/07/28 16:31
 */
public class ScServer implements IRequestServer {
    @Override
    public String getHost() {
        IRequestServer server = EasyConfig.getInstance().getServer();
/*        if (server instanceof RequestServer) {
            return "http://testlm.spshop.cn:50000/";
        }*/
        return "http://tksc.spshop.cn:9000/";
    }
}
