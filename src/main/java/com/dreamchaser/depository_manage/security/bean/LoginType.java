package com.dreamchaser.depository_manage.security.bean;

/**
 * 登录方式枚举类
 * @author 金昊霖
 */

public enum LoginType {
    /**
     * 通用
     */
    COMMON("common_realm"),
    /**
     * 用户密码登录
     */
    EMAIl_PASSWORD("user_password_realm"),
    /**
     * 手机验证码登录
     */
    USER_PHONE("user_phone_realm"),
    /**
     * 第三方登录(微信登录)
     */
    WECHAT_LOGIN("wechat_login_realm"),
    /**
     * 第三方登录(qq登录)
     */
    QQ_LOGIN("qq_login_realm");


    private String type;

    LoginType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    /**
     * 根据简单的字符串返回对应的LoginType
     * @param s 简单的字符串
     * @return 对应的LoginType
     */
    public static LoginType getType(String s){
        switch (s) {
            case "email":
                return EMAIl_PASSWORD;
            case "qq":
                return QQ_LOGIN;
            case "wechat":
                return WECHAT_LOGIN;
            case "phone":
                return USER_PHONE;
            default:
                return null;
        }

    }

    @Override
    public String toString() {
        return this.type;
    }
}
