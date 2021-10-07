package com.myteam.mall.mapper;

import com.myteam.mall.entity.po.OnlineProduct;
import com.myteam.mall.entity.po.OnlineProductExample;
import com.myteam.mall.entity.vo.PortalCategoryVO;
import com.myteam.mall.entity.vo.ProductSimpleVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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

    List<PortalCategoryVO> selectPortalCategoryVOList();

    List<ProductSimpleVO> selectProductSimpleVOList(String category);


}