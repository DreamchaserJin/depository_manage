package com.dreamchaser.depository_manage.service;

import java.util.Map;

/**
 * 材料的服务层接口
 * @author 金昊霖
 */
public interface MaterialTypeService {
    /**
     * 插入一条材料类型记录
     * @param map 参数map
     * @return 受影响的数量
     */
    Integer insertMaterialType(Map<String,Object> map);
}
