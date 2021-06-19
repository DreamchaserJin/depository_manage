package com.dreamchaser.depository_manage.security.bean;


import com.dreamchaser.depository_manage.entity.User;
import com.dreamchaser.depository_manage.pojo.UserP;
import lombok.Data;

import java.time.Instant;


/**
 * 登录令牌，默认有效期为7天
 * @author 金昊霖
 */
@Data
public class UserToken{

    final long DEFAULT_TERM=60*60*24*7;
    /**
     * 登录方式
     */
    private LoginType loginType;
    /**
     * 微信、qq的code，邮箱，或者用户名之类的
     */
    private String principal;

    /**
     * 相当于密码（一般是加密过的）
     */
    private String credentials;

    /**
     * 放入的时间
     */
    private Instant instant;

    /**
     * 有效期(单位：秒)
     */
    private long term;

    /**
     * 可以放一些不敏感的信息,以便下次访问时可以直接取出，如果user属性太多可以另外写个类，比如SimpleUser，
     * 存放一些经常需要用到的信息。
     */
    private UserP User;

    /**
     * 根据时间判断是否有效
     * @return 有效则返回true，否则返回false
     */
    public boolean isValid(){
        return Instant.now().getEpochSecond()-instant.getEpochSecond()<=term;
    }

    public UserToken(LoginType loginType, String principal, String credentials, Instant instant, long term, UserP user) {
        this.loginType = loginType;
        this.principal = principal;
        this.credentials = credentials;
        this.instant = instant;
        this.term = term;
        this.User = user;
    }

    public UserToken(LoginType loginType, String principal, String credentials, Instant instant, long term) {
        this.loginType = loginType;
        this.principal = principal;
        this.credentials = credentials;
        this.instant = instant;
        this.term = term;
    }

    public UserToken(LoginType loginType, String principal, String credentials) {
        this.loginType = loginType;
        this.principal = principal;
        this.credentials = credentials;
        this.instant = Instant.now();
        this.term=DEFAULT_TERM;
    }

    public UserToken(LoginType loginType, String principal) {
        this.loginType = loginType;
        this.principal = principal;
        this.instant=Instant.now();
        this.term=DEFAULT_TERM;
    }
}
