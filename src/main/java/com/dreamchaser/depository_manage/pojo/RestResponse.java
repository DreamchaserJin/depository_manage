package com.dreamchaser.depository_manage.pojo;


import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 所有服务统一响应数据格式
 * @author 金昊霖
 */
@Accessors(chain = true)
@Data
public class RestResponse implements Serializable {
    /**
     * 业务数据
     */
    private Object data;
    /**
     * 数据条数
     */
    private int count;
    /**
     * 状态码
     */
    private int status=200;
    /**
     * 状态信息
     */
    private StatusInfo statusInfo=new StatusInfo();

    public RestResponse() {
    }

    public RestResponse(Object data) {
        this.data = data;
    }

    public RestResponse(Object data, int count, int status) {
        this.data = data;
        this.count = count;
        this.status = status;
    }

    public RestResponse(Object data, int status, StatusInfo statusInfo) {
        this.data = data;
        this.status = status;
        this.statusInfo = statusInfo;
    }
}

