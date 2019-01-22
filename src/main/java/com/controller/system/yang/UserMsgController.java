package com.controller.system.yang;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.system.User;
import com.model.system.UserMsg;

import framework.controller.BaseController;
import framework.utils.PrimaryKeyUtil;
import framework.utils.pageUtil.PagedResult;

@SuppressWarnings("serial")
@Controller
@RequestMapping("userMsgController")
public class UserMsgController extends BaseController{
	@RequestMapping(value = "listPage.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
		System.out.println("用户信息收集.....");
		ModelAndView mv = new ModelAndView();

		PagedResult<UserMsg> pageResult = userMsgService.getAllUserMsgByPage(pageNumber, pageSize);

		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/system/userMsg/userMsg_list");
		return mv;
	}
	
		
		@RequestMapping("/addUserMsgUI.do")
		public String AddUserMsgUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
				UserMsg userMsg) {
			System.err.println("进来了");
			List<UserMsg> userMsgList = userMsgService.queryAllUserMsg();
			List<User>UserList = userService.queryAllUser();
			for (UserMsg userMsg2 : userMsgList) {
				System.err.println(userMsg2);
			}
			model.addAttribute("userMsgList", userMsgList);
			model.addAttribute("UserList",UserList);
			return "view/system/userMsg/userMsg_add";
		}
		@RequestMapping("/addUserMsg.do")
		public String AddProduct(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
				UserMsg userMsg,String userId) {
			System.err.println("前台传入的用户信息:" + userMsg);
			userMsg.setUserMsgId(PrimaryKeyUtil.getPrimaryKey());
		//	userMsg.setUserId(userId);
	
			int i = 	userMsgService.addUserMsg(userMsg);
			
			System.err.println("增加----------------------------");
			if (i == 0) {
				System.err.println("添加失败");
				return "redirect:/userMsgController/listPage.do";
			} else {
				System.err.println("添加成功");
				return "redirect:/userMsgController/listPage.do";
			}
		}
		
		@RequestMapping("/deleteUserMsg.do")
		public String DeleteProduct(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
				UserMsg userMsg, String userMsgId) {
			System.out.println("要删除的菜单的id" + userMsgId);

			int i = userMsgService.deleteUserMsgById(userMsgId);

			if (i == 0) {
				System.err.println("删除失败");
				return "redirect:/userMsgController/listPage.do";
			} else {
				System.err.println("删除成功");
				return "redirect:/userMsgController/listPage.do";
			}
		}
		
		@RequestMapping("/updateUserMsgUI.do")
		public String UpdateUserMsgIdUI(HttpServletRequest request, HttpServletResponse response, HttpSession session,
				Model model, UserMsg userMsg, String userMsgId) {
			
			System.err.println("修改产品ui");
			List<UserMsg> userMsgList = userMsgService.queryAllUserMsg();
			for (UserMsg userMsg2 : userMsgList) {
				System.out.println(userMsg2);
			}

			model.addAttribute("userMsgList", userMsgList);
			System.err.println("得到的菜单用户信息的id" + userMsgList);

			UserMsg u  = userMsgService.queryUserMsgById(userMsgId);
			System.out.println(u);

			if (u == null) {
				System.err.println("查询失败");
				return "redirect:/userMsgController/listPage.do";
			} else {
				System.err.println("查询成功");
				model.addAttribute("u", u);
				return "view/system/userMsg/userMsg_update";
			}
		}
		
		@RequestMapping("/updateUserMsg.do")
		public String UpdateUserMsg(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
				UserMsg userMsg, String userMsgId) {
			System.out.println("-----用户信息id-----" + userMsg);

			int i = userMsgService.updateUserMsgByUserMsg(userMsg);

			if (i == 0) {
				System.err.println("修改失败");
				return "redirect:/userMsgController/listPage.do";
			} else {
				System.err.println("修改成功");
				return "redirect:/userMsgController/listPage.do";
			}
		}
		@RequestMapping("/deleteUserMsgPL.do")
		public String deleteProductConllectPL(HttpServletRequest request, HttpServletResponse response, HttpSession session,
				Model model, UserMsg userMsg, String[] userMsgIds) {
			try{
			for (String userMsgId : userMsgIds) {
				System.err.println("-------deleteUserPL-----" + userMsgId);
				int i =  userMsgService.deleteUserMsgById(userMsgId);
				if (i > 0) {
					System.out.println("批量删除成功！");
				} else {
					System.out.println("批量删除失败！");
				}
			}
			}catch(Exception e){
				return"redirect:/userMsgController/listPage.do";
			}
			// 重定向
			return"redirect:/userMsgController/listPage.do";

		}
}
