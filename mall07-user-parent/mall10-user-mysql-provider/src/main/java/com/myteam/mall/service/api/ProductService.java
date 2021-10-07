package com.myteam.mall.service.api;

import com.myteam.mall.entity.vo.PortalCategoryVO;

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
}
