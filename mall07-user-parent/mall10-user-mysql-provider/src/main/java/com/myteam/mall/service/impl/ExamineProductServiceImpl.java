package com.myteam.mall.service.impl;

import com.myteam.mall.entity.po.ExamineProduct;
import com.myteam.mall.mapper.ExamineProductMapper1;
import com.myteam.mall.service.api.ExamineProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mzx
 */
@Service
public class ExamineProductServiceImpl implements ExamineProductService {

    @Autowired
    ExamineProductMapper1 examineProductMapper1;

    @Override
    public void saveExamineProduct(ExamineProduct examineProduct) {
        examineProductMapper1.insert(examineProduct);
    }
}
