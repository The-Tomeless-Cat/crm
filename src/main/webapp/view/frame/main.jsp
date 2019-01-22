<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>后台管理中心</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
</head>
<body style="background-color: #f2f9fd;">
	<div class="header bg-main">
		<div class="logo margin-big-left fadein-top">
			<h1>
				<img src="images/y.jpg" class="radius-circle rotate-hover"
					height="50" alt="" />第五组 CRM系统   
					&nbsp;欢迎<font color="yellow">${USER.userName }</font>光临！

			</h1>
		</div>
		<div class="head-l">

			<a class="button button-little bg-green" href="<%=basePath%>view/frame/info.jsp"  target="right">
			<span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp; &nbsp;&nbsp;
			<a class="button button-little bg-red" href="<%=basePath%>LoginoutServlet"><span class="icon-power-off"></span> 退出登录</a>
		</div>
		
		</div>
		
	<div class="leftnav">
		<div class="leftnav-title">
			<strong><span class="icon-list"></span>菜单列表</strong>
		</div>

		<!--  <h2>
			<span class="icon-user"></span>基本设置
		</h2>
		<ul style="display: block">
			<li><a href="<%=basePath%>userController/listPage.do"
				target="right"><span class="icon-caret-right"></span>用户管理</a></li>
			<li><a href="<%=basePath%>roleController/listPage.do"
				target="right"><span class="icon-caret-right"></span>角色管理</a></li>
			<li><a href="<%=basePath%>menuController/listPage.do"
				target="right"><span class="icon-caret-right"></span>菜单管理</a></li>
			<li><a href="<%=basePath%>activityController/listPage.do"
				target="right"><span class="icon-caret-right"></span>活动测试</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>栏目管理
		</h2>
		<ul style="display: block">
			<li><a href="<%=basePath%>productController/listPage.do"
				target="right"><span class="icon-caret-right"></span>产品管理</a></li>
			<li><a href="add.html" target="right"><span
					class="icon-caret-right"></span>添加内容</a></li>
			<li><a href="cate.html" target="right"><span
					class="icon-caret-right"></span>分类管理</a></li>
			<li><a href="<%=basePath%>orderController/listPage3.do"
				target="right"><span class="icon-caret-right"></span>订单管理</a></li>
			<li><a href="<%=basePath%>feedbackController/listPage3.do"
				target="right"><span class="icon-caret-right"></span>反馈表管理</a></li>
			<li><a href="<%=basePath%>pricelistController/listPage3.do"
				target="right"><span class="icon-caret-right"></span>报价单管理</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>许龙
		</h2>
		<ul>
			<li><a href="<%=basePath%>afterSalesController/orderlist.do"
				target="right"><span class="icon-caret-right"></span>订单查询</a></li>
			<li><a href="<%=basePath%>productConllectController/listPage.do"
				target="right"><span class="icon-caret-right"></span>产品信息</a></li>
			<li><a href="<%=basePath%>userMsgController/listPage.do"
				target="right"><span class="icon-caret-right"></span>用户信息收集</a></li>
			<li><a
				href="<%=basePath%>afterSalesController/aftersaleslist.do"
				target="right"><span class="icon-caret-right"></span>售后服务表</a></li>
			<li><a
				href="<%=basePath%>grxxController/queryGrxx.do"
				target="right"><span class="icon-caret-right"></span>个人信息</a></li>
		</ul>
       </ul>
    

		
		<h2>
			<span class="icon-pencil-square-o"></span>功能管理
		</h2>
		<ul style="display: block">
			<li><a href="<%=basePath%>userproductController/listPage.do"
				target="right"><span class="icon-caret-right"></span>产品</a></li>
			<li><a href="<%=basePath%>userproductController/listPage3.do"
				target="right"><span class="icon-caret-right"></span>订单</a></li>
		</ul>-->



		<c:forEach items="${menuList }" var="menu1">
			<!-- 1.第一层显示条件 -->
			<c:if test="${menu1.menuPid=='root'}">
				<h2><span class="icon-user"></span><a href="<%=basePath%>loginController/queryMenuSon.do?menuId=${menu1.menuId}">${menu1.menuName }</a></h2>
				<!-- 2.第二层循环 -->
				<c:forEach items="${menuSonList }" var="menu2">
					<!-- 2.第二层显示条件 -->
					<c:if test="${menu1.menuId==menu2.menuPid}">
					
						<ul style="display: block">
							<li><a href="${menu2.menuUrl}" target="right"
								<c:if test="${menu2.menuId==menu2.menuPid}"/>><span
									class="icon-caret-right"></span> ${menu2.menuName }</a></li>
						</ul>
					</c:if>
				</c:forEach>
			</c:if>
		</c:forEach>
		
	</div>
	<script type="text/javascript">
		$(function() {
			$(".leftnav h2").click(function() {
				$(this).next().slideToggle(200);
				$(this).toggleClass("on");
			})
			$(".leftnav ul li a").click(function() {
				$("#a_leader_txt").text($(this).text());
				$(".leftnav ul li a").removeClass("on");
				$(this).addClass("on");
			})
		});
	</script>
	<ul class="bread">
		<li><a href="<%=basePath%>view/frame/info.jsp" target="right" class="icon-home"> 首页</a></li>
		<li><b>当前语言：</b><span style="color: red;">中文</span>
	</ul>
	<div class="admin">
		<iframe scrolling="auto" src="<%=basePath%>view/frame/info.jsp" name="right" width="100%"
			height="100%"></iframe>
	</div>

</body>
</html>