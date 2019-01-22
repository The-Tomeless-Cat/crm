package com.controller.buy;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.buy.OrderProduct;
import com.model.system.Order;
import com.model.system.Product;
import com.model.system.User;

import framework.controller.BaseController;
import framework.utils.PrimaryKeyUtil;
import framework.utils.pageUtil.PagedResult;

@Controller
@RequestMapping("userproductController")
public class UserProductController extends BaseController {
	/**  */
	private static final long serialVersionUID = 1L;

	@RequestMapping(value = "listPage.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
		
		ModelAndView mv = new ModelAndView();
		
		PagedResult<Product> pageResult = productService.getAllProductByPage(pageNumber, pageSize);

		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/buy/product_list");
		return mv;
	}
/*	@RequestMapping("/buyProductUI")
	public String buyProductUI(HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model,OrderProduct orderProduct
			,String[] productIds,String[] productAmounts) {
		model.addAttribute("productIds", productIds);
		model.addAttribute("productAmounts", productAmounts);
		return "view/buy/";
		
	}*/
	
	
	
	
	
	@RequestMapping("/buyproduct.do")
	public String fpRole(HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model,OrderProduct orderProduct
		,String[] productIds,String[] productAmounts) {
		//1.向订单表中添加订单
		Order order=new Order();
		int orderTotal=0;
		String orderId=PrimaryKeyUtil.getPrimaryKey();
		order.setOrderId(orderId);
		
		User user = (User) session.getAttribute("USER");
		if(user==null) {
			System.err.println("得不到用户");
		}
		order.setUserId(user.getUserId());
		order.setOrderCreatetime(new Date());
		order.setOrderType("网购");
		order.setOrderState("已付款");
		if(productIds==null) {
			System.err.println("得不到产品id");
		}
		//向订单产品表中添加订单产品
		for (int i = 0; i < productIds.length; i++) {
			orderProduct.setOrderProductId(PrimaryKeyUtil.getPrimaryKey());
			orderProduct.setProductIds(productIds[i]);
			//写错类型了==、
			int productAmount=Integer.parseInt(productAmounts[i]);   
			System.out.println("productAmount+"+productAmount);
			
			orderProduct.setProductAmount(productAmount);
		//修改产品表中的库存
			Product product=productService.queryProductById(productIds[i]);
			int oldProductAmount=Integer.parseInt(product.getPruductKucun());
			System.out.println("oldProductAmount+"+oldProductAmount);
			
			int newProductAmount=oldProductAmount-productAmount;
			System.out.println("newProductAmount+"+newProductAmount);
			
			String newPruductKucun=Integer.toString(newProductAmount);  
			System.out.println("newPruductKucun+"+newPruductKucun);
			product.setPruductKucun(newPruductKucun);
			productService.updateProductByProduct(product);
			//计算总价
			int productmoney=Integer.parseInt(product.getProductMoney());
			orderTotal+=productAmount*productmoney;
			
		}
		System.err.println(orderTotal);
		String orderTotalStr=orderTotal+"元";
		order.setOrderTotal(orderTotalStr);
			orderService.addOrder(order);
		
		return "redirect:/userproductController/listPage2.do";
	}

	
		@RequestMapping(value = "listPage2.do", produces = "application/json;charset=utf-8")
		public ModelAndView listPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
				@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,HttpSession session,Model model) {
			System.out.println("开始生成订单列表.....");
			ModelAndView mv = new ModelAndView();
			
			User user = (User) session.getAttribute("USER");
		
			String userid=user.getUserId();
			System.err.println(userid);
			// 当前页和每页的条数
			// 传入数据到分页工具类
			PagedResult<Order> pageResult = orderService.getAllOrderByPageAndUserid(pageNumber, pageSize,userid);
			// 数据传递到前台页面展示层
			model.addAttribute("message", "购买成功");
			mv.addObject("pageResult", pageResult);
			mv.setViewName("view/buy/order_list");
			return mv;
		}
		
		@RequestMapping(value = "listPage3.do", produces = "application/json;charset=utf-8")
		public ModelAndView listPage3(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
				@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,HttpSession session,Model model) {
			System.out.println("开始生成订单列表.....");
			ModelAndView mv = new ModelAndView();
			
			User user = (User) session.getAttribute("USER");
		
			String userid=user.getUserId();
			System.err.println(userid);
			// 当前页和每页的条数
			// 传入数据到分页工具类
			PagedResult<Order> pageResult = orderService.getAllOrderByPageAndUserid(pageNumber, pageSize,userid);
			// 数据传递到前台页面展示层
			model.addAttribute("message", "进入用户订单管理界面成功");
			mv.addObject("pageResult", pageResult);
			mv.setViewName("view/buy/order_list");
			return mv;
		}
		
}
