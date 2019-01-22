package com.dao.system;

import java.util.List;

import com.model.system.Menu;

public interface MenuMapper {
    int deleteByPrimaryKey(String menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(String menuId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

	List<Menu> selectAllMenu();

	List<Menu> queryMenuByUserId(String userId);

	List<Menu> queryMenuSonByMenuId(String menuId);

	List<Menu> selectAllMenu1();
}