package com.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.system.User;

import framework.controller.BaseController;

@Controller
@RequestMapping("grxxController")
public class GRXXController extends BaseController {

	/**  */
	private static final long serialVersionUID = 1L;

	@RequestMapping("queryGrxx.do")
	public String queryGrxx(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			User user) {
		user = (User) session.getAttribute("USER");
		System.err.println("+++++++++++++" + user);
		User u=userService.queryUserById(user.getUserId());
		model.addAttribute("user", u);
		model.addAttribute("message", "个人信息查看成功");
		return "view/system/deparment/grxx";

	}

	@RequestMapping("updateGrxx.do")
	public String updateGrxx(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			User user) {
		System.err.println("==============="+user);
		userService.updateUserByUser(user);
		User u=userService.queryUserById(user.getUserId());
		model.addAttribute("user", u);
		model.addAttribute("message", "个人修改成功");
		return "view/system/deparment/grxx";	
	}
}
