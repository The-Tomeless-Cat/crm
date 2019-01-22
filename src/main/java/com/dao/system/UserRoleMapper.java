package com.dao.system;

import com.model.system.RoleMenu;
import com.model.system.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(String userRoleId);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(String userRoleId);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

	int deleteByUserRole(UserRole uerfrole);

	int updateByPrimaryKey1(UserRole userrole);

	Object truncateMenu(RoleMenu rolemenu);
}