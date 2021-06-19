package com.dreamchaser.depository_manage.service.impl;

import com.dreamchaser.depository_manage.entity.DepositoryRecord;
import com.dreamchaser.depository_manage.entity.Material;
import com.dreamchaser.depository_manage.entity.SimpleDepositoryRecord;
import com.dreamchaser.depository_manage.exception.MyException;
import com.dreamchaser.depository_manage.mapper.*;
import com.dreamchaser.depository_manage.pojo.DepositoryRecordP;
import com.dreamchaser.depository_manage.pojo.SimpleDepositoryRecordP;
import com.dreamchaser.depository_manage.service.DepositoryRecordService;
import com.dreamchaser.depository_manage.utils.ObjectFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Dreamchaser
 */
@Service
public class DepositoryRecordServiceImpl implements DepositoryRecordService {
    @Autowired
    private DepositoryRecordMapper depositoryRecordMapper;
    @Autowired
    private DepositoryMapper depositoryMapper;
    @Autowired
    private TransferRecordMapper transferRecordMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MaterialMapper materialMapper;
    @Override
    public Integer apply(Map<String, Object> map) {
        map.put("applyTime",new Date());
        map.put("state","待审核");
        return depositoryRecordMapper.insertDepositoryRecord(map);
    }

    /**
     * 转移申请
     * @param map 仓库调度信息
     * @return
     */
    @Override
    @Transactional
    public Integer transferApply(Map<String, Object> map) {
        map.put("state","待审核");
        map.put("type",0);
        map.put("depositoryId",map.get("fromId"));
        depositoryRecordMapper.insertDepositoryRecord(map);
        map.put("fromId",map.get("id"));
        //清除主键
        map.remove("id");
        map.put("depositoryId",map.get("toId"));
        map.put("type",1);
        depositoryRecordMapper.insertDepositoryRecord(map);
        map.put("toId",map.get("id"));
        //清除主键
        map.remove("id");
        return transferRecordMapper.addTransferRecord(map);
    }

    @Override
    @Transactional
    public Integer review(Map<String, Object> map,Integer userid) {
        if (map.containsKey("reviewPass")){
            map.put("reviewTime",new Date());
            map.put("reviewerId",userid);
            Integer reviewPass= (Integer) map.get("reviewPass");
            if (reviewPass==1){
                map.put("state","待验收");
            }else {
                map.put("state","审核未通过");
            }
        }else {
            map.put("checkTime",new Date());
            map.put("checkerId",userid);
            DepositoryRecord record=depositoryRecordMapper.findDepositoryRecordById(ObjectFormatUtil.toInteger(map.get("id")));
            map.put("depositoryId",record.getDepositoryId());
            map.put("mname",record.getMname());
            List<Material> list=materialMapper.findMaterialByCondition(map);
            Material material=list.get(0);
            Integer checkPass= (Integer) map.get("checkPass");
            if (checkPass==1){
                if (1 == record.getType()){
                    map.put("state","已入库");
                    //这里貌似会引起并发问题
                    material.setPrice(material.getPrice()+record.getPrice());
                    material.setQuantity(material.getQuantity()+record.getQuantity());
                    materialMapper.updateMaterial(material);
                }else {
                    if (material.getQuantity()>record.getQuantity()){
                        material.setPrice(material.getPrice()*(1-record.getQuantity()/material.getPrice()));
                        material.setQuantity(material.getQuantity()-record.getQuantity());
                        materialMapper.updateMaterial(material);
                    }else if (material.getQuantity().equals(record.getQuantity())){
                        materialMapper.deleteMaterialById(material.getId());
                    }else {
                        throw new MyException("库存不足于该出库请求");
                    }
                    map.put("state","已出库");
                }
            }else {
                map.put("state","验收未通过");
            }
        }
        return depositoryRecordMapper.updateDepositoryRecord(map);
    }


    @Override
    public Integer updateDepositoryRecord(Map<String, Object> map) {
        return depositoryRecordMapper.updateDepositoryRecord(map);
    }

    @Override
    public DepositoryRecordP findDepositoryRecordById(Integer id) {
        return singlePack(depositoryRecordMapper.findDepositoryRecordById(id));
    }

    public Integer checkPass(){
        return null;
    }

    @Override
    public List<DepositoryRecord> findDepositoryRecordAll() {
        return depositoryRecordMapper.findDepositoryRecordAll();
    }

    @Override
    public List<DepositoryRecordP> findDepositoryRecordPByCondition(Map<String,Object> map) {
        Integer size = 8,page=1;
        if (map.containsKey("size")){
            size=ObjectFormatUtil.toInteger(map.get("size"));
            map.put("size", size);
        }
        if (map.containsKey("page")){
            page=ObjectFormatUtil.toInteger(map.get("page"));
            map.put("begin",(page-1)*size);
        }
        return pack(depositoryRecordMapper.findDepositoryRecordByCondition(map));
    }

    @Override
    public List<SimpleDepositoryRecordP> findMyTask(Map<String, Object> map) {
        Integer size = 10,page=1;
        if (map.containsKey("size")){
            size=ObjectFormatUtil.toInteger(map.get("size"));
            map.put("size", size);
        }
        if (map.containsKey("page")){
            page=ObjectFormatUtil.toInteger(map.get("page"));
            map.put("begin",(page-1)*size);
        }
        return simplePack(depositoryRecordMapper.findMyTask(map));
    }

    @Override
    public Integer deleteDepositoryRecordById(Integer id) {
        return depositoryRecordMapper.deleteDepositoryRecordById(id);
    }

    @Override
    public Integer deleteDepositoryRecordByIds(List<Integer> list) {
        return depositoryRecordMapper.deleteDepositoryRecordByIds(list);
    }

    @Override
    public Integer findCount() {
        return depositoryRecordMapper.findCount();
    }

    @Override
    public Integer findMyTaskCount(Map<String,Object> map) {
        return depositoryRecordMapper.findMyTaskCount(map);
    }

    @Override
    public Integer findCountByCondition(Map<String, Object> map) {
        return depositoryRecordMapper.findCountByCondition(map);
    }

    /**
     * 对查出来的记录进行包装，包装成前端需要的数据
     * @param list SimpleDepositoryRecord集合
     * @return 包装好的集合
     */
    private List<SimpleDepositoryRecordP> simplePack(List<SimpleDepositoryRecord> list){
        List<SimpleDepositoryRecordP> result=new ArrayList<>(list.size());
        for (SimpleDepositoryRecord record: list){
            SimpleDepositoryRecordP d=new SimpleDepositoryRecordP(record);
            d.setApplicantName(userMapper.findUserNameById(record.getApplicantId()));
            result.add(d);
        }
        return result;
    }
    /**
     * 对查出来的记录进行包装，包装成前端需要的数据
     * @param list DepositoryRecord集合
     * @return 包装好的集合
     */
    private List<DepositoryRecordP> pack(List<DepositoryRecord> list){
        List<DepositoryRecordP> result=new ArrayList<>(list.size());
        for (DepositoryRecord record: list){
            result.add(singlePack(record));
        }
        return result;
    }
    private DepositoryRecordP singlePack(DepositoryRecord record){
        DepositoryRecordP d=new DepositoryRecordP(record);
        d.setApplicantName(userMapper.findUserNameById(record.getApplicantId()));
        d.setDepositoryName(depositoryMapper.findDepositoryNameById(record.getDepositoryId()));
        if (record.getReviewerId()!=null){
            d.setReviewerName(userMapper.findUserNameById(record.getReviewerId()));
        }
        if (record.getCheckerId()!=null){
            d.setCheckerName(userMapper.findUserNameById(record.getCheckerId()));
        }
        return d;
    }

}
