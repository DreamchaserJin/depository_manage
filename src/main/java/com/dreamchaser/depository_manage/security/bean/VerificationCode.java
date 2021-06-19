package com.dreamchaser.depository_manage.security.bean;

import lombok.Data;

import java.time.Instant;
import java.util.Random;

/**
 * 验证码，默认有效期为五分钟
 * @author 金昊霖
 */
@Data
public class VerificationCode {
    /**
     * 默认持续时间
     */
    private final long DEFAULT_TERM=60*5;
    /**
     * 验证码
     */
    private String code;
    /**
     * 创建时刻
     */
    private Instant instant;
    /**
     * 有效期
     */
    private long term;

    /**
     * 根据时间判断是否有效
     * @return boolean值
     */
    public boolean isValid(){
        return Instant.now().getEpochSecond()-instant.getEpochSecond()<=term;
    }

    public VerificationCode(Instant instant, long term) {
        //生成随机验证码code
        generateCode();
        this.instant = instant;
        this.term = term;
    }


    public VerificationCode(Instant instant) {
        //生成随机验证码code
        generateCode();
        this.instant = instant;
        this.term=DEFAULT_TERM;
    }

    public VerificationCode() {
        //生成随机验证码code
        generateCode();
        this.instant=Instant.now();
        this.term=DEFAULT_TERM;
    }

    private void generateCode(){
        StringBuilder codeNum = new StringBuilder();
        int [] numbers = {0,1,2,3,4,5,6,7,8,9};
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            //目的是产生足够随机的数，避免产生的数字重复率高的问题
            int next = random.nextInt(10000);
            codeNum.append(numbers[next % 10]);
        }
        this.code= codeNum.toString();
    }


}
