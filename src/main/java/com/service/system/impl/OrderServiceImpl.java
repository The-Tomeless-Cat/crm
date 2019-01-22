package com.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dao.system.OrderMapper;
import com.github.pagehelper.PageHelper;
import com.model.system.Order;
import com.service.system.OrderService;

import framework.utils.pageUtil.PageBeanUtil;
import framework.utils.pageUtil.PagedResult;
@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderMapper orderMapper;
	
	@Override
	public PagedResult<Order> getAllOrderByPage(Integer pageNumber, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNumber, pageSize);
		// 2.查询数据库，获取数据
		List<Order> menulist = orderMapper.selectAllOrder();
		// 3.通过分页工具类加载分页数据
		return PageBeanUtil.toPagedResult(menulist);
	}

	@Override
	public int deleteOrder(String orderId) {
		// TODO Auto-generated method stub
		return orderMapper.deleteByPrimaryKey(orderId);
	}

	@Override
	public int addOrder(Order order) {
		// TODO Auto-generated method stub
		return orderMapper.insertSelective(order);
	}

	@Override
	public int updateOrderByOrderId(Order order) {
		// TODO Auto-generated method stub
		return orderMapper.updateByPrimaryKeySelective(order);
	}

	@Override
	public Order selectOrderByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return  orderMapper.selectByPrimaryKey(orderId);
	}

	@Override
	public PagedResult<Order> getAllOrderByPageAndUserid(Integer pageNumber, Integer pageSize, String userid) {
		PageHelper.startPage(pageNumber, pageSize);
		// 2.查询数据库，获取数据
		List<Order> menulist = orderMapper.selectOrderByUserid(userid);
		// 3.通过分页工具类加载分页数据
		return PageBeanUtil.toPagedResult(menulist);
	}

	@Override
	public int deleteOrderByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return orderMapper.deleteByPrimaryKey(orderId);
	}

	

}
