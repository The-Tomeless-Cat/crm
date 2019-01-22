package com.dao.buy;

import com.model.buy.OrderProduct;

public interface OrderProductMapper {
    int deleteByPrimaryKey(String orderProductId);

    int insert(OrderProduct record);

    int insertSelective(OrderProduct record);

    OrderProduct selectByPrimaryKey(String orderProductId);

    int updateByPrimaryKeySelective(OrderProduct record);

    int updateByPrimaryKey(OrderProduct record);
}