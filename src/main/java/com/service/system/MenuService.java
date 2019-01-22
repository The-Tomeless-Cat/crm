package com.service.system;


import java.util.List;

import com.model.system.Menu;


import framework.utils.pageUtil.PagedResult;

public interface MenuService {

	PagedResult<Menu> getAllMenuByPage(Integer pageNumber, Integer pageSize);

	int addMenu(Menu menu);

	int deleteMenuById(String menuId);

	

	int updateRoleByRole(Menu menu);

	Menu queryMenuById(String menuId);

	List<Menu> queryAllMenu();

	List<Menu> queryMenuByUserId(String userId);

	List<Menu> queryMenuSonByMenuId(String menuId);

	
}
