package com.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.system.UserMapper;
import com.github.pagehelper.PageHelper;
import com.model.system.User;
import com.service.system.UserService;

import framework.utils.pageUtil.PageBeanUtil;
import framework.utils.pageUtil.PagedResult;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;

	@Override
	public User queryToLogin(User user) {
		// TODO Auto-generated method stub
		return userMapper.queryToLogin(user);
	}
	
	@Override
	public PagedResult<User> getAllUserByPage(Integer pageNumber, Integer pageSize) {
	
		PageHelper.startPage(pageNumber, pageSize);

		List<User> userlist = userMapper.selectAllUser();

		return PageBeanUtil.toPagedResult(userlist);

	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.insertSelective(user);
	}

	@Override
	public int deleteUserById(String userId) {
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public User queryUserById(String userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public int updateUserByUser(User user) {
		
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public User queryUserByAccountAndPassword(User user) {
		return userMapper.queryUserByAccountAndPassword(user);
	}

	@Override
	public List<User> queryAllUser() {
		
		return userMapper.queryAllUser();
	}

}
