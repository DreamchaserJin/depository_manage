package com.dreamchaser.depository_manage.entity;

import lombok.Data;

import java.util.Date;

/**
 * 仓库调度记录(depository_record)
 * 
 * @author Dreamchaser
 * @version 1.0.0 2021-05-20
 */
@Data
public class DepositoryRecord {
    /** 版本号 */
    private static final long serialVersionUID = 8546566842955977610L;
    /** 记录id */
    private Integer id;

    /** 申请编号 */
    private Integer applicationId;

    /** 产品名称 */
    private String mname;

    /** 调度的仓库id */
    private Integer depositoryId;

    /** 调度记录类型（购入/退料/转入,退还/领料/转出) */
    private Integer type;

    /** 数量 */
    private Double quantity;

    /** 价格 */
    private Double price;

    /** 状态（未审核，未入库/出库，已入库） */
    private String state;

    /** 申请人id */
    private Integer applicantId;

    /** 申请备注 */
    private String applyRemark;

    /** 申请时间 */
    private Date applyTime;

    /** 审核人id */
    private Integer reviewerId;

    /** 审核结果备注 */
    private String reviewRemark;

    /** 审核时间 */
    private Date reviewTime;

    /**
     * 是否审核通过
     */
    private Integer reviewPass;

    /** 验货人id */
    private Integer checkerId;

    /** 验收备注 */
    private String checkRemark;

    /** 出入库时间（验货时间） */
    private Date checkTime;

    /**
     * 是否验收通过
     */
    private Integer checkPass;
}