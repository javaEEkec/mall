package com.myteam.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myteam.mall.constant.MallConstant;
import com.myteam.mall.entity.InventoryProduct;
import com.myteam.mall.entity.OnlineProduct;
import com.myteam.mall.entity.OnlineProductExample;
import com.myteam.mall.entity.OnlineProductVO;
import com.myteam.mall.exception.DecreaseNumOverInventoryNumException;
import com.myteam.mall.exception.DecreaseNumOverOnlineNumException;
import com.myteam.mall.mapper.OnlineProductMapper0;
import com.myteam.mall.service.api.InventoryProductService;
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

    @Autowired
    private InventoryProductService inventoryProductService;

    @Override
    public PageInfo<OnlineProductVO> getOnlineProductPageInfo(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        List<OnlineProductVO> list = onlineProductMapper.selectProductVOByKeyword(keyword);

        return new PageInfo<>(list);
    }

    @Override
    public OnlineProduct getOnlineProductById(Integer productId) {
        return onlineProductMapper.selectByPrimaryKey(productId);
    }

    @Override
    public void saveOnlineProduct(OnlineProduct onlineProduct) {
        onlineProductMapper.insert(onlineProduct);
    }

    @Override
    public void deleteOnlineProduct(Integer productId) {
        onlineProductMapper.deleteByPrimaryKey(productId);
    }

    @Override
    public void updateOnlineProductNum(Integer productId, Integer changeNum) {
        OnlineProductExample example = new OnlineProductExample();

        OnlineProductExample.Criteria criteria = example.createCriteria();

        criteria.andProductIdEqualTo(productId);

        OnlineProduct onlineProduct = new OnlineProduct();

        Integer onlineNum = onlineProductMapper.selectOnlineNum(productId);

        onlineProduct.setOnlineNum(onlineNum);
        if (changeNum < 0 && -(changeNum) > onlineNum){
            throw new DecreaseNumOverOnlineNumException(MallConstant.MESSAGE_OVER_ONLINE_NUM);
        }else {
            onlineProductMapper.updateByExampleSelective(onlineProduct,example);
            inventoryProductService.increaseOrDecreaseInventory(productId,changeNum);
        }

    }
}
