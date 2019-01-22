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

import com.model.other.PriceList;

import framework.controller.BaseController;
import framework.utils.PrimaryKeyUtil;
import framework.utils.pageUtil.PagedResult;

@SuppressWarnings("serial")
@Controller
@RequestMapping("pricelistController")
public class PricelistController extends BaseController {

	@RequestMapping(value = "listPage.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, Model model) {
		System.out.println("开始生成订单反馈表.....");
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		PagedResult<PriceList> pageResult = priceListService.getAllPriceListByPage(pageNumber, pageSize);
		// 数据传递到前台页面展示层
		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/system/price/price_list");
		model.addAttribute("message", "操作成功");
		return mv;
	}

	@RequestMapping("/deletePricelist.do")
	public String DeleteOrder(HttpServletRequest request, HttpServletResponse response, Model model,
			PriceList priceList) {
		// 1.收集数据
		System.out.println("----------" + priceList);
		// 2.处理业务
		String priceListId = priceList.getPriceListId();
		System.out.println("======" + priceListId);
		int i = priceListService.deletePricelist(priceListId);

		if (i != 0) {
			// 跳转页面
			return "redirect:/pricelistController/listPage.do";
		} else {
			model.addAttribute("message", "删除失败");
			return "redirect:/pricelistController/listPage.do";
		}
	}
	
	@RequestMapping("/deletePricelistPL.do")
	public String deletePricelistPL(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model, PriceList pricelist, String[] pricelists) {
		if(pricelists!=null) {
		for (String pricelistId : pricelists) {
			System.err.println("-------deleteUserPL-----" + pricelistId);
			int i = priceListService.deletePriceListByPriceListId(pricelistId);
			if (i > 0) {
				System.out.println("批量删除成功！");
			} else {
				System.out.println("批量删除失败！");
			}
		}
		// 重定向
		return "redirect:/pricelistController/listPage4.do";}
		else {
			return "redirect:/pricelistController/listPage5.do";
		}

	}

	@RequestMapping("/addPricelist.do")
	public String AddUser(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			PriceList priceList) {
		int i = 0;
		int unitprice = Integer.parseInt(priceList.getProductUnitPrice());
		int sellingprice = Integer.parseInt(priceList.getProductSellingPrice());
		if (unitprice < sellingprice) {
			priceList.setPriceListId(PrimaryKeyUtil.getPrimaryKey());
			priceList.setProductListCreatetime(new Date());
			i = priceListService.addPricelist(priceList);
			if (i != 0) {
				System.err.println("添加成功");
				return "redirect:/pricelistController/listPage.do";
			} else {

				System.out.println("操作失败，售价低于进价，请重新添加");
				return "redirect:/pricelistController/listPage2.do";
			}
		} else {
			System.out.println("操作失败，售价低于进价，请重新添加");
			return "redirect:/pricelistController/listPage2.do";
		}

	}

	@RequestMapping(value = "listPage2.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage2(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, Model model) {
		System.out.println("开始生成订单反馈表2.....");
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		PagedResult<PriceList> pageResult = priceListService.getAllPriceListByPage(pageNumber, pageSize);
		// 数据传递到前台页面展示层
		model.addAttribute("message", "操作失败，售价低于进价，请重新操作");
		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/system/price/price_list");

		return mv;
	}

	@RequestMapping("/updatePricelistUI.do")
	public String updateUserUI(HttpServletRequest request, HttpServletResponse response, Model model,
			PriceList priceList) {
		// 1.收集数据
		System.out.println("----------" + priceList);
		// 2.处理业务
		String priceListId = priceList.getPriceListId();
		PriceList p = priceListService.selectPriceListIdByPriceListId(priceListId);
		model.addAttribute("PriceList", p);
		System.out.println(p);

		return "view/system/price/price_update";

	}

	@RequestMapping("/updatePricelist.do")
	public String UpdateUser(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			PriceList priceList, String pricelistId) {
		System.out.println("修改后的报价单信息" + priceList);

		int i = 0;
		int unitprice = Integer.parseInt(priceList.getProductUnitPrice());
		int sellingprice = Integer.parseInt(priceList.getProductSellingPrice());
		if (unitprice < sellingprice) {
			i = priceListService.updateBypriceList(priceList);
			System.out.println(i);
			if (i == 0) {
				System.err.println("修改失败");
				return "redirect:/pricelistController/listPage.do";
			} else {
				System.err.println("修改成功");
				return "redirect:/pricelistController/listPage.do";
			}
		}else {
			System.out.println("操作失败，售价低于进价，请重新操作");
			return "redirect:/pricelistController/listPage2.do";
		}
		

	}
	@RequestMapping(value = "listPage3.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage3(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, Model model) {
		System.out.println("开始生成订单反馈表.....");
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		PagedResult<PriceList> pageResult = priceListService.getAllPriceListByPage(pageNumber, pageSize);
		// 数据传递到前台页面展示层
		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/system/price/price_list");
		model.addAttribute("message", "进入报价单管理模块成功");
		return mv;
	}
	
	@RequestMapping(value = "listPage4.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage4(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, Model model) {
		System.out.println("开始生成订单反馈表.....");
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		PagedResult<PriceList> pageResult = priceListService.getAllPriceListByPage(pageNumber, pageSize);
		// 数据传递到前台页面展示层
		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/system/price/price_list");
		model.addAttribute("message", "批量删除成功");
		return mv;
	}

	@RequestMapping(value = "listPage5.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage5(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, Model model) {
		System.out.println("开始生成订单反馈表.....");
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		PagedResult<PriceList> pageResult = priceListService.getAllPriceListByPage(pageNumber, pageSize);
		// 数据传递到前台页面展示层
		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/system/price/price_list");
		model.addAttribute("message", "批量删除失败：未选择要删除的数据，请重新勾选");
		return mv;
	}

}
