package com.dreamchaser.depository_manage.security.pool;

import com.dreamchaser.depository_manage.security.bean.VerificationCode;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 验证码等待池
 * @author 金昊霖
 */
public class VerificationCodePool {
    private static Map<String, VerificationCode> pool=new ConcurrentHashMap<>(10);

    /**
     * 增加一条验证码
     * @param principal 主要内容，如邮箱，电话号码等
     * @param verificationCode 验证码
     */
    public static void addCode(String principal,VerificationCode verificationCode){
        pool.put(principal, verificationCode);
    }

    /**
     * 根据principal主要信息获取未过期的验证码，如果没有未过期的令牌则返回null
     * @param principal 主要内容，如邮箱，电话号码等
     * @return verificationCode 未过期的验证码或者null
     */
    public static VerificationCode getCode(String principal){
        VerificationCode verificationCode=pool.get(principal);

        //如果没有相应验证码则直接返回null
        if (verificationCode==null){
            return null;
        }

        //判断令牌是否过期
        if (verificationCode.isValid()){
            return verificationCode;
        }else{
            //清除过期验证码
            pool.remove(principal);
            return null;
        }
    }

    /**
     * 根据主要信息principal删除对应的验证码
     * @param principal 主要信息
     */
    public static void removeCode(String principal){
        pool.remove(principal);
    }
}
