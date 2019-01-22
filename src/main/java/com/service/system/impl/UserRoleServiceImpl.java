package com.service.system.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.system.UserRoleMapper;
import com.model.system.UserRole;
import com.service.system.UserRoleService;


@Service
public class UserRoleServiceImpl implements UserRoleService{
@Autowired
private UserRoleMapper userroleMapper;

	@Override
	public int deleteByUserRole(UserRole userrole) {
		// TODO Auto-generated method stub
		return userroleMapper.deleteByUserRole(userrole);
	}
	@Override
	public int addUserRole(UserRole userrole) {
		// TODO Auto-generated method stub
		System.err.println(userrole);
		return userroleMapper.insertSelective(userrole);
		
	}
	

}
