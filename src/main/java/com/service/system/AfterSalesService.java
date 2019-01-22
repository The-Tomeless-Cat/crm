package com.service.system;

import com.model.system.AfterSales;
import com.model.system.Order;
import com.model.system.User;

import framework.utils.pageUtil.PagedResult;

public interface AfterSalesService {
	
	PagedResult<Order> getAllOrder(Integer pageNumber, Integer pageSize);

	Order getOrderByOrderId(String orderId);

	User getUserByUserId(String userId);

	int add(AfterSales aftersales);

	PagedResult<AfterSales> queryAll(Integer pageNumber, Integer pageSize);

	AfterSales querybyafterSalesId(String afterSalesId);

	int afterSalesUpdate(AfterSales aftersales);

	int afterSalesDelete(String afterSalesId);
}
