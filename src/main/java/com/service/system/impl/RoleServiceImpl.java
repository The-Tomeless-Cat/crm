package com.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.system.RoleMapper;
import com.github.pagehelper.PageHelper;
import com.model.system.Role;
import com.service.system.RoleService;

import framework.utils.pageUtil.PageBeanUtil;
import framework.utils.pageUtil.PagedResult;
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public PagedResult<Role> getAllRoleByPage(Integer pageNumber, Integer pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		
		List<Role> rolelist = roleMapper.selectAllRole();

		return PageBeanUtil.toPagedResult(rolelist);
	}

	@Override
	public int addRole(Role role) {
		// TODO Auto-generated method stub
		return roleMapper.insertSelective(role);
	}

	@Override
	public int deleteRoleById(String roleId) {
		return roleMapper.deleteByPrimaryKey(roleId);
	}

	@Override
	public Role queryRoleById(String roleId) {
		return roleMapper.selectByPrimaryKey(roleId);
	}

	@Override
	public int updateRoleByRole(Role role) {
		return roleMapper.updateByPrimaryKeySelective(role);
	}

	@Override
	public List<Role> queryAllRole() {
		return roleMapper.selectAllRole();
	}

	

}
