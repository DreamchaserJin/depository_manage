package com.dreamchaser.depository_manage.service;

import com.dreamchaser.depository_manage.entity.DepositoryRecord;
import com.dreamchaser.depository_manage.pojo.DepositoryRecordP;
import com.dreamchaser.depository_manage.pojo.SimpleDepositoryRecordP;

import java.util.List;
import java.util.Map;

/**
 * 仓库调度记录Service层
 * @author Dreamchaser
 */
public interface DepositoryRecordService {
    /**
     * 提交申请，插入一条仓库调度记录
     * @param map 仓库调度信息
     * @return 受影响的行数
     */
    Integer apply(Map<String,Object> map);

    /**
     * 转移申请
     * @param map 仓库调度信息
     * @return 受影响的行数
     */
    Integer transferApply(Map<String,Object> map);


    /**
     * 审核申请
     * @param map 仓库调度信息
     * @return 受影响的行数
     */
    Integer review(Map<String,Object> map,Integer userId);

    /**
     * 根据id修改仓库调度记录
     * @param map 参数map
     * @return 受影响的行数
     */
    Integer updateDepositoryRecord(Map<String,Object> map);

    /**
     * 根据id主键查询数据
     * @param id id
     * @return 该id的数据记录
     */
    DepositoryRecordP findDepositoryRecordById(Integer id);

    /**
     * 查找所有仓库调度记录
     * @return 所有的仓库调度记录集合
     */
    List<DepositoryRecord> findDepositoryRecordAll();

    /**
     * 根据条件查询仓库调度记录，同时支持分页查询（需要begin和size参数）
     * @param map 查询参数
     * @return 符合条件的仓库调度记录集合
     */
    List<DepositoryRecordP> findDepositoryRecordPByCondition(Map<String,Object> map);

    /**
     * 根据条件查询自己的任务（根据isDone来决定查询已完成或者未完成的任务），同时支持分页查询（需要begin和size参数）
     * @param map 查询参数
     * @return 我的任务
     */
    List<SimpleDepositoryRecordP> findMyTask(Map<String, Object> map);

    /**
     * 根据id删除仓库记录
     * @return 受影响的行数
     * @param id
     */
    Integer deleteDepositoryRecordById(Integer id);

    /**
     * 根据id集合删除多条仓库记录
     * @param list id集合
     * @return 受影响的行数
     */
    Integer deleteDepositoryRecordByIds(List<Integer> list);

    /**
     * 返回该表的总条数
     * @return 条数
     */
    Integer findCount();

    /**
     * 返回该我的任务数（完成或者未完成）
     * @return 条数
     */
    Integer findMyTaskCount(Map<String,Object> map);

    /**
     * 根据查询条件返回该表的总条数
     * @param map 条件参数
     * @return 条数
     */
    Integer findCountByCondition(Map<String,Object> map);
}
