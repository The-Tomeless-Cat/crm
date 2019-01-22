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
			<strong><span class="icon-pencil-square-o"></span>修改内容</strong>
		</div>
		<div class="body-content">
			<form action="<%=basePath%>afterSalesController/aftersalesupdate.do"
				class="form-x" method="post">
				<input type="hidden" name="afterSalesId" value="${aftersales.afterSalesId}"/> 
				<div class="form-group">
					<div class="label">
						<label>服务编号：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${aftersales.afterSalesId}" readonly="readonly"/>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>订单编号：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${aftersales.orderInformation}" readonly="readonly"
						name="orderInformation"/>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>客服编号：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${aftersales.waiterId}" readonly="readonly"
						name="waiterId"/>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>服务描述：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50"
							name="afterSalesDsc" data-validate="required:请输入服务反馈" />
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