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
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
	<div class="panel admin-panel">
		<form action="<%=basePath%>menuController/fpMenu.do" class="form-x"
			method="post">
			<input type="hidden" name="roleId" value="${role.roleId}">
			<div class="panel-head" id="add">
				<strong><span class="icon-pencil-square-o"></span>&nbsp;角色：<font
					color="red">${role.roleName}</font>&nbsp;&nbsp;&nbsp;&nbsp;分配内容：</strong>
			</div>
			<div class="body-content">
			<button type="button" class="button border-green" id="checkall">
							<span class="icon-check"></span> 全选
						</button>
				<c:forEach items="${menuList }" var="menu">
					<div class="field">
						<input type="checkbox" name="menuIds" value="${menu.menuId}"
							style="width: auto;" id="${menu.menuId}">${menu.menuName }
						<div class="tips"></div>
					</div>
				</c:forEach>
			</div>
			<div class="form-group">
				<div class="label">
					<label></label>
				</div>
				<div class="field">
					<button class="button bg-main icon-check-square-o" type="submit">
						提交</button>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		

		$("#checkall").click(function() {
			$("input[name='menuIds']").each(function() {
				if (this.checked) {
					this.checked = false;
				} else {
					this.checked = true;
				}
			});
		})

		
	</script>
</body>
</html>