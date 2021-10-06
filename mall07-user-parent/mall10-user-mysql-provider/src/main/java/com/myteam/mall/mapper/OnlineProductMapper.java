package com.myteam.mall.mapper;

import com.myteam.mall.entity.po.OnlineProduct;
import java.util.List;
import com.myteam.mall.entity.po.OnlineProductExample;
import org.apache.ibatis.annotations.Param;

public interface OnlineProductMapper {
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