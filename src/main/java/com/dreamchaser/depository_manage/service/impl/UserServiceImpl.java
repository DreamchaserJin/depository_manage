package com.dreamchaser.depository_manage.service.impl;

import com.dreamchaser.depository_manage.entity.User;
import com.dreamchaser.depository_manage.mapper.DepositoryMapper;
import com.dreamchaser.depository_manage.mapper.UserMapper;
import com.dreamchaser.depository_manage.pojo.UserP;
import com.dreamchaser.depository_manage.service.UserService;
import com.dreamchaser.depository_manage.utils.ObjectFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    static final Map<String,Object> REVIVER_MAP=new HashMap<>(1);
    static {
        REVIVER_MAP.put("authority","审核人");
    }
    @Autowired
    UserMapper userMapper;
    @Autowired
    DepositoryMapper depositoryMapper;

    @Override
    public Integer findCount() {
        return userMapper.findCount();
    }

    @Override
    public Integer findCountByCondition(Map<String, Object> map) {
        return userMapper.findCountByCondition(map);
    }

    @Override
    public UserP findUserPById(Integer id) {
        return singlePack(userMapper.findUserById(id));
    }

    @Override
    public User findUserByEmail(String principal) {
        return userMapper.findUserByEmail(principal);
    }

    @Override
    public User findUserByCondition(Map<String, Object> map) {
        return userMapper.findUserByCondition(map);
    }

    @Override
    public List<UserP> findUserPsByCondition(Map<String, Object> map) {
        Integer size = 8,page=1;
        if (map.containsKey("size")){
            size= ObjectFormatUtil.toInteger(map.get("size"));
            map.put("size", size);
        }
        if (map.containsKey("page")){
            page=ObjectFormatUtil.toInteger(map.get("page"));
            map.put("begin",(page-1)*size);
        }
        List<User> list=userMapper.findUsersByCondition(map);
        return pack(list);
    }

    @Override
    public List<User> findReviewers() {
        return userMapper.findUsersByCondition(REVIVER_MAP);
    }

    @Override
    public List<User> findUsersByDepositoryId(Integer depositoryId) {
        Map<String,Object> map=new HashMap<>(1);
        map.put("depositoryId",depositoryId);
        return userMapper.findUsersByCondition(map);
    }

    @Override
    public Integer insertUser(Map<String, Object> map) {
        return userMapper.insertUser(map);
    }

    @Override
    public Integer updateUser(Map<String, Object> map) {
        return userMapper.updateUser(map);
    }

    @Override
    public Integer updateUserNoSensitive(Map<String, Object> map) {
        return userMapper.updateUserNoSensitive(map);
    }

    @Override
    public Integer deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public Integer deleteUserByIds(List<Integer> ids) {
        return userMapper.deleteUserByIds(ids);
    }

    private List<UserP> pack(List<User> list){
        List<UserP> result=new ArrayList<>(list.size());
        for (User u:list){
            result.add(singlePack(u));
        }
        return result;
    }
    @Override
    public UserP singlePack(User user){
        UserP userP=new UserP(user);
        if (user.getDepositoryId()==-1){
            userP.setDepositoryName("全部仓库");
        }else {
            userP.setDepositoryName(depositoryMapper.findDepositoryNameById(user.getDepositoryId()));
        }
        return userP;
    }
}
