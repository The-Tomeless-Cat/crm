package com.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.system.ActivityMapper;
import com.github.pagehelper.PageHelper;
import com.model.system.Activity;
import com.service.system.ActivityService;

import framework.utils.pageUtil.PageBeanUtil;
import framework.utils.pageUtil.PagedResult;

@Service
public class ActivityServiceImpl implements ActivityService{
	@Autowired
	private ActivityMapper activityMapper; 
	@Override
	public PagedResult<Activity> getAllActivityByPage(Integer pageNumber, Integer pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		// 2.鏌ヨ鏁版嵁搴擄紝鑾峰彇鏁版嵁
		List<Activity> activitylist = activityMapper.selectAllActivity();
		// 3.閫氳繃鍒嗛〉宸ュ叿绫诲姞杞藉垎椤垫暟鎹�
		return PageBeanUtil.toPagedResult(activitylist);
	}

	@Override
	public int addActivity(Activity activity) {
		return activityMapper.insertSelective(activity);
	}

	@Override
	public int deleteActivityByActivityId(String activityId) {
		return activityMapper.deleteByPrimaryKey(activityId);
	}

	@Override
	public int deleteActivityById(String activityId) {
		return activityMapper.deleteByPrimaryKey(activityId);
	}

	@Override
	public Activity queryActivityById(String activityId) {
		return activityMapper.selectByPrimaryKey(activityId);
	}

	@Override
	public int updateActivityByActivity(Activity activity) {
		return activityMapper.updateByPrimaryKeySelective(activity);
	}

	@Override
	public Activity queryActivityIdById(String activityId) {
		
		return activityMapper.selectByPrimaryKey(activityId);
	}
	
}

