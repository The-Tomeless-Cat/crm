



package com.controller.system;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.system.User;
import com.model.system.UserRole;

import framework.controller.BaseController;
import framework.utils.PrimaryKeyUtil;
import framework.utils.pageUtil.PagedResult;

@Controller
@RequestMapping("userController")
public class UserController extends BaseController{

	
	/**
	 * 用户查询，加分页
	 */
	private static final long serialVersionUID = -7969251484231466238L;
	@RequestMapping(value = "listPage.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
		System.out.println("用户列表.....");
		ModelAndView mv = new ModelAndView();

		PagedResult<User> pageResult = userService.getAllUserByPage(pageNumber, pageSize);

		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/system/user/user_list");
		return mv;
	}
	
	/*
	 * 用户注册，以及默认角色为用户
	 * */
	@RequestMapping("/registerUser.do")
	public String  registerUser(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			User user) {
		System.out.println("前台传入的User对象"+user);
		String userId=PrimaryKeyUtil.getPrimaryKey();
		user.setUserId(userId);
		user.setCreateTime(new Date());
		int i=userService.addUser(user);	
		
		if (i==0) {
			System.err.println("注册失败");
			return "register";
			}
		else {
			System.err.println("注册成功");
			//默认分配角色
			UserRole userRole=new UserRole();
			userRole.setUserRoleId(PrimaryKeyUtil.getPrimaryKey());
			userRole.setUserId(userId);
			userRole.setRoleId("bba5a058-6243-412d-abc6-31a28e7a05d0");
			int j=userRoleService.addUserRole(userRole);
			System.err.println(userId);
			System.err.println(j);
			return "redirect:/loginController/login.do";
		}				
	}
	/*
	 * 用户
	 * */
	@RequestMapping("/addUser.do")
	public String  AddUser(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			User user) {
		System.out.println("前台传入的User对象"+user);
		user.setUserId(PrimaryKeyUtil.getPrimaryKey());
		user.setCreateTime(new Date());
		String password="111111";
		user.setLoginPassword(password);
		int i=userService.addUser(user);		
		if (i==0) {
			System.err.println("添加失败");
			return "redirect:/userController/listPage.do";
			} else {
			System.err.println("添加成功");
			return "redirect:/userController/listPage.do";

		}

	}
	/*
	 * 
	 * 删除某个用户
	 * */
	@RequestMapping("/deleteUser.do")
	public String  DeleteUser(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			User user,String userId) {
		System.out.println("前台传入的用户id："+userId);
	
		int i=userService.deleteUserById(userId);
		
		
		if (i==0) {
			System.err.println("删除失败");
			return "redirect:/userController/listPage.do";
			} else {
			System.err.println("删除成功");
			return "redirect:/userController/listPage.do";
		}		
	}
	/*
	 * 
	 * 查看需要修改的用户信息
	 * */
	@RequestMapping("/updateUserUI.do")
	public String  UpdateUserUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			User user,String userId) {
		System.out.println("前台传入的用户id"+userId);
	
		User u=userService.queryUserById(userId);
		System.out.println(u);
		
		if (u==null) {
			System.err.println("用户查找失败");
			return "redirect:/userController/listPage.do";
			} else {
			System.err.println("用户查找成功");
			model.addAttribute("user", u);
			return "view/system/user/user_update";
		}	
	}
	/*
	 * 修改用户信息
	 * */
	@RequestMapping("/updateUser.do")
	public String  UpdateUser(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			User user,String userId) {
		System.out.println("修改后的用户"+user);
	
		int i=userService.updateUserByUser(user);
				
		if (i==0) {
			System.err.println("修改失败");
			return "redirect:/userController/listPage.do";
			} else {
			System.err.println("修改成功");
			return "redirect:/userController/listPage.do";
		}
		
		
	}

}
