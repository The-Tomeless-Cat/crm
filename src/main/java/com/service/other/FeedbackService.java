package com.service.other;

import com.model.other.OrderFeedback;

import framework.utils.pageUtil.PagedResult;

public interface FeedbackService {

	PagedResult<OrderFeedback> getAllOrderFeedbackByPage(Integer pageNumber, Integer pageSize);

	int addOrderFeedback(OrderFeedback orderFeedback);

	int deletFeedbackByFeedbackId(String orderFeedbackId);

	int deleteFeedbackByFeedbackId(String feedbackId);

	PagedResult<OrderFeedback> likeQuery(String name);



}
