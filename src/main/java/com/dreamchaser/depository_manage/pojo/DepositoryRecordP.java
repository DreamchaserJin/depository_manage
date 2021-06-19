package com.dreamchaser.depository_manage.pojo;


import com.dreamchaser.depository_manage.entity.DepositoryRecord;
import com.dreamchaser.depository_manage.utils.DateUtil;
import lombok.Data;

@Data
public class DepositoryRecordP {
    private static final long serialVersionUID = 8546566842955977610L;
    /**
     * 记录id
     */
    private Integer id;

    /**
     * 申请编号
     */
    private Integer applicationId;

    /**
     * 产品名称
     */
    private String mname;

    /**
     * 调度的仓库id
     */
    private Integer depositoryId;

    /**
     * 仓库名称
     */
    private String depositoryName;

    /**
     * 调度记录类型（购入/退料/转入,退还/领料/转出)
     */
    private Integer type;

    /**
     * 数量
     */
    private Double quantity;

    /**
     * 价格
     */
    private Double price;

    /**
     * 状态（未审核，未入库/出库，已入库）
     */
    private String state;

    /**
     * 申请人id
     */
    private Integer applicantId;

    /**
     * 申请人姓名
     */
    private String applicantName;

    /**
     * 申请备注
     */
    private String applyRemark;

    /**
     * 申请时间
     */
    private String applyTime;

    /**
     * 审核人id
     */
    private Integer reviewerId;

    /**
     * 审核人姓名
     */
    private String reviewerName;

    /**
     * 审核结果备注
     */
    private String reviewRemark;

    /**
     * 审核时间
     */
    private String reviewTime;

    /**
     * 是否审核通过
     */
    private Integer reviewPass;

    /**
     * 验货人id
     */
    private Integer checkerId;

    /**
     * 验货人姓名
     */
    private String checkerName;

    /**
     * 验收备注
     */
    private String checkRemark;

    /**
     * 出入库时间（验货时间）
     */
    private String checkTime;

    /**
     * 是否验收通过
     */
    private Integer checkPass;

    public DepositoryRecordP(DepositoryRecord dr) {
        this.id = dr.getId();
        this.applicationId = dr.getApplicationId();
        this.mname = dr.getMname();
        this.depositoryId = dr.getDepositoryId();
        this.type = dr.getType();
        this.quantity = dr.getQuantity();
        this.price = dr.getPrice();
        this.state = dr.getState();
        this.applicantId = dr.getApplicantId();
        this.applyRemark = dr.getApplyRemark();
        this.applyTime = DateUtil.getSimpleTime(dr.getApplyTime());
        this.reviewerId = dr.getReviewerId();
        this.reviewRemark = dr.getReviewRemark();
        this.reviewTime = DateUtil.getSimpleTime(dr.getReviewTime());
        this.reviewPass = dr.getReviewPass();
        this.checkerId = dr.getCheckerId();
        this.checkRemark = dr.getCheckRemark();
        this.checkTime = DateUtil.getSimpleTime(dr.getCheckTime());
        this.checkPass = dr.getCheckPass();
    }
}
