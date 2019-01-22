package com.service.system;

import com.model.system.Activity;

import framework.utils.pageUtil.PagedResult;

public interface ActivityService {

	int addActivity(Activity activity);

	PagedResult<Activity> getAllActivityByPage(Integer pageNumber, Integer pageSize);

	int deleteActivityByActivityId(String activityId);

	int deleteActivityById(String activityId);

	Activity queryActivityById(String activityId);

	int updateActivityByActivity(Activity activity);

	Activity queryActivityIdById(String activityId);


}
