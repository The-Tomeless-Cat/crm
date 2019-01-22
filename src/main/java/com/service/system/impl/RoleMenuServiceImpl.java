package com.service.system.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.system.RoleMenuMapper;
import com.model.system.RoleMenu;
import com.service.system.RoleMenuService;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {
	@Autowired
	private RoleMenuMapper rolemenuMapper;

	@Override
	public int deleteByRoleMenu(RoleMenu rolemenu) {
		// TODO Auto-generated method stub
		return rolemenuMapper.deleteByRoleMenu(rolemenu);
	}

	@Override
	public int addRoleMenu(RoleMenu rolemenu) {
		// TODO Auto-generated method stub
		return rolemenuMapper.insert(rolemenu);
	}

	
	@Override
	public int truncateMenu(String roleId) {
		return rolemenuMapper.deleteByPrimaryKey1(roleId);
	}

}
