package com.elec.dto.valueObj;

import java.io.Serializable;

/**
 * do something
 *
 * @author wangjinglim
 * @create 2021年10月13日18:41:00
 **/
public final class Result<T> implements Serializable {

    private static final long serialVersionUID = 1888932078692392845L;
    /**
     * 标识接口调用是否成功
     */
    private boolean success;

    /**
     * 符合条件的记录
     */
    private T data;

    public Result() {
        success = false;
    }

    public Result(boolean success) {
        this.success = success;
    }

    public Result(T data) {
        success = true;
        this.data = data;
    }


    public Result(boolean success, T data) {
        this.success = success;
        this.data = data;
    }


    /**
     * get,set属性
     */
    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
