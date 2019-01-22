package com.service.system.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.system.ActivityProductMapper;
import com.model.system.ActivityProduct;
import com.service.system.ActivityProductService;
@Service
public class ActivityProductServiceImpl implements ActivityProductService {
	@Autowired
	private ActivityProductMapper activityProductMapper;
	@Override
	public int deleteByActivityProduct(ActivityProduct activityproduct) {
		
		return activityProductMapper.deleteByActivityProduct(activityproduct);
	}
	@Override
	public int addActivityProduct(ActivityProduct activityproduct) {
		
		return activityProductMapper.insertSelective(activityproduct);
	}


}
