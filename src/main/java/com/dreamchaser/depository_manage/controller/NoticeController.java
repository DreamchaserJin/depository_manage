package com.dreamchaser.depository_manage.controller;

import com.dreamchaser.depository_manage.pojo.RestResponse;
import com.dreamchaser.depository_manage.service.NoticeService;
import com.dreamchaser.depository_manage.utils.CrudUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Dreamchaser
 */
@RestController
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    @PostMapping("/notice")
    public RestResponse addNotice(@RequestBody Map<String,Object> map){
        return CrudUtil.postHandle(noticeService.addNotice(map),1);
    }
    @GetMapping("/notices")
    public RestResponse findNotices(@RequestParam Map<String,Object> map){
        return new RestResponse(noticeService.findNoticeByCondition(map));
    }

}
