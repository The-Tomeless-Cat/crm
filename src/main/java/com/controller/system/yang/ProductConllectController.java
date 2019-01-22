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

import com.model.system.ProductCollect;

import framework.controller.BaseController;
import framework.utils.PrimaryKeyUtil;
import framework.utils.pageUtil.PagedResult;

@Controller
@RequestMapping("productConllectController")
public class ProductConllectController extends BaseController {
	/**  */
	private static final long serialVersionUID = 1L;
	@RequestMapping(value = "listPage.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize) {
		System.out.println("产品列表.....");
		ModelAndView mv = new ModelAndView();

		PagedResult<ProductCollect> pageResult = productCollectService.getAllProductCollectByPage(pageNumber, pageSize);

		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/system/productcollect/productc_list");
		return mv;
	}
	
		
		@RequestMapping("/addProductUI.do")
		public String AddProductUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
				ProductCollect productCollect) {
			System.err.println("进来了");
			List<ProductCollect> productCollectList = productCollectService.queryAllproduct();
			for (ProductCollect productCollect2 : productCollectList) {
				System.err.println(productCollect2);
			}
			model.addAttribute("productCollectList", productCollectList);
			return "view/system/productcollect/productc_add";
		}

		@RequestMapping("/addProduct.do")
		public String AddProduct(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
				ProductCollect productCollect) {
			System.err.println("前台传入的菜单:" + productCollect);
			productCollect.setProductMsgId(PrimaryKeyUtil.getPrimaryKey());
	//	productCollect.setMarketTime(new Date());
			int i = 	productCollectService.addproductCollect(productCollect);
			
			System.err.println("增加----------------------------");
			if (i == 0) {
				System.err.println("添加失败");
				return "redirect:/productConllectController/listPage.do";
			} else {
				System.err.println("添加成功");
				return "redirect:/productConllectController/listPage.do";
			}
		}
		
		@RequestMapping("/deleteProduct.do")
		public String DeleteProduct(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
				ProductCollect productCollect, String productMsgId) {
			System.out.println("要删除的菜单的id" + productMsgId);

			int i = productCollectService.deleteProductById(productMsgId);

			if (i == 0) {
				System.err.println("删除失败");
				return "redirect:/productConllectController/listPage.do";
			} else {
				System.err.println("删除成功");
				return "redirect:/productConllectController/listPage.do";
			}
		}
		
		@RequestMapping("/updateProductUI.do")
		public String UpdateProductCollectUI(HttpServletRequest request, HttpServletResponse response, HttpSession session,
				Model model, ProductCollect productCollect, String productMsgId) {
			
			System.err.println("修改产品ui");
			List<ProductCollect> productCollectList = productCollectService.queryAllproduct();
			for (ProductCollect productCollect2 : productCollectList) {
				System.out.println(productCollect2);
			}

			model.addAttribute("productCollectList", productCollectList);
			System.err.println("得到的菜单的id" + productCollectList);

			ProductCollect p  = productCollectService.queryProductById(productMsgId);
			System.out.println(p);

			if (p == null) {
				System.err.println("查询失败");
				return "redirect:/productConllectController/listPage.do";
			} else {
				System.err.println("查询成功");
				model.addAttribute("p", p);
				return "view/system/productcollect/productc_update";
			}
		}
		
		@RequestMapping("/updateProduct.do")
		public String UpdateProduct(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
				ProductCollect productCollect, String productMsgId) {
			System.out.println("-----产品id-----" + productCollect);

			int i = productCollectService.updateProductCollectByProduct(productCollect);

			if (i == 0) {
				System.err.println("修改失败");
				return "redirect:/productConllectController/listPage.do";
			} else {
				System.err.println("修改成功");
				return "redirect:/productConllectController/listPage.do";
			}
		}
		@RequestMapping("/likeQuery.do")
		public ModelAndView likeQuery(HttpServletRequest request,HttpServletResponse response,HttpSession session, Model model,
				ProductCollect productCollect,String name){
			System.err.println("----------"+name+"==========");
			ModelAndView mv = new ModelAndView();
			PagedResult<ProductCollect> pageResult =  productCollectService.likeQuery(name);
			// 数据传递到前台页面展示层
			mv.addObject("pageResult", pageResult);
			mv.setViewName("view/system/productcollect/productc_list");
			System.out.println(mv);
			return mv;			
		}
		@RequestMapping("/productConllectPL.do")
		public String deleteProductConllectPL(HttpServletRequest request, HttpServletResponse response, HttpSession session,
				Model model, ProductCollect roductCollect, String[] productMsgIds) {
			try{
			for (String productMsgId : productMsgIds) {
				System.err.println("-------deleteUserPL-----" + productMsgId);
				int i =  productCollectService.deleteProductById(productMsgId);
				if (i > 0) {
					System.out.println("批量删除成功！");
				} else {
					System.out.println("批量删除失败！");
				}
			}
			}catch(Exception e){
				return"redirect:/productConllectController/listPage.do";
			}
			// 重定向
			return "redirect:/productConllectController/listPage.do";

		}
}
