package com.dreamchaser.depository_manage.service.impl;

import com.dreamchaser.depository_manage.mapper.MaterialTypeMapper;
import com.dreamchaser.depository_manage.service.MaterialTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author 金昊霖
 */
@Service
public class MaterialTypeServiceImpl implements MaterialTypeService {
    @Autowired
    MaterialTypeMapper materialTypeMapper;
    @Override
    public Integer insertMaterialType(Map<String,Object> map) {
        return materialTypeMapper.insertMaterialType(map);
    }
}
