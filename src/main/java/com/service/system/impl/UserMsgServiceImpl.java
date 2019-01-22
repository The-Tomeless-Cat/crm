package com.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.system.UserMsgMapper;
import com.github.pagehelper.PageHelper;
import com.model.system.UserMsg;
import com.service.system.UserMsgService;

import framework.utils.pageUtil.PageBeanUtil;
import framework.utils.pageUtil.PagedResult;
@Service
public class UserMsgServiceImpl implements UserMsgService {
	@Autowired
	UserMsgMapper userMsgMapper;
	@Override
	public PagedResult<UserMsg> getAllUserMsgByPage(Integer pageNumber, Integer pageSize) {
PageHelper.startPage(pageNumber, pageSize);
		
		List<UserMsg> userMsglist = userMsgMapper.selectAlluserMsg();
	
		return PageBeanUtil.toPagedResult(userMsglist);
	}
	@Override
	public List<UserMsg> queryAllUserMsg() {
		return userMsgMapper.selectAlluserMsg();
	}
	@Override
	public int addUserMsg(UserMsg userMsg) {
		return userMsgMapper.insertSelective(userMsg);
	}
	@Override
	public int deleteUserMsgById(String userMsgId) {
		return userMsgMapper.deleteByPrimaryKey(userMsgId);
	}
	@Override
	public UserMsg queryUserMsgById(String userMsgId) {
		
		return userMsgMapper.selectByPrimaryKey(userMsgId);
	}
	@Override
	public int updateUserMsgByUserMsg(UserMsg userMsg) {
		return userMsgMapper.updateByPrimaryKeySelective(userMsg);
	}

	

}
