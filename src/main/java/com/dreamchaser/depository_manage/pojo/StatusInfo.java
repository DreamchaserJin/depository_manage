package com.dreamchaser.depository_manage.pojo;

import lombok.Data;

/**
 * 状态详细信息
 * @author 金昊霖
 */
@Data
public class StatusInfo {
    /**
     * 字段作为接口处理失败时, 给予用户的友好的提示信息, 即所有给用户的提示信息都统一由后端来处理
     */
    private String message="";
    /**
     * 字段用来放置接口处理失败时的详细错误信息. 只是为了方便排查错误, 前端无需使用.
     */
    private String detail="";

    public StatusInfo() {
    }

    public StatusInfo(String message, String detail) {
        this.message = message;
        this.detail = detail;
    }
}