package com.service.system;

import java.util.List;

import com.model.system.User;

import framework.utils.pageUtil.PagedResult;

public interface UserService {

	User queryToLogin(User user);

	PagedResult<User> getAllUserByPage(Integer pageNumber, Integer pageSize);

	int addUser(User user);

	int deleteUserById(String userId);

	User queryUserById(String userId);

	int updateUserByUser(User user);

	User queryUserByAccountAndPassword(User user);

	List<User> queryAllUser();

}
