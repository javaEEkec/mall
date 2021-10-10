package com.myteam.mall.service.api;

import com.github.pagehelper.PageInfo;
import com.myteam.mall.entity.ExamineProduct;

public interface ExamineService {

    PageInfo<ExamineProduct> getExamineProductPageInfo(String keyword, Integer pageNum, Integer pageSize);

    ExamineProduct getExamineProductById(Integer id);

    void updateExamineProductStatus(Integer id,Integer operator);
}
