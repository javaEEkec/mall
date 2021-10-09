package com.myteam.mall.mapper;

import com.myteam.mall.entity.InventoryProduct;
import com.myteam.mall.entity.InventoryProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InventoryProductMapper {
    long countByExample(InventoryProductExample example);

    int deleteByExample(InventoryProductExample example);

    int deleteByPrimaryKey(Integer productId);

    int insert(InventoryProduct record);

    int insertSelective(InventoryProduct record);

    List<InventoryProduct> selectByExample(InventoryProductExample example);

    InventoryProduct selectByPrimaryKey(Integer productId);

    int updateByExampleSelective(@Param("record") InventoryProduct record, @Param("example") InventoryProductExample example);

    int updateByExample(@Param("record") InventoryProduct record, @Param("example") InventoryProductExample example);

    int updateByPrimaryKeySelective(InventoryProduct record);

    int updateByPrimaryKey(InventoryProduct record);
}