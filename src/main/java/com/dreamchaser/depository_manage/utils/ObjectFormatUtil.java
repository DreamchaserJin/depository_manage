package com.dreamchaser.depository_manage.utils;

/**
 * 此工具类封装一些常用类型转换操作
 * @author 金昊霖
 */
public class ObjectFormatUtil {
    /**
     * 一种较为安全的Object转换Integer方式
     * @param o 要转化的对象
     * @return 转化的Integer类型结果
     */
    public static Integer toInteger(Object o){
        return o==null?null:Integer.parseInt(o.toString());
    }
    /**
     * 一种较为安全的Object转换Long方式
     * @param o 要转化的对象
     * @return 转化的Long类型结果
     */
    public static Long toLong(Object o){
        return o==null?null:Long.parseLong(o.toString());
    }

    public static Boolean toBoolean(Object o){
        return  (o==null)?null:Boolean.getBoolean(o.toString());
    }

}
