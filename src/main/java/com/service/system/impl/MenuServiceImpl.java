package com.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.system.MenuMapper;
import com.github.pagehelper.PageHelper;
import com.model.system.Menu;
import com.service.system.MenuService;

import framework.utils.pageUtil.PageBeanUtil;
import framework.utils.pageUtil.PagedResult;
@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuMapper menuMapper;

	@Override
	public PagedResult<Menu> getAllMenuByPage(Integer pageNumber, Integer pageSize) {
	
		PageHelper.startPage(pageNumber, pageSize);
	
		List<Menu> menulist = menuMapper.selectAllMenu();
	
		return PageBeanUtil.toPagedResult(menulist);
	}

	@Override
	public int addMenu(Menu menu) {
		return menuMapper.insertSelective(menu);
	}

	@Override
	public int deleteMenuById(String menuId) {
		return menuMapper.deleteByPrimaryKey(menuId);
	}

	
	@Override
	public int updateRoleByRole(Menu menu) {
		return menuMapper.updateByPrimaryKeySelective(menu);
	}

	@Override
	public Menu queryMenuById(String menuId) {
		return menuMapper.selectByPrimaryKey(menuId);
	}

	@Override
	public List<Menu> queryAllMenu() {
		return menuMapper.selectAllMenu();
	}

	@Override
	public List<Menu> queryMenuByUserId(String userId) {
		return menuMapper.queryMenuByUserId(userId);
	}

	@Override
	public List<Menu> queryMenuSonByMenuId(String menuId) {
		return menuMapper.queryMenuSonByMenuId(menuId);
	}
}
