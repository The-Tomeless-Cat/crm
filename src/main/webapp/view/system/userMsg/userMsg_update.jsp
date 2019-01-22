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
			<form action="<%=basePath%>userMsgController/updateUserMsg.do" class="form-x"
				method="post">
				<input type="hidden" name="userMsgId" value="${u.userMsgId }">
				<div class="form-group">
					<div class="label">
						<label>用户id：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${u.userId }" name="userId" readonly="readonly"
							data-validate="required:请输入用户id" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>年龄：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${u.userAge }" name="userAge"
							data-validate="required:请输入用户年龄"readonly="readonly" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>性别：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${u.userSex }" name="userSex"
							data-validate="required:请输入用户性别" readonly="readonly"/>
						<div class="tips"></div>
					</div>
				</div>
					<div class="form-group">
					<div class="label">
						<label>邮件：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${u.userEmail }" name="userEmail"
							data-validate="required:请输入用户邮件" />
						<div class="tips"></div>
					</div>
				</div>
					<div class="form-group">
					<div class="label">
						<label>电话：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${u.userPhone }" name="userPhone"
							data-validate="required:请输入用户电话" />
						<div class="tips"></div>
					</div>
				</div>
					<div class="form-group">
					<div class="label">
						<label>地址：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${u.userAddr }" name="userAddr"
							data-validate="required:请输入用户地址" />
						<div class="tips"></div>
					</div>
				</div>
					<div class="form-group">
					<div class="label">
						<label>产品爱好：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${u.userProHobby }" name="userProHobby"
							data-validate="required:请输入用户产品爱好" />
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
						href="<%=basePath%>userMsgController/listPage.do"
						class="button bg-main ">
							取消</a>
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
</html>