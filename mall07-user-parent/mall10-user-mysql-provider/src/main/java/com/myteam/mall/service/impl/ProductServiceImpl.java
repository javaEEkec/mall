package com.myteam.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myteam.mall.entity.po.OnlineProduct;
import com.myteam.mall.entity.vo.PortalCategoryVO;
import com.myteam.mall.entity.vo.ProductSimpleVO;
import com.myteam.mall.mapper.OnlineProductMapper;
import com.myteam.mall.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private OnlineProductMapper onlineProductMapper;

    @Override
    public List<PortalCategoryVO> getPortalCategoryVO() {
        return onlineProductMapper.selectPortalCategoryVOList();
    }


    @Override
    public PageInfo<ProductSimpleVO> getProductsPageInfo(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ProductSimpleVO> productList = onlineProductMapper.selectProductsByKeyword(keyword);
        return new PageInfo<>(productList);
    }

    @Override
    public OnlineProduct getProductById(Integer productId) {
        return onlineProductMapper.selectByPrimaryKey(productId);
    }
}
