<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<script src="js/layDate-v5.0.9/laydate/laydate.js"></script>
<script type="text/javascript">
//直接嵌套显示
laydate.render({
  elem: '#test-n1'
  ,position: 'static'
});
laydate.render({
  elem: '#test-n2'
  ,position: 'static'
  ,lang: 'en'
});
laydate.render({
  elem: '#test-n3'
  ,type: 'month'
  ,position: 'static'
});
laydate.render({
  elem: '#test-n4'
  ,type: 'time'
  ,position: 'static'
}); 
laydate.render({
	  elem: '#test1' //指定元素
	});
</script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>增加内容</strong>
		</div>
		<div class="body-content">
			<form action="<%=basePath%>productConllectController/addProduct.do" class="form-x"
				method="post">
				<div class="form-group">
					<div class="label">
						<label>产品名称：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="productName"
							data-validate="required:请输入产品名称" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>产品类型：</label>
					</div>
					
					<div class="field">
						<input type="text" class="input w50" value="" name="productType"
							data-validate="required:请输入产品类型" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>上市时间：</label>
					</div>
					<div class="field">
				<!-- <input type="datetime" class="input w50" value="" name="marketTime"
							data-validate="required:请输入上市时间" />  -->
					<input type="text" id="test1" placeholder="请选择上市时间" class="input w50"name="marketTime">
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
								 <a
						href="<%=basePath%>productConllectController/listPage.do"
						class="button bg-main ">
							取消</a>
					</div>
				</div>
			</form>
		</div>
	</div>

</body>

</html>