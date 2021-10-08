package com.myteam.mall.service.api;

import com.github.pagehelper.PageInfo;
import com.myteam.mall.entity.po.OnlineProduct;
import com.myteam.mall.entity.vo.PortalCategoryVO;
import com.myteam.mall.entity.vo.ProductSimpleVO;

import java.util.List;

/**
 * @author ljs
 */
public interface ProductService {
    /**
     * 获取展示在首页的分类信息
     * @return List<PortalCategoryVO>
     */
    List<PortalCategoryVO> getPortalCategoryVO();

    /**
     * 查询商品的分页详情
     * @param keyword 根据关键词查找
     * @param pageNum 页码
     * @param pageSize 每页显示数量
     * @return
     */
    PageInfo<ProductSimpleVO> getProductsPageInfo(String keyword, Integer pageNum, Integer pageSize);
}
