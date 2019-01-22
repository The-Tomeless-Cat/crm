package com.controller.other;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.model.other.OrderFeedback;
import com.model.system.Order;

import framework.controller.BaseController;
import framework.utils.PrimaryKeyUtil;
import framework.utils.pageUtil.PagedResult;

/*
 * 古家鑫
 */
@SuppressWarnings("serial")
@Controller
@RequestMapping("feedbackController")
public class FeedbcakController  extends BaseController {

	@RequestMapping(value = "listPage.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,Model model) {
		System.out.println("开始生成订单反馈表.....");
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		PagedResult<OrderFeedback> pageResult =feedbackService.getAllOrderFeedbackByPage(pageNumber, pageSize);
		// 数据传递到前台页面展示层
		model.addAttribute("message","恭喜您，操作成功");
		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/system/feedback/feedback_list");
		return mv;
	}
	
	
	@SuppressWarnings("static-access")
	@RequestMapping("/addOrderfeedback.do")
	public String addOrderfeedback(HttpServletRequest request, HttpServletResponse response, Model model,OrderFeedback orderFeedback) {
		// 1.收集数据
		System.out.println("----------" +orderFeedback);
		orderFeedback.setFeedbackCreatetime(new Date());
		orderFeedback.setFeedbackId(new PrimaryKeyUtil().getPrimaryKey());
		int i=feedbackService.addOrderFeedback(orderFeedback);
		if (i!=0) {
			// 跳转页面
			model.addAttribute("message", "提交反馈表成功，管理员会尽快与您联系");
			return "redirect:/feedbackController/listPage2.do";
		} else {
			model.addAttribute("message", "反馈失败，请联系管理员");
			return "redirect:/feedbackController/listPage2.do";
		}

	}
	@RequestMapping(value = "listPage2.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage2(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,Model model) {
		System.out.println("开始生成订单列表.....");
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		PagedResult<Order> pageResult = orderService.getAllOrderByPage(pageNumber, pageSize);
		// 数据传递到前台页面展示层
		model.addAttribute("message", "提交反馈表成功，管理员会尽快与您联系");
		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/buy/order_list");
		return mv;
	}
	
	
	@RequestMapping("/deletefeedback.do")
	public String DeleteFeedback(HttpServletRequest request, HttpServletResponse response, Model model,OrderFeedback orderFeedback) {
		// 1.收集数据
		System.out.println("----------" + orderFeedback);
		// 2.处理业务
		String orderFeedbackId=orderFeedback.getFeedbackId();
		System.out.println("======"+orderFeedbackId);
    int i= feedbackService.deletFeedbackByFeedbackId(orderFeedbackId);
		
		if (i!=0) {
			// 跳转页面
			return "redirect:/feedbackController/listPage.do";
		} else {
			model.addAttribute("message", "删除失败");
			return "redirect:/feedbackController/listPage.do";
		}

	}
	
	@RequestMapping("/deleteFeedbackPL.do")
	public String deleteUserPL(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model, OrderFeedback feedback, String[] feedbackids) {
		if(feedbackids!=null) {
		for (String feedbackId :feedbackids) {
			System.err.println("-------deleteUserPL-----" + feedbackId);
			int i = feedbackService.deleteFeedbackByFeedbackId(feedbackId);
			if (i > 0) {
				System.out.println("批量删除成功！");
			} else {
				System.out.println("批量删除失败！");
			}
		}
		// 重定向
		return "redirect:/feedbackController/listPage4.do";}
		else {
			return "redirect:/feedbackController/listPage5.do";
		}

	}

	
	@RequestMapping(value = "listPage3.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage3(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,Model model) {
		System.out.println("开始生成订单反馈表.....");
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		PagedResult<OrderFeedback> pageResult =feedbackService.getAllOrderFeedbackByPage(pageNumber, pageSize);
		// 数据传递到前台页面展示层
		model.addAttribute("message","进入反馈表管理模块成功");
		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/system/feedback/feedback_list");
		return mv;
	}

	@RequestMapping(value = "listPage4.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage4(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,Model model) {
		System.out.println("开始生成订单反馈表.....");
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		PagedResult<OrderFeedback> pageResult =feedbackService.getAllOrderFeedbackByPage(pageNumber, pageSize);
		// 数据传递到前台页面展示层
		model.addAttribute("message","批量删除成功");
		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/system/feedback/feedback_list");
		return mv;
	}

	@RequestMapping(value = "listPage5.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage5(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,Model model) {
		System.out.println("开始生成订单反馈表.....");
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		PagedResult<OrderFeedback> pageResult =feedbackService.getAllOrderFeedbackByPage(pageNumber, pageSize);
		// 数据传递到前台页面展示层
		model.addAttribute("message","批量删除失败：未选择要删除的数据，请重新勾选");
		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/system/feedback/feedback_list");
		return mv;
	}
	
	
	@RequestMapping(value = "listPage8.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage8(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,Model model,String name) {
		System.out.println("开始生成订单反馈表.....");
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		PagedResult<OrderFeedback> pageResult =  feedbackService.likeQuery(name);
		// 数据传递到前台页面展示层
		model.addAttribute("message","查询成功");
		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/system/feedback/feedback_list");
		return mv;
	}
	
}


