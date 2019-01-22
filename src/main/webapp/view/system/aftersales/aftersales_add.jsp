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
			<strong><span class="icon-pencil-square-o"></span>售后服务记录</strong>
		</div>
		<div class="body-content">
			<form action="<%=basePath%>afterSalesController/aftersalesadd.do" class="form-x"
				method="post">
				<div class="form-group">
					<div class="label">
						<label>订单编号：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${order.orderId}" name="orderInformation" readonly="readonly"/>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>服务人员姓名：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${USER.userName} " name="kufuuserName" readonly="readonly"/>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>客户信息：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${huuser.userName}" name="userPhone" readonly="readonly"/>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>客户联系方式：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${huuser.userPhone}" name="userPhone" readonly="readonly"/>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>售后服务情况：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="afterSalesDsc"
							data-validate="required:请输入客户反馈的信息" />
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