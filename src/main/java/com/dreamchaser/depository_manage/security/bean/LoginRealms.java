package com.dreamchaser.depository_manage.security.bean;

import com.dreamchaser.depository_manage.entity.User;
import com.dreamchaser.depository_manage.exception.MyException;
import com.dreamchaser.depository_manage.security.pool.AuthenticationTokenPool;
import com.dreamchaser.depository_manage.service.UserService;
import com.dreamchaser.depository_manage.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 内置多种登录方式，和shiro中的realm类似
 * @author 金昊霖
 */
@Component
public class LoginRealms {
    @Autowired
    private UserService userService;

    /**
     * 认证，如果认证成功则返回凭证，否则返回null
     * @param userToken 未认证的令牌
     * @return 如果认证成功则返回凭证，否则返回null
     */
    public String authenticate(UserToken userToken){
        if (userToken.getCredentials()!=null){
            //对密码加密
            userToken.setCredentials(Md5.crypt(userToken.getCredentials()));
        }
        if (userToken.getLoginType().equals(LoginType.EMAIl_PASSWORD)){
            return handle(userToken,emailLogin(userToken));
        }
        //else if (其他登录方式...)
        //如果无匹配的认证方式则视为验证失败
        return null;
    }

    /**
     * 邮箱登录方式
     * @param userToken 令牌
     * @return 认证成功返回SimpleUser
     */
    private User emailLogin(UserToken userToken){
        return userService.findUserByEmail(userToken.getPrincipal());
    }

    /**
     * 根据传入的user是否为null（是否认证通过）来对令牌做剩下的操作（将user刻入令牌，并将该令牌放入令牌池中）
     * @param userToken 经过验证后的令牌
     * @return token 根据令牌生成的凭证 ，如果认证未成功则返回null
     */
    private String handle(UserToken userToken,User user){
        if (user==null){
            //说明账户不存在
            throw new MyException(409,"该用户不存在，请注册后再登录！");
        }
        //判断密码是否正确
        if (user.getPwd().equals(userToken.getCredentials())){
            //将UserP信息刻入令牌
            userToken.setUser(userService.singlePack(user));
            //获取token凭证
            String token=Md5.crypt(userToken.getPrincipal()+userToken.getInstant());
            //将令牌放入认证令牌池
            AuthenticationTokenPool.addToken(token,userToken);
            return token;
        }
        return null;
    }
}
