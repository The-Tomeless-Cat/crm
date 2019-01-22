package com.controller.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.system.Menu;
import com.model.system.Role;
import com.model.system.RoleMenu;


import framework.controller.BaseController;
import framework.utils.PrimaryKeyUtil;
import framework.utils.pageUtil.PagedResult;

@Controller
@RequestMapping("menuController")
public class MenuController extends BaseController {

	/**
	 * 查看菜单列表
	 */
	private static final long serialVersionUID = 1L;
	
	@RequestMapping(value = "listPage.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
		System.out.println("菜单列表.....");
		ModelAndView mv = new ModelAndView();
		PagedResult<Menu> pageResult = menuService.getAllMenuByPage(pageNumber, pageSize);
		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/system/menu/menu_list");
		return mv;
	}
	/*
	 * 查看父级菜单
	 * */
	@RequestMapping("/addMenuUI.do")
	public String AddUserUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Menu menu) {
		//准备父节点
		List<Menu> menuList = menuService.queryAllMenu();
		model.addAttribute("menuList", menuList);
		return "view/system/menu/menu_add";

	}
	/*
	 * 添加菜单信息
	 * */
	@RequestMapping("/addMenu.do")
	public String AddUser(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Menu menu, String pid) {
		System.err.println("前台传入的菜单:" + menu);
		System.out.println(pid);
		menu.setMenuPid(pid);
		menu.setMenuId(PrimaryKeyUtil.getPrimaryKey());
		int i = menuService.addMenu(menu);

		if (i == 0) {
			System.err.println("添加失败");
			return "redirect:/menuController/listPage.do";
		} else {
			System.err.println("添加成功");
			return "redirect:/menuController/listPage.do";
		}

	}
	/*
	 * 删除菜单
	 * */
	@RequestMapping("/deleteMenu.do")
	public String DeleteUser(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Menu menu, String menuId) {
		System.out.println("要删除的菜单的id" + menuId);

		int i = menuService.deleteMenuById(menuId);

		if (i == 0) {
			System.err.println("删除失败");
			return "redirect:/menuController/listPage.do";
		} else {
			System.err.println("删除成功");
			return "redirect:/menuController/listPage.do";
		}

	}
	/*
	 * 查看修改菜单的信息
	 * */
	@RequestMapping("/updateMenuUI.do")
	public String UpdateUserUI(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model, Menu menu, String menuId) {
		
		System.err.println("修改菜单ui");
		List<Menu> menuList = menuService.queryAllMenu();
		for (Menu menu2 : menuList) {
			System.out.println(menu2);
		}

		model.addAttribute("menuList", menuList);
		System.err.println("得到的菜单的id" + menuId);

		Menu m = menuService.queryMenuById(menuId);
		System.out.println(m);

		if (m == null) {
			System.err.println("查看失败");
			return "redirect:/menuController/listPage.do";
		} else {
			System.err.println("查看成功");
			model.addAttribute("m", m);
			return "view/system/menu/menu_update";
		}

	}
	/*
	 * 修改菜单
	 * */
	@RequestMapping("/updateMenu.do")
	public String UpdateUser(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Menu menu, String menuId) {
		System.out.println("查看修改菜单" + menu);

		int i = menuService.updateRoleByRole(menu);

		if (i == 0) {
			System.err.println("修改失败");
			return "redirect:/menuController/listPage.do";
		} else {
			System.err.println("修改成功");
			return "redirect:/menuController/listPage.do";
		}

	}
	/*
	 * 角色权限浏览
	 * */
	@RequestMapping("/fpMenuUI.do")
	public String fpMenuUI(HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model,Menu menu
		,String roleId) {
	
		Role role =roleService.queryRoleById(roleId);
		model.addAttribute("role", role);
		List<Menu> menuList=menuService.queryAllMenu();
		model.addAttribute("menuList",menuList);
		return "view/system/menu/menu_fp";
		
	}
	/*
	 * 角色权限分配
	 * */
	@RequestMapping("/fpMenu.do")
	public String fpRole(HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model,RoleMenu rolemenu
		,String roleId,String[] menuIds) {
		System.err.println(roleId);
		int z= roleMenuService.truncateMenu(roleId);
		 if (z > 0) {
				System.out.println("删除成功111");
			} else {
				System.out.println("删除失败1111");
			}
		for (String menuId : menuIds) {
			rolemenu.setRoleMenuId(PrimaryKeyUtil.getPrimaryKey());
			rolemenu.setMenuId(menuId);
			rolemenu.setRoleId(roleId);
			int i=roleMenuService.deleteByRoleMenu(rolemenu);
			if (i > 0) {
				System.out.println("删除成功");
			} else {
				System.out.println("删除失败");
			}
			 
			int j=roleMenuService.addRoleMenu(rolemenu);
			if (j > 0) {
				System.out.println("rolemenu添加成功");
			} else {
				System.out.println("rolemenu添加失败�");
			}
		}
		model.addAttribute("message", "完成分配");


		return "view/system/role/role_fp_success";
		
	}

}
