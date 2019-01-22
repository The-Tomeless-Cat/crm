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
		<form action="<%=basePath%>productController/fpProduct.do" class="form-x"
			method="post">
			<input type="hidden" name="activityId" value="${activity.activityId}">
			<div class="panel-head" id="add">
				<strong><span class="icon-pencil-square-o"></span>&nbsp;活动：<font
					color="red">${activity.activityName}</font>&nbsp;&nbsp;&nbsp;&nbsp;分配内容：</strong>
			</div>
			<div class="body-content">
				<c:forEach items="${productList }" var="product">
					<div class="field">
						<input type="checkbox" name="productIds" value="${product.productId }"
							style="width: auto;" id="${product.productId }">${product.productName }
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
</body>
</html>