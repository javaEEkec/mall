package com.myteam.mall.mapper;

import com.myteam.mall.entity.po.OrderPO;
import com.myteam.mall.entity.po.OrderPOExample;
import java.util.List;

import com.myteam.mall.entity.vo.OrderProductUserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderPOMapper {
    long countByExample(OrderPOExample example);

    int deleteByExample(OrderPOExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(OrderPO record);

    int insertSelective(OrderPO record);

    List<OrderPO> selectByExample(OrderPOExample example);

    OrderPO selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") OrderPO record, @Param("example") OrderPOExample example);

    int updateByExample(@Param("record") OrderPO record, @Param("example") OrderPOExample example);

    int updateByPrimaryKeySelective(OrderPO record);

    int updateByPrimaryKey(OrderPO record);

    OrderPO getLastOrder();

    void insertOrderWithProductforId(@Param("orderId") Integer orderId,@Param("productId") Integer productId);

    List<OrderProductUserVO> selectByUserId(Integer userId);
}