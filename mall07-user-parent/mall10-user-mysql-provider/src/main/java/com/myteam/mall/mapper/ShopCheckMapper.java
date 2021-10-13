package com.myteam.mall.mapper;

import com.myteam.mall.entity.po.ShopCheck;
import com.myteam.mall.entity.po.ShopCheckExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
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