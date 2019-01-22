package com.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.system.AfterSalesMapper;
import com.dao.system.OrderMapper;
import com.dao.system.UserMapper;
import com.github.pagehelper.PageHelper;
import com.model.system.AfterSales;
import com.model.system.Order;
import com.model.system.User;
import com.service.system.AfterSalesService;

import framework.utils.pageUtil.PageBeanUtil;
import framework.utils.pageUtil.PagedResult;
@Service
public class AfterSalesServiceImpl implements AfterSalesService{
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private UserMapper usermapper;
	@Autowired
	private AfterSalesMapper aftersalesmapper;
	
	@Override
	public PagedResult<Order> getAllOrder(Integer pageNumber, Integer pageSize) {
		PageHelper.startPage(pageNumber, pageSize);

		List<Order> Orderlist = orderMapper.selectAllOrder();

		return PageBeanUtil.toPagedResult(Orderlist);
	}

	@Override
	public Order getOrderByOrderId(String orderId) {
		
		return orderMapper.getOrderByOrderId(orderId);
	}

	@Override
	public User getUserByUserId(String userId) {
		
		return usermapper.getUserByUserId(userId);
	}

	@Override
	public int add(AfterSales aftersales) {
		
		return aftersalesmapper.insert(aftersales);
	}

	@Override
	public PagedResult<AfterSales> queryAll(Integer pageNumber, Integer pageSize) {
		PageHelper.startPage(pageNumber, pageSize);

		List<AfterSales> afterSaleslist = aftersalesmapper.queryAfterSalesAll();

		return PageBeanUtil.toPagedResult(afterSaleslist);
	}

	@Override
	public AfterSales querybyafterSalesId(String afterSalesId) {
		
		return aftersalesmapper.selectByPrimaryKey(afterSalesId);
	}

	@Override
	public int afterSalesUpdate(AfterSales aftersales) {
		
		return aftersalesmapper.updateByPrimaryKeySelective(aftersales);
	}

	@Override
	public int afterSalesDelete(String afterSalesId) {
		
		return aftersalesmapper.deleteByPrimaryKey(afterSalesId);
	}



}
