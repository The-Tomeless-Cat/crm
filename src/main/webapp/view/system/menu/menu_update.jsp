<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>修改内容</strong>
		</div>
		<div class="body-content">
			<form action="<%=basePath%>menuController/updateMenu.do"
				class="form-x" method="post">
				<input type="hidden" name="menuId" value="${m.menuId}">
				<div class="form-group">
					<div class="label">
						<label>上级权限：</label>
					</div>
					<div class="field">
						<select name="menuPid">
							<option>---请选择父级菜单---</option>
							<c:forEach items="${menuList}" var="menu">
								<option value="${menu.menuId}"
									<c:if test="${menu.menuId==m.menuPid}">selected</c:if>>${menu.menuName}</option>
							</c:forEach>
						</select>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>菜单名称：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${m.menuName}"
							name="menuName" data-validate="required:请输入菜单名称" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>菜单描述：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${m.menuDesc}"
							name="menuDesc" data-validate="required:请输入菜单描述" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>菜单URL：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${m.menuUrl}"
							name="menuUrl" data-validate="required:请输入菜单URL" />
						<div class="tips"></div>
					</div>
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
	</div>

</body>
</html>