package com.myteam.mall.mapper;

import com.myteam.mall.entity.po.ExamineProduct;
import com.myteam.mall.entity.po.ExamineProductExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExamineProductMapper1 {
    long countByExample(ExamineProductExample example);

    int deleteByExample(ExamineProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExamineProduct record);

    int insertSelective(ExamineProduct record);

    List<ExamineProduct> selectByExample(ExamineProductExample example);

    ExamineProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExamineProduct record, @Param("example") ExamineProductExample example);

    int updateByExample(@Param("record") ExamineProduct record, @Param("example") ExamineProductExample example);

    int updateByPrimaryKeySelective(ExamineProduct record);

    int updateByPrimaryKey(ExamineProduct record);
}