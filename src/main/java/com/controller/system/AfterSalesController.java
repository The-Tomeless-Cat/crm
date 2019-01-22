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

import com.model.system.AfterSales;
import com.model.system.Order;
import com.model.system.User;

import framework.controller.BaseController;
import framework.utils.PrimaryKeyUtil;
import framework.utils.pageUtil.PagedResult;

@SuppressWarnings("serial")
@Controller
@RequestMapping("afterSalesController")
public class AfterSalesController extends BaseController {
	@RequestMapping(value = "orderlist.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
		ModelAndView mv = new ModelAndView();
		PagedResult<Order> pageResult = afterSalesService.getAllOrder(pageNumber, pageSize);
		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/system/aftersales/aftersales_order");
		return mv;
	}

	@RequestMapping("/aftersales.do")
	public String AddUserUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			AfterSales aftersales, String orderId) {
		Order o = afterSalesService.getOrderByOrderId(orderId);
		model.addAttribute("order", o);
		String userId = o.getUserId();
		User uu = afterSalesService.getUserByUserId(userId);
		System.out.println(uu);
		model.addAttribute("huuser", uu);
		return "view/system/aftersales/aftersales_add";
	}

	@RequestMapping("/aftersalesadd.do")
	public String addUser(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			AfterSales aftersales) {

		aftersales.setAfterSalesId(PrimaryKeyUtil.getPrimaryKey());
		aftersales.setAfterSalesCreateTime(new Date());
		User u = (User) session.getAttribute("USER");
		aftersales.setWaiterId(u.getUserId());
		int i = afterSalesService.add(aftersales);
		if (i != 0) {
			return "redirect:/afterSalesController/orderlist.do";
		} else {
			model.addAttribute("message", "操作失败");
			return "redirect:/afterSalesController/orderlist.do";
		}
	}

	@RequestMapping("/aftersaleslist.do")
	public ModelAndView aftersaleslist(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
		ModelAndView mv = new ModelAndView();
		PagedResult<AfterSales> pageResult = afterSalesService.queryAll(pageNumber, pageSize);
		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/system/aftersales/aftersales_list");
		return mv;
	}

	@RequestMapping("/aftersalesupdateUI.do")
	public String aftersalesupdateUI(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model, AfterSales aftersales, String afterSalesId) {
		aftersales = afterSalesService.querybyafterSalesId(afterSalesId);
		model.addAttribute("aftersales", aftersales);
		if (aftersales == null) {
			return "redirect:/afterSalesController/aftersaleslist.do";
		} else {
			return "view/system/aftersales/aftersales_update";
		}
	}

	@RequestMapping("/aftersalesupdate.do")
	public String aftersalesupdate(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model, AfterSales aftersales, String afterSalesId) {
		int a = afterSalesService.afterSalesUpdate(aftersales);
		if (a == 0) {
			return "redirect:/afterSalesController/aftersaleslist.do";
		} else {
			return "redirect:/afterSalesController/aftersaleslist.do";
		}
	}

	@RequestMapping("aftersalesdelete.do")
	public String aftersalesdelete(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model, AfterSales aftersales, String afterSalesId) {
		int a = afterSalesService.afterSalesDelete(afterSalesId);
		if (a == 0) {
			return "redirect:/afterSalesController/aftersaleslist.do";
		} else {
			return "redirect:/afterSalesController/aftersaleslist.do";
		}
	}

	@RequestMapping("deleteRolePL.do")
	public String deleteRolePL(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model, AfterSales aftersales, String afterSalesId, String[] afterSalesIds) {
		for (String sid: afterSalesIds) {
			System.err.println(sid);
			 int a =afterSalesService.afterSalesDelete(sid);
			 if(a==0) {
				 System.err.println("删除失败");
			 }else {
				 System.err.println("删除成功");
			 }
		}
		return "redirect:/afterSalesController/aftersaleslist.do";
	}
}
