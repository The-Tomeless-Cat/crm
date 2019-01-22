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
			<strong><span class="icon-pencil-square-o"></span>添加订单</strong>
		</div>
		<div class="body-content">
			<form action="<%=basePath%>orderController/addOrder.do" class="form-x"
				method="post">
				<div class="form-group">
					<div class="label">
						<label>订单类型：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="orderType"
							data-validate="required:请输入订单类型" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>订单状态：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="orderState"
							data-validate="required:请输入订单状态" />
						<div class="tips"></div>
					</div>
				</div>
					<div class="form-group">
					<div class="label">
						<label>订单总价：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="orderTotal"
							data-validate="required:请输入" />
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
							<button class="button bg-main icon-check-square-o" type="reset">
							重置</button>
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
</html>