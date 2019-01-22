<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
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
			<strong><span class="icon-pencil-square-o"></span>个人信息</strong>
		</div>
		<div class="body-content">
			<form action="<%=basePath%>grxxController/updateGrxx.do"
				class="form-x" method="post">
				<input type="hidden" name="userId" value="${user.userId}" /> <input
					type="hidden" name="loginName" value="${user.loginName}" /> <input
					type="hidden" name="loginPassword" value="${user.loginPassword}" />
				<div class="form-group">
					<div class="label">
						<label>姓名：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${user.userName}"
							name="userName" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>性别：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${user.userSex}"
							name="userSex" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>年龄：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${user.userAge}"
							name="userAge" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>出生日期：</label>
					</div>
					<div class="field">
						<input type="text" id="test1" data-validate="required:请输入出生日期"
							class="input w50" value="${user.userBirthday}"
							name="userBirthday" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>电话号码：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${user.userPhone}"
							name="userPhone" />
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
	<div class="modal fade bs-example-modal-lg" id="myModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		        
		<div class="modal-dialog modal-lg">
			            
			<div class="modal-content">
				                
				<div class="modal-header">
					                    
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
					                    
					<h4 class="modal-title" id="myModalLabel">提示 </h4>
					                
				</div>
				                
				<div class="modal-body">
					<div class="modal-body">
						<c:out value='${message }' />
					</div>
					                
				</div>
				                
				<div class="modal-footer">
					                  
					<button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
					                
				</div>
				            
			</div>
			<!-- /.modal-content -->
			        
		</div>
		<!-- /.modal-dialog -->
		    
	</div>
	<!-- /.modal -->
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
    $(function(){
         $("#myModal").modal({
            keyboard: true
         
        });      
        	
    });
</script>
</body>
</html>