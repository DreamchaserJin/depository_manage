package com.dreamchaser.depository_manage.pojo;

import com.dreamchaser.depository_manage.entity.Material;
import lombok.Data;

/**
 * 库存类的包装类
 * @author Dreamchaser
 */
@Data
public class MaterialP {
    /** 存储id */
    private Integer id;

    /** 仓库名称 */
    private String depositoryName;

    /** 材料名称 */
    private String mname;

    /** 数量 */
    private Double quantity;

    /** 总金额 */
    private Double price;

    /** 材料种类名称 */
    private String typeName;

    public MaterialP(Integer id, Integer depositoryId, String mname, Double quantity, Double price, String typeName) {
        this.id = id;
        this.mname = mname;
        this.quantity = quantity;
        this.price = price;
        this.typeName = typeName;
    }
    public MaterialP(Material material) {
        this.id = material.getId();
        this.mname = material.getMname();
        this.quantity = material.getQuantity();
        this.price = material.getPrice();
    }
}
