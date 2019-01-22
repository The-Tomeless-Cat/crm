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
			<form action="<%=basePath%>userMsgController/addUserMsg.do" class="form-x"
				method="post">
				<div class="form-group">
					<div class="label">
						<label>用户id：</label>
					</div>
					<div class="field">
						<!-- <input type="text" class="input w50" value="" name="userId"
							data-validate="required:用户id" /> -->
							<select name="userId"class="input w50 dropdown-menu" data-validate="required:用户id">
							<option disabled="disabled" selected = "selected" >======请选择用户id======</option>
								<c:forEach items="${UserList}" var="user">
								<option > ${user.userId }</option>
								</c:forEach>
							</select>
						<div class="tips"></div>
					</div>
				</div> 
				<div class="form-group">
					<div class="label">
						<label>年龄：</label>
					</div>			
					<div class="field">
						<input type="text" class="input w50" value="" name="userAge"
							data-validate="required:请输入用户年龄" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>性别：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="userSex"
							data-validate="required:请输入用户性别" />
						<div class="tips"></div>
					</div>
				</div>
					<div class="form-group">
					<div class="label">
						<label>邮件：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="userEmail"
							data-validate="required:请输入用户邮件" />
						<div class="tips"></div>
					</div>
				</div>
					<div class="form-group">
					<div class="label">
						<label>电话：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="userPhone"
							data-validate="required:请输入用户电话" />
						<div class="tips"></div>
					</div>
				</div>
					<div class="form-group">
					<div class="label">
						<label>地址：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="userAddr"
							data-validate="required:请输入用户地址" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>产品爱好：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="userProHobby"
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