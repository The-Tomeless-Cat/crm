package com.controller.system.yang;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/LoginoutServlet")
public class LoginoutServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {				
		  HttpSession session = request.getSession();
		  //session.invalidate();//清除当前session的所有相关信息
		  session.removeAttribute("USER");
		  System.out.println("session:   "+session);
		  response.sendRedirect("login.jsp");

	} 	
	public void doPost(HttpServletRequest request, HttpServletResponse response)			
			throws ServletException, IOException {			
		doGet(request, response);	
		}	
	public void destroy(){		
			super.destroy();	
			}	
	public void init() throws ServletException{		}
}
