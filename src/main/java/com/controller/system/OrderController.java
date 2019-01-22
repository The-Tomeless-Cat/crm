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

import com.model.system.Order;


import framework.controller.BaseController;
import framework.utils.PrimaryKeyUtil;
import framework.utils.pageUtil.PagedResult;

 
/**
 * @author 古家鑫 订单的增删改查
 *
 */
@SuppressWarnings("serial")
@Controller
@RequestMapping("orderController")
public class OrderController  extends BaseController {
	@RequestMapping(value = "listPage.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,Model model) {
		System.out.println("开始生成订单列表.....");
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		PagedResult<Order> pageResult = orderService.getAllOrderByPage(pageNumber, pageSize);
		// 数据传递到前台页面展示层
		model.addAttribute("message", "恭喜您，操作成功");
		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/system/order/order_list");
		return mv;
	}
	
	@RequestMapping("/deleteOrder.do")
	public String DeleteOrder(HttpServletRequest request, HttpServletResponse response, Model model,Order order) {
		// 1.收集数据
		System.out.println("----------" + order);
		// 2.处理业务
		String orderId=order.getOrderId();
		System.out.println("======"+orderId);
    int i= orderService.deleteOrder(orderId);
		
		if (i!=0) {
			// 跳转页面
			return "redirect:/orderController/listPage4.do";
		} else {
			model.addAttribute("message", "删除失败");
			return "redirect:/orderController/listPage2.do";
		}
	}
	
	@SuppressWarnings("static-access")
	@RequestMapping("/addOrder.do")
	public String AddUser(HttpServletRequest request, HttpServletResponse response, Model model, Order order) {
		// 1.收集数据
		System.out.println("----------" + order);
		// 2.处理业务
		order.setOrderId(new PrimaryKeyUtil().getPrimaryKey());
		order.setOrderCreatetime(new Date());
		
		int  i=orderService.addOrder(order);
		if (i!=0) {
			// 跳转页面
			return "redirect:/orderController/listPage.do";
		} else {
			model.addAttribute("message", "添加失败");
			return "redirect:/orderController/listPage2.do";
		}

	}
	
	@RequestMapping("/updateOrderUI.do")
	public String updateUserUI(HttpServletRequest request, HttpServletResponse response, Model model, Order order) {
		// 1.收集数据
		System.out.println("----------" + order);
		// 2.处理业务
		String orderId=order.getOrderId();
		Order o= orderService.selectOrderByOrderId(orderId);
		model.addAttribute("order", o);
		System.out.println(o);
		
		return "view/system/order/order_update";

	}
	
		@RequestMapping("/updateOrder.do")
		public String  UpdateUser(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Order order,String orderId) {
			System.out.println("修改后的用户"+order);
		
			int i=orderService.updateOrderByOrderId(order);
			
			
			if (i!=0) {
				System.err.println("修改失败");
				return "redirect:/orderController/listPage.do";
				} else {
				System.err.println("修改成功");
				return "redirect:/orderController/listPage2.do";
			}
			
			
		}
		@RequestMapping("/deleteOrderPL.do")
		public String deleteUserPL(HttpServletRequest request, HttpServletResponse response, HttpSession session,
				Model model, Order order, String[] orderids) {
			if(orderids!=null) {
			for (String orderId : orderids) {
				System.err.println("-------deleteUserPL-----" + orderId);
				int i = orderService.deleteOrderByOrderId(orderId);
				if (i > 0) {
					System.out.println("批量删除成功！");
				} else {
					System.out.println("批量删除失败！");
				}
			}
			// 重定向
			return "redirect:/orderController/listPage6.do";}
			else {
				return "redirect:/orderController/listPage5.do";
			}

		}


	
	@RequestMapping("/feedback.do")
	public String feedback(HttpServletRequest request, HttpServletResponse response, Model model,Order order) {
		// 1.收集数据
		System.out.println("----------" + order);
		// 2.处理业务
		String orderId=order.getOrderId();
		System.out.println("======"+orderId);
    int i= orderService.deleteOrder(orderId);
		
		if (i!=0) {
			// 跳转页面
			return "redirect:/orderController/listPage.do";
		} else {
			model.addAttribute("message", "删除失败");
			return "redirect:/orderController/listPage2.do";
		}

	}
	
	@RequestMapping(value = "listPage2.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage2(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,Model model) {
		System.out.println("开始生成订单列表2.....");
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		PagedResult<Order> pageResult = orderService.getAllOrderByPage(pageNumber, pageSize);
		// 数据传递到前台页面展示层
		model.addAttribute("message", "操作失败，请重新操作");
		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/system/order/order_list");
		return mv;
	}
	
	@RequestMapping(value = "listPage3.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage3(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,Model model) {
		System.out.println("开始生成订单列表3.....");
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		PagedResult<Order> pageResult = orderService.getAllOrderByPage(pageNumber, pageSize);
		// 数据传递到前台页面展示层
		model.addAttribute("message", "进入订单管理模块成功");
		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/system/order/order_list");
		return mv;
	}
	
	@RequestMapping(value = "listPage4.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage4(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,Model model) {
		System.out.println("开始生成订单列表.....");
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		PagedResult<Order> pageResult = orderService.getAllOrderByPage(pageNumber, pageSize);
		// 数据传递到前台页面展示层
		model.addAttribute("message", "删除成功");
		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/system/order/order_list");
		return mv;
	}
	
	
	@RequestMapping(value = "listPage5.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage5(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,Model model) {
		System.out.println("开始生成订单列表.....");
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		PagedResult<Order> pageResult = orderService.getAllOrderByPage(pageNumber, pageSize);
		// 数据传递到前台页面展示层
		model.addAttribute("message", "批量删除失败：未选择要删除的数据，请重新勾选");
		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/system/order/order_list");
		return mv;
	}
	
	@RequestMapping(value = "listPage6.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage6(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,Model model) {
		System.out.println("开始生成订单列表.....");
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		PagedResult<Order> pageResult = orderService.getAllOrderByPage(pageNumber, pageSize);
		// 数据传递到前台页面展示层
		model.addAttribute("message", "批量删除成功");
		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/system/order/order_list");
		return mv;
	}

}
