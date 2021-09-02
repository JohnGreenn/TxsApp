package com.hpkj.txsapp.http.model;

/**
 *    author : glq
 *    desc   : 统一接口数据结构
 */
public class HttpData<T> {

    /** 返回码 */
    private int code;
    /** 提示语 */
    private String info;
    /** 数据 */
    private T data;

    public int getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }

    public T getData() {
        return data;
    }
}