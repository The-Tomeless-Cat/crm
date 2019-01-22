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
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<%-- 分页相关 --%>
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/kkpager/jpager.js"></script>
  <script type="text/javascript"src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
   <script type="text/javascript"src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/kkpager/jpager.css">
<script type="text/javascript"
	src="<%=basePath%>view/system/productcollect/listPage.js"></script>
<script type="text/javascript">
        function load() {
        	arrayPage(${pageResult.pages},${pageResult.total});
        }
</script>
</head>
<body onload="load()">
<form action="<%=basePath%>productConllectController/likeQuery.do"
							method="post" style="margin-left:250px">
						<input type="text" class="input w50" value="" name="name" placeholder="请输入产品名关键字查询"/>
  						<input type="submit" value="查询" class="input w50"style="width:50px;">								
						<div class="tips"></div>							
						</form><br><br><br><br>
	<form method="post"
		action="<%=basePath%>productConllectController/productConllectPL.do">
		<div class="panel admin-panel">
			<!-- <div class="panel-head">
				<strong class="icon-reorder"> 产品收集</strong>
			</div> -->
			<div class="padding border-bottom">
				<ul class="search">
					<li>
					
					<button type="button" class="button border-green" id="checkall">
							<span class="icon-check"></span> 全选
						</button> 
						<!-- 批量删除 --> 						
						<input type="submit" class="button border-red" onclick="DelSelect()"
						value="批量删除">
						
					<a
						href="<%=basePath%>productConllectController/addProductUI.do"
						class="button border-red"><span class="icon-trash-o"></span>
							添加产品</a>							
						</li>						
				</ul>
				
							
			</div>
			<table class="table table-hover text-center">
				<tr>
					<!-- 
					<th width=""></th>
					 -->
					<th width="10%" align="center"></th>
					<th width="20%">产品名</th>
					<th width="20%">产品类型</th>
					<th width="10%">上市时间</th>
					<th colspan="2" width="40%">操作</th>
				</tr>
				<c:forEach items="${pageResult.dataList}" var="p">

					<tr>
						<td><input type="checkbox" name="productMsgIds"
							value="${p.productMsgId }" /></td>
						<td>${p.productName }</td>
						<td>${p.productType}</td>
						<td><fmt:formatDate value="${p.marketTime}"
								pattern="yyyy-MM-dd" /></td>
						<td><a class="button border-red"
							href="<%=basePath%>productConllectController/deleteProduct.do?productMsgId=${p.productMsgId }"><span
								class="icon-trash-o"></span>删除</a>&nbsp;&nbsp; <a
							class="button border-red"
							href="<%=basePath%>productConllectController/updateProductUI.do?productMsgId=${p.productMsgId }"><span
								class="icon-trash-o"></span>修改</a></td>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<center>
			<div id="jpager"></div>
		</center>
	</form>
	<script type="text/javascript">
		function del(id) {
			if (confirm("您确定要删除吗?")) {

			}
		}

		$("#checkall").click(function() {
			$("input[name='productMsgIds']").each(function() {
				if (this.checked) {
					this.checked = false;
				} else {
					this.checked = true;
				}
			});
		});

		function DelSelect() {
			var Checkbox = false;
			$("input[name='productMsgIds']").each(function() {
				if (this.checked == true) {
					Checkbox = true;
				}
			});
			if (Checkbox) {
				var t = confirm("您确认要删除选中的内容吗？");
				if (t == false)
					return false;
			} else {
				alert("请选择您要删除的内容!");
				return false;
			}
		}
	</script>
	  
</body>
</html>