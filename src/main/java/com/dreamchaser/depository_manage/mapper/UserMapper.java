package com.dreamchaser.depository_manage.mapper;

import com.dreamchaser.depository_manage.entity.User;
import com.dreamchaser.depository_manage.pojo.SimpleUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 关于用户的mapper接口
 * @author Dreamchaser
 */
@Repository
@Mapper
public interface UserMapper {

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
     * 根据条件查询用户(此方法只能在确认结果只有一条记录时调用)
     * @param map
     * @return
     */
    User findUserByCondition(Map<String,Object> map);

    /**
     * 根据主键查询用户
     * @param id 用户id
     * @return 用户信息
     */
    User findUserById(Integer id);

    /**
     * 根据条件查询符合条件的用户
     * @param map
     * @return
     */
    List<User> findUsersByCondition(Map<String,Object> map);

    /**
     * 根据email查询用户信息
     * @param email
     * @return
     */
    User findUserByEmail(String email);

    /**
     * 根据用户id查询用户名
     * @param id 用户id
     * @return 用户名称
     */
    String findUserNameById(int id);


    /**
     * 根据参数插入一条用户信息
     * @param map 参数map
     * @return 受影响的行数，0表示插入失败，1表示成功
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
     * @param list 用户id的集合
     * @return 受影响的行数
     */
    Integer deleteUserByIds(List<Integer> list);

}
