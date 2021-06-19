package com.dreamchaser.depository_manage.intercepter;

import com.dreamchaser.depository_manage.exception.MyException;
import com.dreamchaser.depository_manage.security.pool.AuthenticationTokenPool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证拦截器，如果请求头中有相应凭证则放行，否则拦截返回认证失效错误
 * @author 金昊霖
 */
@Slf4j
@Component
public class UserInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws MyException {

        //拿到requset中的head
        String token =null;
        Cookie[] cookies=request.getCookies();
        if (cookies!=null){
            for (Cookie c:cookies){
                if (c.getName().equals("token")){
                    token=c.getValue();
                    break;
                }
            }
        }
        //如果是访问logout则删除对应的令牌
        if ("/logout".equals(request.getServletPath())){
            AuthenticationTokenPool.removeToken(token);
            return true;
        }
        if (token!=null&&AuthenticationTokenPool.getToken(token)!=null){
            request.setAttribute("userToken",AuthenticationTokenPool.getToken(token));
            return true;
        }else {
            try {
                response.sendRedirect("/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
    }
}
