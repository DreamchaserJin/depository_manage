package com.dreamchaser.depository_manage.service.impl;

import com.dreamchaser.depository_manage.entity.Notice;
import com.dreamchaser.depository_manage.mapper.NoticeMapper;
import com.dreamchaser.depository_manage.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Dreamchaser
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeMapper noticeMapper;
    @Override
    public Integer addNotice(Map<String, Object> map) {
        map.put("time",new Date());
        return noticeMapper.addNotice(map);
    }

    @Override
    public List<Notice> findNoticeByCondition(Map<String, Object> map) {
        return noticeMapper.findNoticeByCondition(map);
    }
}
