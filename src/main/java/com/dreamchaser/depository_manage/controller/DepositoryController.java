package com.dreamchaser.depository_manage.controller;

import com.dreamchaser.depository_manage.pojo.RestResponse;
import com.dreamchaser.depository_manage.service.DepositoryService;
import com.dreamchaser.depository_manage.utils.CrudUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Dreamchser
 */
@RestController
public class DepositoryController {
    @Autowired
    DepositoryService depositoryService;

    @PostMapping("/depository")
    public RestResponse insertDepository(@RequestBody Map<String, Object> map) {
        return CrudUtil.postHandle(depositoryService.insertDepository(map), 1);
    }
}
