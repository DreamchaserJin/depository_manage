package com.dreamchaser.depository_manage.pojo;

import com.dreamchaser.depository_manage.entity.DepositoryRecord;
import com.dreamchaser.depository_manage.entity.SimpleDepositoryRecord;
import com.dreamchaser.depository_manage.utils.DateUtil;
import lombok.Data;

import java.util.Date;

/**
 * @author Dreamchaser
 */
@Data
public class SimpleDepositoryRecordP {
    /** 记录id */
    private Integer id;

    /** 调度记录类型（购入/退料/转入,退还/领料/转出) */
    private Integer type;

    /** 申请人id */
    private String applicantName;

    /** 申请备注 */
    private String applyRemark;

    /** 申请时间 */
    private String applyTime;



    public SimpleDepositoryRecordP(SimpleDepositoryRecord d) {
        this.id=d.getId();
        this.type = d.getType();
        this.applyRemark = d.getApplyRemark();
        this.applyTime = DateUtil.getSimpleTime(d.getApplyTime());
    }
}
