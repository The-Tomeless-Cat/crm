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
			<form action="<%=basePath%>productController/updateProduct.do" class="form-x"
				method="post">
				<input type="hidden" name="productId" value="${product.productId }"> 
				<div class="form-group">
					<div class="label">
						<label>产品名称：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${product.productName }"
							name="productName" data-validate="required:请输入名称" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>产品金额：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${product.productMoney }"
							name="productMoney" data-validate="required:请输入金额" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>产品种类：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${product.productType }"
							name="productType" data-validate="required:请输入种类" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>产品描述：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${product.productDsc }"
							name="productDsc" data-validate="required:请输入描述" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>产品库存：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${product.pruductKucun }"
							name="pruductKucun" data-validate="required:请输入库存" />
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