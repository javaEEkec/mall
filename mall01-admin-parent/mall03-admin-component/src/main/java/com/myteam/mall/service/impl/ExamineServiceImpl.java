package com.myteam.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myteam.mall.entity.ExamineProduct;
import com.myteam.mall.entity.ExamineProductExample;
import com.myteam.mall.mapper.ExamineProductMapper;
import com.myteam.mall.service.api.ExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamineServiceImpl implements ExamineService {

    @Autowired
    private ExamineProductMapper examineProductMapper;

    @Override
    public PageInfo<ExamineProduct> getExamineProductPageInfo(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        List<ExamineProduct> examineProductList = examineProductMapper.selectExamineProductByKeyword(keyword);

        return new PageInfo<>(examineProductList);
    }

    @Override
    public ExamineProduct getExamineProductById(Integer id) {
        return examineProductMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateExamineProductStatus(Integer id, Integer operator) {
        String status = operator==0?"审核通过":"审核不通过";

        //封装查询条件
        ExamineProductExample example = new ExamineProductExample();
        ExamineProductExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);

        ExamineProduct examineProduct = new ExamineProduct();
        examineProduct.setStatus(status);

        examineProductMapper.updateByExampleSelective(examineProduct,example);

    }
}
