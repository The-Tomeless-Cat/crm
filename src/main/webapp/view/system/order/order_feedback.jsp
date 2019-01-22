<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
		elem : '#test-n1',
		position : 'static'
	});
	laydate.render({
		elem : '#test-n2',
		position : 'static',
		lang : 'en'
	});
	laydate.render({
		elem : '#test-n3',
		type : 'month',
		position : 'static'
	});
	laydate.render({
		elem : '#test-n4',
		type : 'time',
		position : 'static'
	});
	laydate.render({
		elem : '#test1' //指定元素
	});
</script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>订单反馈表</strong>
		</div>
		<div class="body-content">
			<form action="<%=basePath%>feedbackController/addOrderfeedback.do" class="form-x"
				method="post">
				<div class="form-group">
					<div class="label">
						<label>姓名：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="userName"
							data-validate="required:请输入名称" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>性别：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="userSex"
							data-validate="required:请输入性别" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>联系方式：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="userContact" placeholder="请输入电话号码或者邮箱地址"
							data-validate="required:请输入联系方式" />
						<div class="tips"></div>
					</div>	<br>
								<hr>
				<div class="form-group">
					<div class="label">
						<label>产品名称及型号：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="productName"
							data-validate="required:请输入产品信息" />
						<div class="tips"></div>
					</div>
				</div>
					<div class="form-group">
					<div class="label">
						<label>购买日期：</label>
					</div>
					<div class="field">
						<input type="text" id="test1" data-validate="required:请输入购买日期"
							class="input w50" value=""
							name="productBuydate" />
						<div class="tips"></div>
					</div>
				</div>
				
					<div class="form-group">
					<div class="label">
						<label>遇到产品问题：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="productProblem"
							data-validate="required:请输入产品问题描述" />
						<div class="tips"></div>
					</div>
				</div>
					</div>
				
					<div class="form-group">
					<div class="label">
						<label>产品满意程度：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="productsSatisfactionLevel" placeholder="满意/一般/不满意/很差"
							data-validate="required:请输入产品满意程度" />
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