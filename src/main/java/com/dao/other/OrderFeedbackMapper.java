package com.dao.other;

import java.util.List;

import com.model.other.OrderFeedback;

public interface OrderFeedbackMapper {
    int deleteByPrimaryKey(String feedbackId);

    int insert(OrderFeedback record);

    int insertSelective(OrderFeedback record);

    OrderFeedback selectByPrimaryKey(String feedbackId);

    int updateByPrimaryKeySelective(OrderFeedback record);

    int updateByPrimaryKey(OrderFeedback record);

	List<OrderFeedback> selectAllFeedback();

	List<OrderFeedback> likeQuery(String name);
   
}