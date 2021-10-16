package com.myteam.mall.mapper;

import com.myteam.mall.entity.po.ComplaintPO;
import com.myteam.mall.entity.po.ComplaintPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintPOMapper {
    long countByExample(ComplaintPOExample example);

    int deleteByExample(ComplaintPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ComplaintPO record);

    int insertSelective(ComplaintPO record);

    List<ComplaintPO> selectByExample(ComplaintPOExample example);

    ComplaintPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ComplaintPO record, @Param("example") ComplaintPOExample example);

    int updateByExample(@Param("record") ComplaintPO record, @Param("example") ComplaintPOExample example);

    int updateByPrimaryKeySelective(ComplaintPO record);

    int updateByPrimaryKey(ComplaintPO record);
}