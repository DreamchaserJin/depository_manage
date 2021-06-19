package com.dreamchaser.depository_manage.service;

import com.dreamchaser.depository_manage.entity.User;
import com.dreamchaser.depository_manage.pojo.UserP;

import java.util.List;
import java.util.Map;

/**
 * user的service层
 * @author Dreamchaser
 */
public interface UserService {
    /**
     * 查询user表的所有数据的行数
     * @return 行数
     */
    Integer findCount();

    /**
     * 查询user表的符合条件数据的行数
     * @param map 参数map
     * @return 符合条件数据的行数
     */
    Integer findCountByCondition(Map<String,Object> map);

    /**
     * 根据主键查询用户
     * @param id 用户id
     * @return 用户信息
     */
    UserP findUserPById(Integer id);
    /**
     * 根据邮箱获取User对象
     * @param principal 邮箱
     * @return user对象
     */
    User findUserByEmail(String principal);

    /**
     * 根据条查询User对象
     * @param map 参数map
     * @return user对象
     */
    User findUserByCondition(Map<String,Object> map);

    /**
     * 根据条件查询符合条件的用户集合
     * @param map 参数map
     * @return 符合条件的用户集合
     */
    List<UserP> findUserPsByCondition(Map<String,Object> map);

    /**
     * 查询所有的审核人
     * @return 所有审核人对象
     */
    List<User> findReviewers();

    /**
     * 根据仓库id查询对应的仓管员
     * @param depositoryId 仓库id
     * @return 用户名称
     */
    List<User> findUsersByDepositoryId(Integer depositoryId);

    /**
     * 根据参数插入一条用户信息
     * @param map 参数map
     * @return 受影响的行数
     */
    Integer insertUser(Map<String,Object> map);

    /**
     * 更新用户信息
     * @param map 参数map
     * @return 受影响的行数
     */
    Integer updateUser(Map<String,Object> map);

    /**
     * 更新用户非敏感信息（一般用户自己的修改）
     * @param map 参数map
     * @return 受影响的行数
     */
    Integer updateUserNoSensitive(Map<String,Object> map);

    /**
     * 根据id删除用户
     * @param id 用户id
     * @return 受影响的行数
     */
    Integer deleteUserById(Integer id);
    /**
     * 根据id批量删除数据
     * @param ids 用户id的集合
     * @return 受影响的行数
     */
    Integer deleteUserByIds(List<Integer> ids);

    /**
     * 根据拥有的user对象包装成前端常用的UserP对象
     * @param user user对象
     * @return UserP对象
     */
    UserP singlePack(User user);
}
