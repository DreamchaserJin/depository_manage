package com.dreamchaser.depository_manage.utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 * 用于处理时间类型的工具类
 * @author 金昊霖
 */
public class DateUtil {
    private static final SimpleDateFormat TIME_FORMAT =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat DATE_FORMAT =new SimpleDateFormat("yyyy-MM-dd");
    /**
     * 获取时间的字符串（精确到s）
     * @param date 时间
     * @return 转换格式的字符串
     */
    public static String getSimpleDate(Date date){
        return date==null?null:DATE_FORMAT.format(date);
    }

    /**
     * 获取时间的字符串（精确到s）
     * @param date Date对象
     * @return 转换格式的字符串
     */
    public static String getSimpleTime(Date date){
        return date==null?null:TIME_FORMAT.format(date);
    }

    /**
     * 将Object对象转化为Instant对象
     * @param o object对象（实际是long类型）
     * @return Instant对象
     */
    public static Instant getInstant(Object o){
        return  Instant.ofEpochSecond(ObjectFormatUtil.toLong(o));
    }
}
