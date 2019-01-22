<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="stylesheet" href="css/jquery.alerts.css"/>
<script src="js/jquery.min.js"></script>
<script src="js/pintuer.js"></script>
<script src="js/jquery.alerts.js"></script>
<script src="js/jquery.browser.js"></script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>增加内容</strong>
		</div>
		<div class="body-content">
			<form action="<%=basePath%>pricelistController/addPricelist.do" class="form-x" id="form"
				method="post"  onSubmit="return check()">
				<div class="form-group">
					<div class="label">
						<label>商品名称：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="productPriceName"
							data-validate="required:请输入名称" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>商品型号：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="productListDesc"
							data-validate="required:请输入商品型号" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>商品进价：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="productUnitPrice" id="product_unitPrice"
							data-validate="required:请输入商品进价" />
						<div class="tips"></div>
					</div>
				</div>
					<div class="form-group">
					<div class="label">
						<label>商品售价：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="productSellingPrice" id="product_sellingprice"
							data-validate="required:请输入商品售价" />
						<div class="tips"></div>
					</div>
				</div>
					<div class="form-group">
					<div class="label">
						<label>商品来源：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="productSourceCompany"
							data-validate="required:请输入商品进货地址" />
						<div class="tips"></div>
					</div>
				</div>
					<div class="form-group">
					<div class="label">
						<label>商品描述：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="productRemark"
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
<script type="text/javascript">
	function check(){
		console.log("我进来了");
		 var reg=/^[0-9]*$/;   /*定义验证表达式*/
		var product_unitPrice=$("#product_unitPrice").val();
		var product_sellingprice=$("#product_sellingprice").val();
		console.log(product_unitPrice);
		console.log(product_sellingprice);
		console.log(reg.test(product_unitPrice)&&reg.test(product_sellingprice)&&(product_unitPrice<product_sellingprice));
		if(reg.test(product_unitPrice)&&reg.test(product_sellingprice)&&(product_unitPrice<product_sellingprice)){
			console.log("正确");
			return true;
		}else{
			 jAlert("进价或者售价有误", "提示");
			 return false;
		}
	}
</script>
</html>