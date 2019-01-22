<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<base href="<%=basePath%>" />
<meta charset="UTF-8">
<title>登录</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="css/jquery.alerts.css"/>
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>    
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.alerts.js"></script>
    <script src="js/jquery.browser.js"></script>
</head>
<body>
<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:150px;"></div>
            <div class="media media-y margin-big-bottom">           
            </div>         
            <form action="<%=basePath%>loginController/login.do" method="post" id="form">
            <div class="panel loginbox">
                <div class="text-center margin-big padding-big-top"><h1>CRM登陆</h1></div>
                <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="text" class="input input-big" name="loginName" placeholder="账号" data-validate="required:请填写账号" />
                            <span class="icon icon-user margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="password" class="input input-big" name="loginPassword" placeholder="密码" data-validate="required:请填写密码" />
                            <span class="icon icon-key margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">         
                    	<div class="field field-icon-right">
                    		<input type="text" class="input" id="checkcode" name="checkcode" placeholder="验证码" data-validate="required:请填写密码"
                    		style="width:200px;float:left;position:fixed; "/>                   	       
                            <img src="<%=basePath%>loginController/productCheck.do"  alt="验证码" id="image" style="float:right" onclick="reload()"/>             			                      
                  		</div> 
                    </div> 
                </div>
                <br>
                <div style="padding:30px;text-align:center;" >
	               	<input type="submit" id="login_submit" class="button  bg-main text-big input-big" value="登录">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                <a href="register.jsp"><input type="button" class="button  bg-main text-big input-big" value="注册"></a>
                </div>
            </div>
            </form>          
        </div>
    </div>
</div>
<script type="text/javascript">
 function reload(){
	 document.getElementById("image").src="<%=basePath%>loginController/productCheck.do?date="+new Date().getTime();
		$("#checkcode").val("");   // 将输入框验证码清空
 } 
 $(function(){
	 if("${message}"!=""){
		 jAlert("${message}", "提示");
	 }
 })
</script>
</body>
</html>