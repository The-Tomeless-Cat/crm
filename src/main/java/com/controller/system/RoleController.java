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

import com.model.system.Role;


import com.model.system.User;
import com.model.system.UserRole;


import framework.controller.BaseController;
import framework.utils.PrimaryKeyUtil;
import framework.utils.pageUtil.PagedResult;

@Controller
@RequestMapping("roleController")
public class RoleController extends BaseController{

	
	/**
	 * 角色查询，和分页
	 */
	private static final long serialVersionUID = 4105249690609689809L;
	@RequestMapping(value = "listPage.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
		System.err.println("角色列表.....");
		ModelAndView mv = new ModelAndView();
		
		PagedResult<Role> pageResult = roleService.getAllRoleByPage(pageNumber, pageSize);
	
		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/system/role/role_list");
		return mv;
	}
	/*
	 * 添加角色
	 * */
	@RequestMapping("/addRole.do")
	public String  AddUser(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Role role) {
		System.out.println("添加的角色"+role);
		role.setRoleId(PrimaryKeyUtil.getPrimaryKey());
		int i=roleService.addRole(role);
		
		
		if (i==0) {
			System.err.println("添加成功");
			return "redirect:/roleController/listPage.do";
			} else {
			System.err.println("添加成功");
			return "redirect:/roleController/listPage.do";
		}
		
		
	}
	/*
	 * 
	 * 删除角色
	 * */
	@RequestMapping("/deleteRole.do")
	public String  DeleteUser(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Role role,String roleId) {
		System.out.println("需要删除的角色的id"+roleId);
	
		int i=roleService.deleteRoleById(roleId);
		
		
		if (i==0) {
			System.err.println("删除成功");
			return "redirect:/roleController/listPage.do";
			} else {
			System.err.println("删除成功");
			return "redirect:/roleController/listPage.do";
		}
		
		
	}
	/*
	 * 显示修改角色的信息
	 * 
	 * */
	@RequestMapping("/updateRoleUI.do")
	public String  UpdateUserUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Role role,String roleId) {
	
		System.out.println("需要修改的角色的id"+roleId);
	
		Role r=roleService.queryRoleById(roleId);
		System.out.println(r);
		
		if (r==null) {
			System.err.println("查询失败");
			return "redirect:/roleController/listPage.do";
			} else {
			System.err.println("查询成功");
			model.addAttribute("role", r);
			return "view/system/role/role_update";
		}
	}
	
	/*
	 * 修改角色
	 * */
	@RequestMapping("/updateRole.do")
	public String  UpdateUser(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Role role,String roleId) {
		System.out.println("需要更新的角色"+role);
	
		int i=roleService.updateRoleByRole(role);
		
		
		if (i==0) {
			System.err.println("修改失败");
			return "redirect:/roleController/listPage.do";
			} else {
			System.err.println("修改成功");
			return "redirect:/roleController/listPage.do";
		}
		
		
	}
	/*
	 * 下拉框的角色信息
	 * */
	@RequestMapping("/fpRoleUI.do")
	public String fpRoleUI(HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model,Role role
		,String userId) {
		User user =userService.queryUserById(userId);
		model.addAttribute("user", user);
		List<Role> roleList=roleService.queryAllRole();
		model.addAttribute("roleList",roleList);
		return "view/system/role/role_fp";
		
	}
	/*
	 * 分配角色
	 * */
	@RequestMapping("/fpRole.do")
	public String fpRole(HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model,UserRole userrole
		,String userId,String[] roleIds) {
		for (String roleId : roleIds) {
			userrole.setUserRoleId(PrimaryKeyUtil.getPrimaryKey());
			userrole.setUserId(userId);
			userrole.setRoleId(roleId);
		
			int i=userRoleService.deleteByUserRole(userrole);
			if (i > 0) {
				System.out.println("删除成功");
			} else {
				System.out.println("删除失败");
			}

			int j=userRoleService.addUserRole(userrole);
			if (j > 0) {
				System.out.println("角色分配成功");
			} else {
				System.out.println("角色分配失败");
			}
		}
		model.addAttribute("message", "分配完成!");
		return "view/system/role/role_fp_success";
		
	
	}
}
