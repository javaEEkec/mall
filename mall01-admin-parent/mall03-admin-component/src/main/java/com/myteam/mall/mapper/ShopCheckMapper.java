package com.myteam.mall.mapper;

import com.myteam.mall.entity.ShopCheck;
import com.myteam.mall.entity.ShopCheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopCheckMapper {
    long countByExample(ShopCheckExample example);

    int deleteByExample(ShopCheckExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopCheck record);

    int insertSelective(ShopCheck record);

    List<ShopCheck> selectByExample(ShopCheckExample example);

    ShopCheck selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopCheck record, @Param("example") ShopCheckExample example);

    int updateByExample(@Param("record") ShopCheck record, @Param("example") ShopCheckExample example);

    int updateByPrimaryKeySelective(ShopCheck record);

    int updateByPrimaryKey(ShopCheck record);

    List<ShopCheck> selectShopCheckByKeyword(String keyword);
}