package com.dao.system;

import com.model.system.ActivityProduct;

public interface ActivityProductMapper {
    int deleteByPrimaryKey(String activityProductId);

    int insert(ActivityProduct record);

    int insertSelective(ActivityProduct record);

    ActivityProduct selectByPrimaryKey(String activityProductId);

    int updateByPrimaryKeySelective(ActivityProduct record);

    int updateByPrimaryKey(ActivityProduct record);

	int deleteByActivityProduct(ActivityProduct activityproduct);

	
}