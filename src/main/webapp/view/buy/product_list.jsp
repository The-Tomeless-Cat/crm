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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<%-- 分页相关 --%>
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/kkpager/jpager.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/kkpager/jpager.css">
<script type="text/javascript"
	src="<%=basePath%>view/system/product/listPage.js"></script>
<script type="text/javascript">
        function load() {
        	arrayPage(${pageResult.pages},${pageResult.total});
        }
</script>
</head>
<body onload="load()">
	<form method="post"
		action="<%=basePath%>userproductController/buyproduct.do">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 产品管理</strong>
			</div>
			<div class="padding border-bottom">
				<ul class="search">
					<li>
						 <!-- 批量删除 --> <input type="submit" class="button border-red"
						value="购买"> 
					</li>
				</ul>
			</div>
			<table class="table table-hover text-center">
				<tr>
					<!-- 
					<th width=""></th>
					 -->
					<th width="10%" align="center"></th>
					<th width="10%">名称</th>
					<th width="10%">金额</th>
					<th width="10%">种类</th>
					<th width="10%">描述</th>
					<th width="10%">库存</th>
				<th colspan="2" width="40%">购买数量</th>
				</tr>
				<c:forEach items="${pageResult.dataList}" var="product">

					<tr>
						<td><input type="checkbox" name="productIds"
						id="${product.productId}"	value="${product.productId}"  /></td>
						<td>${product.productName }</td>
						<td>${product.productMoney }</td>
						<td>${product.productType }</td>
						<td>${product.productDsc }</td>
						<td>${product.pruductKucun }</td>

						<td><input type="text" id="amount${product.productId}"  name="productAmounts" disabled=true 
						onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"	onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'0')}else{this.value=this.value.replace(/\D/g,'')}"/></td>
						
						


						
						
						
				</c:forEach>
			</table>
		</div>
		<center>
			<div id="jpager"></div>
		</center>
	</form>
	<script type="text/javascript">
	

	$("#checkall").click(function() {
		$("input[name='productIds']").each(function() {
			if (this.checked) {
				this.checked = false;
			} else {
				this.checked = true;
			}
		});
	})

	function DelSelect() {
		var Checkbox = false;
		$("input[name='productIds']").each(function() {
			if (this.checked == true) {
				Checkbox = true;
			}
		});
		if (Checkbox) {
			var t = confirm("您确认要购买选中的产品吗？");
			if (t == false)
				return false;
		} else {
			alert("请选择您要购买的产品!");
			return false;
		}
	}
		$("input[name='productIds']").click(function(){
			var v=this.checked;
			console.log(v);
			var pid=this.id;
			if(this.checked){
				console.log(pid);
			$("#amount"+pid+"").attr("disabled",false);
			}else{
				$("#amount"+pid+"").val("");
				$("#amount"+pid+"").attr("disabled",true);
			}
			})
	</script>
</body>
</html>