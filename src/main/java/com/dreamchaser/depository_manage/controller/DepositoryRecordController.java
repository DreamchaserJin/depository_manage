package com.dreamchaser.depository_manage.controller;

import com.dreamchaser.depository_manage.exception.MyException;
import com.dreamchaser.depository_manage.pojo.DepositoryRecordP;
import com.dreamchaser.depository_manage.pojo.RestResponse;
import com.dreamchaser.depository_manage.security.bean.UserToken;
import com.dreamchaser.depository_manage.service.DepositoryRecordService;
import com.dreamchaser.depository_manage.utils.CrudUtil;
import com.dreamchaser.depository_manage.utils.ObjectFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 仓库记录
 * @author Dreamchaser
 */
@RestController
public class DepositoryRecordController {
    @Autowired
    private DepositoryRecordService depositoryRecordService;
    @GetMapping("/depositoryRecord")
    public RestResponse findDepositoryRecordByCondition(@RequestParam Map<String,Object> map){
        List<DepositoryRecordP> list=depositoryRecordService.findDepositoryRecordPByCondition(map);
        return new RestResponse(list,depositoryRecordService.findCountByCondition(map),200);
    }
    @GetMapping("/myApply")
    public RestResponse findDepositoryRecordByCondition(@RequestParam Map<String,Object> map,HttpServletRequest request){
        UserToken userToken= (UserToken) request.getAttribute("userToken");
        map.put("applicantId",userToken.getUser().getId());
        List<DepositoryRecordP> list=depositoryRecordService.findDepositoryRecordPByCondition(map);
        return new RestResponse(list,depositoryRecordService.findCountByCondition(map),200);
    }
    @GetMapping("/myTask")
    public RestResponse myTask(@RequestParam Map<String,Object> map,HttpServletRequest request){
        UserToken userToken= (UserToken) request.getAttribute("userToken");
        map.put("userId",userToken.getUser().getId());
        return new RestResponse(depositoryRecordService.findMyTask(map)
                ,depositoryRecordService.findMyTaskCount(map),200);
    }
    @PostMapping("/depositoryRecord")
    public RestResponse insertDepositoryRecord(@RequestBody Map<String,Object> map, HttpServletRequest request){
        UserToken userToken= (UserToken) request.getAttribute("userToken");
        map.put("applicantId",userToken.getUser().getId());
        return CrudUtil.postHandle(depositoryRecordService.apply(map),1);
    }
    @DeleteMapping("/depositoryRecord")
    public RestResponse deleteDepositoryRecord(@RequestBody Map<String,Object> map){
        if (map.containsKey("id")){
            Integer id=ObjectFormatUtil.toInteger(map.get("id"));
            return CrudUtil.deleteHandle(depositoryRecordService.deleteDepositoryRecordById(id),1);
        }else if (map.containsKey("ids")){
            List<Integer> ids=(List<Integer>) map.get("ids");
            return CrudUtil.deleteHandle(depositoryRecordService.deleteDepositoryRecordByIds(ids),ids.size());
        }else {
            throw new MyException("所需请求参数缺失！");
        }
    }
    @PutMapping("/review")
    public RestResponse review(@RequestBody Map<String,Object> map, HttpServletRequest request){
        UserToken userToken= (UserToken) request.getAttribute("userToken");
        return CrudUtil.postHandle(depositoryRecordService.review(map,userToken.getUser().getId()),1);
    }
    @PutMapping("/transfer")
    public RestResponse transfer(@RequestBody Map<String,Object> map, HttpServletRequest request){
        UserToken userToken= (UserToken) request.getAttribute("userToken");
        map.put("applicantId",userToken.getUser().getId());
        return CrudUtil.postHandle(depositoryRecordService.transferApply(map),1);
    }
}
