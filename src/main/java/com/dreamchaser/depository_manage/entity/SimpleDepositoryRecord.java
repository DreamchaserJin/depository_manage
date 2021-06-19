package com.dreamchaser.depository_manage.entity;

import lombok.Data;

import java.util.Date;

/**
 * 简单仓库记录信息,为了前端展示需要，尽量减少字段的传输以提高效率
 * @author Dreamchaser
 */
@Data
public class SimpleDepositoryRecord {
    /** 记录id */
    private Integer id;

    /** 调度记录类型（购入/退料/转入,退还/领料/转出) */
    private Integer type;

    /** 申请人id */
    private Integer applicantId;

    /** 申请备注 */
    private String applyRemark;

    /** 申请时间 */
    private Date applyTime;
}
