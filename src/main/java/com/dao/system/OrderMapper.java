package com.dao.system;

import java.util.List;

import com.model.system.Order;

public interface OrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

	List<Order> selectAllOrder();




	List<Order> selectOrderByUserid(String userid);


	Order getOrderByOrderId(String orderId);

}