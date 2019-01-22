package com.controller.system;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.model.system.Kbm;

import framework.controller.BaseController;
import framework.utils.pageUtil.PagedResult;


/**
 * <p>
 * 
 * </p>	
 * @Copyright (C),华清远见
 * @author 吴俊霖
 * @Date:2018年9月29日
 */
@Controller
@RequestMapping("kbmController")
public class kbmController extends BaseController{

	/**  */
	private static final long serialVersionUID = 1779049930059926932L;

	@RequestMapping(value = "listPage.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize) {
		System.out.println("---------------------------------------");
		ModelAndView mv = new ModelAndView();
		System.out.println("kbm列表.....");
		PagedResult<Kbm> pageResult = kbmService.getAllKbmByPage(pageNumber, pageSize);
		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/system/kbm/kbm_list");
		return mv;
	}
	
	@RequestMapping("/deleteKbmPL.do")
	public String deleteRolePL(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model, Kbm kbm, String[] kbmids) {
		for (String kbmId : kbmids) {
			// 调用业务层
			int i = kbmService.deleteKbmrById(kbmId);/*deleteRoleById(roleId)ById(kbmId);*/
			if (i > 0) {
				System.out.println("删除成功！");
			} else {
				System.out.println("删除失败！");
			}

		}

		return "redirect:/kbmController/listPage.do";
	}
	//kbmController/addKbm.do

	@RequestMapping("/addKbm.do")
	public String  AddUser(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Kbm kbm) {
		System.err.println("前台传入的Kbm对象"+kbm);
		
		int i=kbmService.addKbm(kbm);
		if (i==0) {
			System.err.println("添加失败");
			return "redirect:/kbmController/listPage.do";
			} else {
			System.err.println("添加成功");
			return "redirect:/kbmController/listPage.do";
		}
	}
	//deleteUser.do
	@RequestMapping("/deleteKbm.do")
	public String  DeleteUser(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Kbm kbm,int kbmId) {
	System.err.println("前台传入的Kbm对象id"+kbmId);
		int i=kbmService.deleteKbmrById(kbmId);
		System.err.println(i);
		if (i==0) {
			System.err.println("删除成功");
			return "redirect:/kbmController/listPage.do";
			} else {
			System.err.println("删除失败");
			return "redirect:/kbmController/listPage.do";
		}
	}
	@RequestMapping("/updateKbmUI.do")
	public String  updateKbmUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Kbm kbm,int kbmId) {
		System.out.println("前台传入的用户id"+kbmId);
	
		 kbm=kbmService.queryKbmById(kbmId);
		System.out.println(kbmId);
		
		if (kbm==null) {
			System.err.println("kbm查找失败");
			return "redirect:/kbmController/listPage.do";
			} else {
			System.err.println("kbm查找成功");
			model.addAttribute("kbm", kbm);
			return "view/system/kbm/kbm_update";
		}
		
		
	}
	@RequestMapping("/updateKbm.do")
	public String  UpdateUser(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Kbm kbm,int kbmId) {
		kbm.setId(kbmId);
		System.err.println(kbm+"-------------------");
		System.out.println("修改后的用户"+kbmId);
	model.addAttribute("kbmId", kbmId);
		int i=kbmService.updateKbmByKbm(kbm);
		System.err.println(i+"12345645");
		if (i==0) {
			System.err.println("修改失败");
			return "redirect:/kbmController/listPage.do";
			} else {
			System.err.println("修改成功");
			return "redirect:/kbmController/listPage.do";
		}
		
	
}
}
