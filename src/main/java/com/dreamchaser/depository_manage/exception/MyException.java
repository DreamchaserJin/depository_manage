package com.dreamchaser.depository_manage.exception;


/**
 * 自定义异常类
 * @author 金昊霖
 */
public class MyException extends RuntimeException {
    /**
     * 异常码
     */
    private int code;
    /**
     * 异常信息
     */
    private String msg;

    public MyException(int code, String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public MyException(String msg){
        super(msg);
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
