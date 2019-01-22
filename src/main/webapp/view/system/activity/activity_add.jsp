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
			<strong><span class="icon-pencil-square-o"></span>增加活动内容</strong>
		</div>
		<div class="body-content">
			<form action="<%=basePath%>activityController/addActivity.do" class="form-x"
				method="post">
				<div class="form-group">
					<div class="label">
						<label>活动名称：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="activityName"
							data-validate="required:请输入名称" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>活动类型：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="activityType"
							data-validate="required:请输入活动类型" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>活动状态：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="activityStatus"
							data-validate="required:请输入活动状态" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>活动描述：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="activityDescription"
							data-validate="required:请输入活动描述" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>活动时间：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="activityTime"
							data-validate="required:请输入活动时间" />
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