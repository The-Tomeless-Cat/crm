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
<title>用户注册</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/pintuer.js"></script>

</head>
<body style="background-color: #f2f9fd;text-align:center;">
	<div class="container">
   		<div class="row">
   		<div class="col-md-4">
   		</div>
   		<div class="col-md-8">
		 	<h1 style="text-align:center;border-bottom:1px solid #ccc;	padding:20px 0;">用&nbsp;户&nbsp;注&nbsp;册</h1>
				<form action="<%=basePath%>userController/registerUser.do" id="form" method="post">		
				<table style="text-align:center;font-size:20px; margin-left:400px;height:500px;">
			    	<tr>
			    		<td>姓名：</td>
			    		<td><input type="text" name="userName" id="user_name"  autocomplete="off" />
			    		</td>
			    		<td id="err_user_name"></td>
			    	</tr>
			    	<tr>
			    		<td>年龄：</td>
			    		<td><input type="text" name="userAge" id="user_age" autocomplete="off" /></td>
			    		<td id="err_user_age"></td>
			    	</tr>
			    	<tr>
			    		<td>性别：</td>
			    		<td><input type="radio" value="男" name="userSex" autocomplete="off" >男
							<input type="radio" value="女" name="userSex"  autocomplete="off" >女</td>
			    		<td id="err_user_sex"></td>
			    	</tr>
			    	<tr>
			    		<td>联系电话：</td>
			    		<td><input type="text" name="userPhone" id="user_phone" autocomplete="off" />
			    		<td id="err_user_phone"></td>
			    	</tr>
			    	
			    	<tr>
			    		<td>登陆账号：</td>
			    		<td><input type="text" name="loginName" id="login_name" autocomplete="off" /></td>
			    		<td id="err_login_name"></td>
			    	</tr>			    				    				    	
			    	<tr>
			    		<td>登录密码：</td>
			    		<td><input type="password" name="loginPassword" id="login_password" autocomplete="off"  /></td>
			    		<td id="err_login_password"></td>
			    	</tr>
			    	<tr>
			    		<td>确认密码：</td>
			    		<td><input type="password" name="re_login_password" id="re_login_password" autocomplete="off" /></td>
			    		<td id="err_re_login_password"></td>
			    	</tr>
		   		</table>
		   		<a class="button  bg-main text-big input-big " onclick="startPost()" href="javascript:void(0)">保存</a>
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    <a class="button  bg-main text-big input-big " href="login.jsp">取消</a>		
			</form>
			</div>
		</div>
	</div>

<script type="text/javascript">
   function valiInput(id,msg,n){
	   var val = document.getElementById(id).value;
	   if(val=="" || val.length<n){
		   document.getElementById("err_"+id).innerHTML="<span class='err'>"+msg+"</span>";
		   return false;
	   }else{
		   document.getElementById("err_"+id).innerHTML="<span class='success'>验证通过。</span>";
		   return true;
	   }
   }
   function valiPwd(){
	   if(document.getElementById("login_password").value!=document.getElementById("re_login_password").value){
		   document.getElementById("err_re_login_password").innerHTML="<span class='err'>两次输入的密码不一样。</span>";
		   return false;
	   }
	   return true;
   }
   function startPost(){
	   var ipts=["login_name","user_name","user_phone","login_password","re_login_password"];
	   var lens=[3,2,11,6,6];
	   var msg=["请输入登录帐号，至少3位。","请输入真实姓名，至少2位。","请输入11位的电话号码。","请输入登录密码，至少6位。","请输入确认密码，至少6位。"];
	   var flag=true;
	   for(var i=0;i<ipts.length;i++){
		   flag = valiInput(ipts[i],msg[i],lens[i])&&flag;
	   }
	   flag=valiPwd()&&flag;
	   if(!flag)return;
	   document.getElementById("form").submit();
   }
</script>

</body>
</html>
