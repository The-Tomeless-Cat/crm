package com.service.system;

import java.util.List;

import com.model.system.UserMsg;

import framework.utils.pageUtil.PagedResult;

public interface UserMsgService {



	PagedResult<UserMsg> getAllUserMsgByPage(Integer pageNumber, Integer pageSize);

	List<UserMsg> queryAllUserMsg();

	int addUserMsg(UserMsg userMsg);

	int deleteUserMsgById(String userMsgId);

	UserMsg queryUserMsgById(String userMsgId);

	int updateUserMsgByUserMsg(UserMsg userMsg);

}
