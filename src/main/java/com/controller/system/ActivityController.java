package com.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.system.Activity;

import framework.controller.BaseController;
import framework.utils.PrimaryKeyUtil;
import framework.utils.pageUtil.PagedResult;

@Controller
@RequestMapping("activityController")
public class ActivityController extends BaseController {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8849492484522712822L;
	@RequestMapping(value = "listPage.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
		System.out.println("开始生成列表.....");
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		PagedResult<Activity> pageResult = activityService.getAllActivityByPage(pageNumber, pageSize);
		// 数据传递到前台页面展示层
		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/system/activity/activity_list");
		return mv;
	}
	
	@RequestMapping("/deleteActivityPL.do")
	public String deleteUserPL(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model, Activity activity, String[] activityids) {
		for (String activityId : activityids) {
			System.err.println("-------deleteUserPL-----" + activityId);
			int i = activityService.deleteActivityByActivityId(activityId);
			if (i > 0) {
				System.out.println("批量删除成功！");
			} else {
				System.out.println("批量删除失败！");
			}
		}
		// 重定向
		return "redirect:/activityController/listPage.do";

	}

	@RequestMapping("/deleteActivity.do")
	public String  DeleteUser(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Activity activity,String activityId) {
		System.out.println("前台传入的user对象的ID"+activityId);
	
		int i=activityService.deleteActivityById(activityId);
		
		
		if (i==0) {
			System.err.println("删除失败");
			return "redirect:/activityController/listPage.do";
			} else {
			System.err.println("删除成功");
			return "redirect:/activityController/listPage.do";
		}
		
		
	}
	
	@RequestMapping("/addActivity.do")
	public String  AddActivity(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Activity activity) {
		System.out.println("前台传入的activity对象"+activity);
		activity.setActivityId(PrimaryKeyUtil.getPrimaryKey());
		int i=activityService.addActivity(activity);
		if (i==0) {
			System.err.println("添加失败");
			return "redirect:/activityController/listPage.do";
			} else {
			System.err.println("添加成功");
			return "redirect:/activityController/listPage.do";
		}
		
		
	}

	@RequestMapping("/updateActivityUI.do")
	public String  updateActivityUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Activity activity,String activityId) {
		System.out.println("前台传入的user对象的ID"+activityId);
	
		Activity ac=activityService.queryActivityById(activityId);
		System.out.println(ac);
		
		if (ac==null) {
			System.err.println("用户查询失败");
			return "redirect:/activityController/listPage.do";
			} else {
			System.err.println("用户查询成功");
			model.addAttribute("activity", ac);
			return "view/system/activity/activity_update";
		}
		
		
	}
	@RequestMapping("/updateActivity.do")
	public String  updateActivity(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Activity activity,String activityId) {
		System.out.println("更新界面前台传入的user对象"+activity);
	
		int i=activityService.updateActivityByActivity(activity);
		
		
		if (i==0) {
			System.err.println("修改失败");
			return "redirect:/activityController/listPage.do";
			} else {
			System.err.println("修改成功");
			return "redirect:/activityController/listPage.do";
		}
		
	}
	
	
}

