package com.myteam.mall.mapper;

import com.myteam.mall.entity.OnlineProduct;
import com.myteam.mall.entity.OnlineProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OnlineProductMapper0 {
    long countByExample(OnlineProductExample example);

    int deleteByExample(OnlineProductExample example);

    int deleteByPrimaryKey(Integer productId);

    int insert(OnlineProduct record);

    int insertSelective(OnlineProduct record);

    List<OnlineProduct> selectByExample(OnlineProductExample example);

    OnlineProduct selectByPrimaryKey(Integer productId);

    int updateByExampleSelective(@Param("record") OnlineProduct record, @Param("example") OnlineProductExample example);

    int updateByExample(@Param("record") OnlineProduct record, @Param("example") OnlineProductExample example);

    int updateByPrimaryKeySelective(OnlineProduct record);

    int updateByPrimaryKey(OnlineProduct record);
}