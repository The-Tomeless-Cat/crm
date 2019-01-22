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

import com.model.system.Activity;
import com.model.system.ActivityProduct;
import com.model.system.Product;

import framework.controller.BaseController;
import framework.utils.PrimaryKeyUtil;
import framework.utils.pageUtil.PagedResult;

@Controller
@RequestMapping("productController")
public class ProductController extends BaseController {
	/**  */
	private static final long serialVersionUID = 1L;

	@RequestMapping(value = "listPage.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
		System.out.println("开始生成角色列表.....");
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		PagedResult<Product> pageResult = productService.getAllProductByPage(pageNumber, pageSize);
		// 数据传递到前台页面展示层
		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/system/product/product_list");
		return mv;
	}

	@RequestMapping("/AddProduct.do")
	public String AddProduct(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Product product) {
		System.out.println("前台传入的product对象" + product);
		product.setProductId(PrimaryKeyUtil.getPrimaryKey());
		int i = productService.addProduct(product);

		if (i == 0) {
			System.err.println("添加失败");
			return "redirect:/productController/listPage.do";
		} else {
			System.err.println("添加成功");
			return "redirect:/productController/listPage.do";
		}
	}

	@RequestMapping("/deleteProduct.do")
	public String DeleteProduct(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model, Product product, String productId) {
		System.out.println("前台传入的对象的ID" + productId);

		int i = productService.deleteProductById(productId);

		if (i == 0) {
			System.err.println("删除失败");
			return "redirect:/productController/listPage.do";
		} else {
			System.err.println("删除成功");
			return "redirect:/productController/listPage.do";
		}

	}
	
	@RequestMapping("/updateProductUI.do")
	public String  UpdateProductUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Product product, String productId) {
		System.out.println("前台传入的用户id"+productId);
	
		Product p=productService.queryProductById(productId);
		System.out.println(p);
		
		if (p==null) {
			System.err.println("用户查找失败");
			return "redirect:/productController/listPage.do";
			} else {
			System.err.println("用户查找成功");
			model.addAttribute("product", p);
			return "view/system/product/product_update";
		}
		
		
	}
	@RequestMapping("/updateProduct.do")
	public String  updateProduct(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Product product, String productId) {
		System.out.println("修改后的用户"+productId);
	
		int i=productService.updateProductByProduct(product);
		
		
		if (i==0) {
			System.err.println("修改失败");
			return "redirect:/productController/listPage.do";
			} else {
			System.err.println("修改成功");
			return "redirect:/productController/listPage.do";
		}
	}

	
	@RequestMapping("/fpProductUI.do")
	public String fpProductUI(HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model,Product product
		,String activityId) {
		Activity activity =activityService.queryActivityIdById(activityId);
		model.addAttribute("activity", activity);
		List<Product> productList=productService.queryAllProduct();
		model.addAttribute("productList",productList);
		return "view/system/product/product_fp";
		
	}
	@RequestMapping("/fpProduct.do")
	public String fpProduct(HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model,ActivityProduct activityproduct
		,String activityId,String[] productIds) {
		for (String productId : productIds) {
			activityproduct.setActivityProductId(PrimaryKeyUtil.getPrimaryKey());
			activityproduct.setActivityId(activityId);
			activityproduct.setProductId(productId);
		
			int i=activityProductService.deleteByActivityProduct(activityproduct);
			if (i > 0) {
				System.out.println("删除成功");
			} else {
				System.out.println("删除失败");
			}

			int j=activityProductService.addActivityProduct(activityproduct);
			if (j > 0) {
				System.out.println("角色分配成功");
			} else {
				System.out.println("角色分配失败");
			}
		}
		model.addAttribute("message", "分配完成!");

		// ��ת�û�������
		return "view/system/product/product_fp_success";
		
	
	}
}
