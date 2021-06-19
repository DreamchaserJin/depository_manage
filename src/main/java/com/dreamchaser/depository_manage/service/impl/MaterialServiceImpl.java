package com.dreamchaser.depository_manage.service.impl;

import com.dreamchaser.depository_manage.entity.DepositoryRecord;
import com.dreamchaser.depository_manage.entity.Material;
import com.dreamchaser.depository_manage.mapper.DepositoryMapper;
import com.dreamchaser.depository_manage.mapper.MaterialMapper;
import com.dreamchaser.depository_manage.mapper.MaterialTypeMapper;
import com.dreamchaser.depository_manage.pojo.DepositoryRecordP;
import com.dreamchaser.depository_manage.pojo.MaterialP;
import com.dreamchaser.depository_manage.service.MaterialService;
import com.dreamchaser.depository_manage.utils.ObjectFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Dreamchaser
 */
@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    MaterialMapper materialMapper;
    @Autowired
    DepositoryMapper depositoryMapper;
    @Autowired
    MaterialTypeMapper materialTypeMapper;
    @Override
    public Integer insertMaterial(Map<String, Object> map) {
        return materialMapper.insertMaterial(map);
    }

    @Override
    public Integer updateMaterial(Map<String, Object> map) {
        return materialMapper.updateMaterial(map);
    }

    @Override
    public Integer deleteMaterialById(int id) {
        return materialMapper.deleteMaterialById(id);
    }

    @Override
    public List<MaterialP> findMaterialPByCondition(Map<String, Object> map) {
        Integer size = 10,page=1;
        if (map.containsKey("size")){
            size= ObjectFormatUtil.toInteger(map.get("size"));
            map.put("size", size);
        }
        if (map.containsKey("page")){
            page=ObjectFormatUtil.toInteger(map.get("page"));
            map.put("begin",(page-1)*size);
        }
        List<Material> list=materialMapper.findMaterialByCondition(map);
        return pack(list);
    }

    @Override
    public List<Material> findMaterialAll() {
        return materialMapper.findMaterialAll();
    }

    @Override
    public Material findMaterialById(int id) {
        return materialMapper.findMaterialById(id);
    }

    @Override
    public Material findMaterialByIds(List<Integer> ids) {
        return materialMapper.findMaterialByIds(ids);
    }

    @Override
    public Integer findCount() {
        return materialMapper.findCount();
    }

    @Override
    public Integer findCountByCondition(Map<String,Object> map) {
        return materialMapper.findCountByCondition(map);
    }


    /**
     * 对查出来的记录进行包装，包装成前端需要的数据
     * @param list DepositoryRecord集合
     * @return 包装好的集合
     */
    private List<MaterialP> pack(List<Material> list){
        List<MaterialP> result=new ArrayList<>(list.size());
        for (Material material: list){
            MaterialP m=new MaterialP(material);
            m.setDepositoryName(depositoryMapper.findDepositoryNameById(material.getDepositoryId()));
            m.setTypeName(materialTypeMapper.findMaterialTypeNameById(material.getTypeId()));
            result.add(m);
        }
        return result;
    }
}
