package com.dreamchaser.depository_manage.mapper;

import com.dreamchaser.depository_manage.entity.Material;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Dreamchaser
 */
@Repository
@Mapper
public interface MaterialMapper {

    /**
     * 增加一条库存记录
     *
     * @param map 参数map
     * @return 受影响的行数
     */
    Integer insertMaterial(Map<String, Object> map);

    /**
     * 更新一条库存记录
     *
     * @param map 参数列表
     * @return 受影响的行数
     */
    Integer updateMaterial(Map<String, Object> map);

    /**
     * 更新一条库存记录
     * @param material 修改的参数
     * @return 受影响的行数
     */
    Integer updateMaterial(Material material);

    /**
     * 将对应仓库id和材料名称的库存修改数量和价格
     * @param map 参数列表
     * @return 受影响的行数
     */
    Integer changeMaterial(Map<String, Object> map);

    /**
     * 根据id删除一条库存记录
     * @param id 库存id
     * @return 受影响的行数
     */
    Integer deleteMaterialById(int id);

    /**
     * 根据条件查询符合条件的库存信息
     * @param map 条件map
     * @return 符合条件的库存信息
     */
    List<Material> findMaterialByCondition(Map<String,Object>map);

    /**
     * 查询所有的库存信息
     * @return 所有的库存信息
     */
    List<Material> findMaterialAll();

    /**
     * 根据id查询库存信息
     * @param id 库存id
     * @return 库存信息
     */
    Material findMaterialById(int id);
    /**
     * 根据id批量查询库存信息
     * @param ids 库存id集合
     * @return 库存信息
     */
    Material findMaterialByIds(List<Integer> ids);

    /**
     * 查询所有库存条数
     * @return 库存记录的行数
     */
    Integer findCount();

    /**
     * 根据条件返回符合条件的库存记录行数
     * @param map 参数
     * @return 符合条件的记录行数
     */
    Integer findCountByCondition(Map<String,Object> map);
}
