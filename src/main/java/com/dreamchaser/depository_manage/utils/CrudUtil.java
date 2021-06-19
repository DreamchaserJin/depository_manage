package com.dreamchaser.depository_manage.utils;

import com.dreamchaser.depository_manage.pojo.RestResponse;
import com.dreamchaser.depository_manage.pojo.StatusInfo;


/**
 * 因为在控制层有很多重复可抽象出来的操作，所以写一个工具类
 * @author 金昊霖
 */
public class CrudUtil {
    public static final RestResponse RESPONSE200=new RestResponse();
    public static final RestResponse RESPONSE201=new RestResponse().setStatus(201);
    public static final RestResponse RESPONSE204=new RestResponse().setStatus(204);
    public static final RestResponse RESPONSE205=new RestResponse().setStatus(205);
    public static final RestResponse ID_MISS_RESPONSE =new RestResponse(0,400,new StatusInfo("请求错误，错误码400","请求中必要参数(如id)丢失！"));
    public static final RestResponse RESPONSE304=new RestResponse().setStatus(304)
            .setStatusInfo(new StatusInfo("资源未改变或者未达到预期改变，错误码304。bug常有，请多多包含，请及时联系相关管理员，我们会尽快修复","资源未变化"));
    public static final RestResponse NOT_EXIST_USER_OR_ERROR_PWD_RESPONSE =new RestResponse("",402,new StatusInfo("登录失败，账号或者密码错误！","错误码402，账号或者密码错误"));
    public static final RestResponse USER_FROZEN_RESPONSE=new RestResponse("",406,new StatusInfo("账户已冻结，请稍后登录！","错误码406，账户已冻结，请稍后登录！"));
    public static final RestResponse CODE_ERROR=new RestResponse("",408,new StatusInfo("验证码错误！","错误码408，验证码错误请重新输入！"));

    public static final RestResponse SYSTEM_ERROR_RESPONSE =new RestResponse("",500,new StatusInfo("服务器系统错误！bug常有，请多多包含，请及时联系相关管理员，我们会尽快修复！","服务器错误！"));

    /**
     * 用于处理通常的post请求
     * @param result 执行service层insert方法的返回结果（即受影响数据的行数）
     * @param standard 正常执行所影响的数据行数
     * @return 处理后的RestResponse
     */
    public static RestResponse postHandle(Integer result,Integer standard){
        if (result.equals(standard)){
            return RESPONSE201;
        }else{
            return RESPONSE304;
        }
    }
    /**
     * 用来处理通常的delete请求
     * @param result 执行service层delete方法的返回结果（即受影响数据的行数）
     * @param standard 正常执行所影响的数据行数
     * @return 处理后的RestResponse
     */
    public static RestResponse deleteHandle( Integer result,Integer standard){
        if (result>=standard){
            return RESPONSE204;
        }else {
            return RESPONSE304;
        }
    }

    /**
     * 用来处理通常的put请求
     * @param result 执行service层update方法的返回结果（即受影响数据的行数）
     * @param standard 正常执行所影响的数据行数
     * @return 处理后的RestResponse
     */
    public static RestResponse putHandle( Integer result,Integer standard){
        if (result.equals(standard) ){
            return RESPONSE205;
        }else {
            return RESPONSE304;
        }
    }
}