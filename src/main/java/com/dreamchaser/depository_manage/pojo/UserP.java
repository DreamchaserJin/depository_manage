package com.dreamchaser.depository_manage.pojo;

import com.dreamchaser.depository_manage.entity.User;
import com.dreamchaser.depository_manage.utils.DateUtil;
import lombok.Data;


/**
 * user用户类的前端封装类
 * @author Dreamchaser
 */
@Data
public class UserP {

    /** 用户id */
    private Integer id;

    /** 用户名称 */
    private String uname;

    /** 表示权限等级 */
    private String authority;

    /** 性别 */
    private String sex;

    /** 负责仓库，序号表示仓库id，0表示全部仓库 */
    private Integer depositoryId;

    /** 负责仓库的名称 */
    private String depositoryName;

    /** 入职日期 */
    private String entryDate;

    /** 邮箱 */
    private String email;

    /** 手机号 */
    private String phone;


    public UserP(User user) {
        this.id = user.getId();
        this.uname = user.getUname();
        this.authority = user.getAuthority();
        this.sex = user.getSex();
        this.depositoryId = user.getDepositoryId();
        this.entryDate = DateUtil.getSimpleDate(user.getEntryDate());
        this.email = user.getEmail();
        this.phone = user.getPhone();
    }
}
