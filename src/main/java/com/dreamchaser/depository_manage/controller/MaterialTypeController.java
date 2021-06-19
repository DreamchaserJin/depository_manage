package com.dreamchaser.depository_manage.controller;

import com.dreamchaser.depository_manage.pojo.RestResponse;
import com.dreamchaser.depository_manage.service.MaterialTypeService;
import com.dreamchaser.depository_manage.utils.CrudUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MaterialTypeController {
    @Autowired
    MaterialTypeService materialTypeService;
    @PostMapping("/materialType")
    public RestResponse insertMaterialType(@RequestBody Map<String,Object> map){
        return CrudUtil.postHandle(materialTypeService.insertMaterialType(map),1);
    }

}
