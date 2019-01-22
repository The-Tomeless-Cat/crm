package com.service.other.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.other.OrderFeedbackMapper;
import com.github.pagehelper.PageHelper;
import com.model.other.OrderFeedback;
import com.service.other.FeedbackService;

import framework.utils.pageUtil.PageBeanUtil;
import framework.utils.pageUtil.PagedResult;
@Service
public class FeedbackServiceImpl implements FeedbackService{
	@Autowired
	private OrderFeedbackMapper orderFeedbackMapper; 
	
	@Override
	public PagedResult<OrderFeedback> getAllOrderFeedbackByPage(Integer pageNumber, Integer pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		// 2.查询数据库，获取数据
		List<OrderFeedback> activitylist = orderFeedbackMapper.selectAllFeedback();
		// 3.通过分页工具类加载分页数据
		return PageBeanUtil.toPagedResult(activitylist);
	}

	@Override
	public int addOrderFeedback(OrderFeedback orderFeedback) {
		// TODO Auto-generated method stub
		return orderFeedbackMapper.insertSelective(orderFeedback);
	}

	@Override
	public int deletFeedbackByFeedbackId(String orderFeedbackId) {
		// TODO Auto-generated method stub
		return orderFeedbackMapper.deleteByPrimaryKey(orderFeedbackId);
	}

	@Override
	public int deleteFeedbackByFeedbackId(String feedbackId) {
		// TODO Auto-generated method stub
		return orderFeedbackMapper.deleteByPrimaryKey(feedbackId);
	}

	@Override
	public PagedResult<OrderFeedback> likeQuery(String name) {
		// TODO Auto-generated method stub
		List<OrderFeedback> feedbackList = orderFeedbackMapper.likeQuery(name);
		return PageBeanUtil.toPagedResult(feedbackList);
	}

}
