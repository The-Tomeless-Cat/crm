package com.controller.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.system.Menu;
import com.model.system.User;

import framework.controller.BaseController;

/**
 * @author 许龙
 * @Date:2019年1月217日
 */
@Controller
@RequestMapping("loginController")
public class LoginController extends BaseController {
	
	private static final long serialVersionUID = 1L;

	@RequestMapping("/login.do")
	public String login(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			User user) {
		//获取前台的验证码并进行比对
		String verificationCode = (String)session.getAttribute("verificationCode");
		String checkcode = request.getParameter("checkcode");
		if(verificationCode.equals(checkcode)) {
			
			//获取登陆信息与数据库对比
			System.err.println("这是前台传的信息："+user);
			User u = userService.queryUserByAccountAndPassword(user);
			if (u != null) {
				session.setAttribute("USER", u);
				// 查询菜单
				String userId = u.getUserId();
				List<Menu> menuList = menuService.queryMenuByUserId(userId);
				for (Menu menu2 : menuList) {
					System.err.println("---3-----"+menu2.getMenuName());
				}
				model.addAttribute("menuList", menuList); 
				// 跳转页面
				return "view/frame/main";
			} else {
				//登陆信息错误,跳回登陆页面
				model.addAttribute("message", "账号密码错误，请重新输入！");
				return "login";
			}
		}else {
			model.addAttribute("message", "验证码输入错误，请重新输入！");
			return "login";
		}
	}

	@RequestMapping("/queryMenuSon.do")
	public String queryMenuSon(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model, User user, Menu menu, String menuId) {

		User u = (User) session.getAttribute("USER");
		if (u != null) {
			session.setAttribute("USER", u);

			// --->查询菜单儿子
			List<Menu> menuSonList = menuService.queryMenuSonByMenuId(menuId);
			model.addAttribute("menuSonList", menuSonList);

			// 查询菜单
			String userId = u.getUserId();
			List<Menu> menuList = menuService.queryMenuByUserId(userId);
			model.addAttribute("menuList", menuList);

			model.addAttribute("message", "恭喜你，登录成功！");
			// 2、跳转页面
			return "view/frame/main";
		} else {
			model.addAttribute("message", "账号密码错误，请重新输入！");
			// 2、跳转页面
			return "login";
		}
	}
	
	
	//验证码的生成
	@RequestMapping("/productCheck.do")
	public void productCheck(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		BufferedImage bfi = new BufferedImage(100,40,BufferedImage.TYPE_INT_RGB);
		Graphics g = bfi.getGraphics();
		g.fillRect(0, 0, 100, 40);
		System.err.println("验证码图片生成");
		//验证码字符范围
		char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
		Random r = new Random(); 
		int index;  
		StringBuffer sb = new StringBuffer(); //保存字符串
		for(int i=0; i<4; i++){
			index = r.nextInt(ch.length);
			g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
			Font font = new Font("宋体", 30, 20);
			g.setFont(font);
			g.drawString(ch[index]+"", (i*20)+2, 23);
			sb.append(ch[index]);
		}
		
		// 添加噪点
	    int area = (int) (0.02 * 100 * 40);
	    for(int i=0; i<area; ++i){
	        int x = (int)(Math.random() * 100);
	        int y = (int)(Math.random() * 40);
	        bfi.setRGB(x, y, (int)(Math.random() * 255));
	    }
		
	  //设置验证码中的干扰线
	    for (int i = 0; i < 6; i++) {  
		      //随机获取干扰线的起点和终点
		      int xstart = (int)(Math.random() * 100);
		      int ystart = (int)(Math.random() * 40);
		      int xend = (int)(Math.random() * 100);
		      int yend = (int)(Math.random() * 40);
		      g.setColor(interLine(1, 255));
		      g.drawLine(xstart, ystart, xend, yend);
		    }
	    session = request.getSession();  //保存到session
		session.setAttribute("verificationCode", sb.toString());
		ImageIO.write(bfi, "JPG", response.getOutputStream());  //写到输出流
	}
	
	/**
	   * 获取随机的颜色值，r,g,b的取值在Low到High之间
	   * @param L 左区间
	   * @param R 右区间
	   * @return 返回随机颜色值
	   */
	private static Color interLine(int Low, int High){
	    if(Low > 255)
	    	Low = 255;
	    if(High > 255)
	    	High = 255;
	    if(Low < 0)
	    	Low = 0;
	    if(High < 0)
	    	High = 0;
	    int interval = High - Low; 
	    int r = Low + (int)(Math.random() * interval);
	    int g = Low + (int)(Math.random() * interval);
	    int b = Low + (int)(Math.random() * interval);
	    return new Color(r, g, b);
	  }
}
