<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE>
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<script src="js/jquery.alerts.js"></script>
<script src="js/jquery.browser.js"></script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>修改报价单</strong>
		</div>
		<div class="body-content">
			<form action="<%=basePath%>pricelistController/updatePricelist.do" class="form-x"
				method="post">
				<input type="hidden" name="priceListId " value="${PriceList.priceListId }">
 
			
				<div class="form-group">
					<div class="label">
						<label>商品名称：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${PriceList.productPriceName }" name="productPriceName"
							data-validate="required:请输入名称" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>商品型号：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${PriceList.productListDesc }" name="productListDesc"
							data-validate="required:请输入型号" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>商品进价：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${PriceList.productUnitPrice }" name="productUnitPrice"
							data-validate="required:请输入商品进价"    onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"          
							onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>商品售价：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${PriceList.productSellingPrice }" name="productSellingPrice"
							data-validate="required:请输入商品售价"  onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"          
							onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"
							 />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>商品进货地址：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${PriceList.productSourceCompany }" name="productSourceCompany"
							data-validate="required:请输入商品进货地址" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>商品描述：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${PriceList.productRemark }" name="productRemark"
							data-validate="required:请输入商品描述" />
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