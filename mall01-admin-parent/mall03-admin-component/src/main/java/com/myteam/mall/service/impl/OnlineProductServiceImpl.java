package com.myteam.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myteam.mall.entity.InventoryProduct;
import com.myteam.mall.entity.OnlineProduct;
import com.myteam.mall.entity.OnlineProductVO;
import com.myteam.mall.mapper.OnlineProductMapper0;
import com.myteam.mall.service.api.OnlineProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mzx
 */
@Service
public class OnlineProductServiceImpl implements OnlineProductService {

    @Autowired
    private OnlineProductMapper0 onlineProductMapper;

    @Override
    public PageInfo<OnlineProductVO> getOnlineProductPageInfo(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        List<OnlineProductVO> list = onlineProductMapper.selectProductVOByKeyword(keyword);

        return new PageInfo<>(list);
    }

    @Override
    public OnlineProduct getOnlineProductById(Integer productId) {
        return null;
    }

    @Override
    public void saveOnlineProduct(OnlineProduct onlineProduct) {
        onlineProductMapper.insert(onlineProduct);
    }
}
