package com.service.system;

import com.model.system.Order;

import framework.utils.pageUtil.PagedResult;

public interface OrderService {


	int deleteOrder(String orderId);

	int addOrder(Order order);


	Order selectOrderByOrderId(String orderId);


	int updateOrderByOrderId(Order order);



	PagedResult<Order> getAllOrderByPage(Integer pageNumber, Integer pageSize);


	PagedResult<Order> getAllOrderByPageAndUserid(Integer pageNumber, Integer pageSize, String userid);

	int deleteOrderByOrderId(String orderId);


}
