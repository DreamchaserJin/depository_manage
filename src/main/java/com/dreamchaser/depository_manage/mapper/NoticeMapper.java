package com.dreamchaser.depository_manage.mapper;

import com.dreamchaser.depository_manage.entity.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Dreamchaser
 */
@Mapper
@Repository
public interface NoticeMapper {

    /**
     * 增加一条公告信息
     * @param map 参数map
     * @return 受影响的行数
     */
    Integer addNotice(Map<String,Object> map);

    /**
     * 根据条件查询符合条件的公告信息
     * @param map 参数map
     * @return 符合条件的公告列表
     */
    List<Notice> findNoticeByCondition(Map<String,Object> map);

}
