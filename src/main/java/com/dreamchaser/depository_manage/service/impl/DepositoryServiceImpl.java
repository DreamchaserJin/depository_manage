package com.dreamchaser.depository_manage.service.impl;

import com.dreamchaser.depository_manage.entity.Depository;
import com.dreamchaser.depository_manage.mapper.DepositoryMapper;
import com.dreamchaser.depository_manage.service.DepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DepositoryServiceImpl implements DepositoryService {
    @Autowired
    DepositoryMapper depositoryMapper;
    @Override
    public Integer insertDepository(Map<String, Object> map) {
        return depositoryMapper.insertDepository(map);
    }

    @Override
    public List<Depository> findDepositoryAll() {
        return depositoryMapper.findDepositoryAll();
    }


}
