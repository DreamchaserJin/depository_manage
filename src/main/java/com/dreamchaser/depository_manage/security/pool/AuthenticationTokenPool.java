package com.dreamchaser.depository_manage.security.pool;


import com.dreamchaser.depository_manage.security.bean.UserToken;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 认证后的令牌连接池（由于获取全局的session比较麻烦，所以自己维护一个类似session的令牌池）
 * @author 金昊霖
 */
public class AuthenticationTokenPool {
    /**
     * 认证后的令牌连接池
     */
    private static Map<String, UserToken> pool=new ConcurrentHashMap<>(10);

    public static void addToken(String token,UserToken userToken){
        pool.put(token, userToken);
    }

    /**
     * 根据token凭证获取未过期的令牌，如果没有未过期的令牌则返回null
     * @param token 凭证
     * @return userToken 未过期的令牌
     */
    public static UserToken getToken(String token){
        UserToken userToken=pool.get(token);

        //如果没有相应令牌则直接返回null
        if (userToken==null){
            return null;
        }

        //判断令牌是否过期
        if (userToken.isValid()){
            return userToken;
        }else{
            //清除过期令牌
            pool.remove(token);
            return null;
        }
    }

    /**
     * 根据凭证删除对应的令牌
     * @param token 凭证
     */
    public static void removeToken(String token){
        pool.remove(token);
    }

}
