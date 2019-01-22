package com.service.system;

import com.model.system.RoleMenu;

public interface RoleMenuService {

	int deleteByRoleMenu(RoleMenu rolemenu);

	int addRoleMenu(RoleMenu rolemenu);

	int truncateMenu(String roleId);

}
