package com.service.system;

import java.util.List;

import com.model.system.Role;

import framework.utils.pageUtil.PagedResult;

public interface RoleService {
	PagedResult<Role> getAllRoleByPage(Integer pageNumber, Integer pageSize);

	int addRole(Role role);

	int deleteRoleById(String roleId);

	Role queryRoleById(String roleId);

	int updateRoleByRole(Role role);

	List<Role> queryAllRole();



	

}
