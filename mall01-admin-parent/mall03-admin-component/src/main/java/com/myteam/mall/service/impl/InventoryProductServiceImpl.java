package com.myteam.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myteam.mall.constant.MallConstant;
import com.myteam.mall.entity.InventoryProduct;
import com.myteam.mall.entity.InventoryProductExample;
import com.myteam.mall.entity.InventoryProductVO;
import com.myteam.mall.exception.DecreaseNumOverInventoryNumException;
import com.myteam.mall.mapper.InventoryProductMapper0;
import com.myteam.mall.service.api.InventoryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InventoryProductServiceImpl implements InventoryProductService {

    @Autowired
    private InventoryProductMapper0 inventoryProductMapper;

    @Override
    public InventoryProduct getInventoryProductById(Integer productId) {
        return inventoryProductMapper.selectByPrimaryKey(productId);
    }

    @Override
    public PageInfo<InventoryProductVO> getProductPageInfo(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        List<InventoryProductVO> inventoryProducts = inventoryProductMapper.selectProductVOByKeyword(keyword);

        return new PageInfo<>(inventoryProducts);
    }

    @Override
    public void saveInventoryProduct(InventoryProduct inventoryProduct) {
        inventoryProductMapper.insert(inventoryProduct);
    }

    @Override
    public void increaseOrDecreaseInventory(Integer productId, Integer changeNum) {

        InventoryProductExample example = new InventoryProductExample();

        InventoryProductExample.Criteria criteria = example.createCriteria();

        criteria.andProductIdEqualTo(productId);

        InventoryProduct inventoryProduct = new InventoryProduct();

        Integer inventoryNum = inventoryProductMapper.selectInventoryNum(productId);

        inventoryProduct.setInventoryNum(inventoryNum+changeNum);

        if (changeNum < 0 && -(changeNum) > inventoryNum){
            throw new DecreaseNumOverInventoryNumException(MallConstant.MESSAGE_OVER_INVENTORY_NUM);
        }else {
            inventoryProductMapper.updateByExampleSelective(inventoryProduct,example);
        }
    }
}
