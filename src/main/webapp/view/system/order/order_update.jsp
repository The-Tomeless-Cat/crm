<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>增加内容</strong>
		</div>
		<div class="body-content">
			<form action="<%=basePath%>orderController/updateOrder.do"
				class="form-x" method="post">
				<input type="hidden" name="orderId" value="${order.orderId }"> 
					<input type="hidden" name="orderCreatetime " value="${order.orderCreatetime }"> 
				<input type="hidden" name="orderTotal" value="${order.orderTotal}"> 
				<div class="form-group">
					<div class="label">
						<label>订单类型：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${order.orderType }"
							name="orderType" data-validate="required:请输入类型" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>订单状态：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${order.orderState }"
							name="orderState" data-validate="required:请输入状态" />
						<div class="tips"></div>
					</div>
				</div>
				
			
				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="submit">
							修改</button>
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
</html>