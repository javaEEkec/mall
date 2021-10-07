package com.myteam.mall.service.impl;

import com.myteam.mall.entity.vo.PortalCategoryVO;
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
}
