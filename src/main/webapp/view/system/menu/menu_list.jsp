<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>" />
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<%-- 分页相关 --%>
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/kkpager/jpager.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/kkpager/jpager.css">
<script type="text/javascript"
	src="<%=basePath%>view/system/menu/listPage.js"></script>
<script type="text/javascript">
        function load() {
        	arrayPage( ${pageResult.pages} ,${pageResult.total});
        }
</script>
</head>
<body onload="load()">
	<form method="post"
		action="<%=basePath%>menuController/deleteMenuPL.do">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 菜单管理</strong>
			</div>
			<div class="padding border-bottom">
				<ul class="search">
					<li>
						<button type="button" class="button border-green" id="checkall">
							<span class="icon-check"></span> 全选
						</button>
						<a href="<%=basePath%>menuController/addMenuUI.do"
						class="button border-red"><span class="icon-trash-o"></span>添加</a>
					</li>
				</ul>
			</div>
			<table class="table table-hover text-center">
				<tr>
					<!-- 
					<th width="120">ID</th>
					 -->
					<th width="5%" align="center"></th>
					<th width="30%">父ID</th>
					<th width="10%">菜单</th>
					<th width="20%">描述</th>
					<th width="20%">URL</th>
					<th colspan="2" width="20%">操作</th>
				</tr>
				<c:forEach items="${pageResult.dataList}" var="menu">
					<tr>
						<td><input type="checkbox" name="menuids"
							value="${menu.menuId }" /></td>
						<td>${menu.menuPid }</td>
						<td>${menu.menuName }</td>
						<td>${menu.menuDesc }</td>
						<td>${menu.menuUrl }</td>
						<td><a class="button border-red"
							href="<%=basePath%>menuController/deleteMenu.do?menuId=${menu.menuId}"><span
								class="icon-trash-o"></span>删除</a>&nbsp;&nbsp; <a
							class="button border-red"
							href="<%=basePath%>menuController/updateMenuUI.do?menuId=${menu.menuId}"><span
								class="icon-trash-o"></span>修改</a></td>
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
			$("input[name='menuids']").each(function() {
				if (this.checked) {
					this.checked = false;
				} else {
					this.checked = true;
				}
			});
		})

		function DelSelect() {
			var Checkbox = false;
			$("input[name='menuids']").each(function() {
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