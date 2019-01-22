<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style type="text/css">
		</style>
		<!-- Bootstrap -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
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
	src="<%=basePath%>view/system/menu/listPage.js"></script>
<script type="text/javascript">
        function load() {
        	arrayPage(${pageResult.pages},${pageResult.total});
        }
</script>
</head>
<body onload="load()">
	<div class="panel-head">
				<strong class="icon-reorder"> 反馈表管理</strong>
				<form action="<%=basePath%>feedbackController/listPage8.do"
							method="post" style="margin-left:250px">
						<input type="text" class="input w50" value="" name="name" placeholder="请输入用户名查询"/>
  						<input type="submit"  class="button border-blue" value="模糊查询" class="input w50"style="width:100px;">								
						<div class="tips"></div>
						</form>
			</div>
			
	<form method="post"
		action="<%=basePath%>feedbackController/deleteFeedbackPL.do">
		<div class="panel admin-panel">
			
			<hr>

			<div class="padding border-bottom">
				<ul class="search">
					<li>
						<button type="button" class="button border-green" id="checkall">
							<span class="icon-check"></span> 全选
						</button> <!-- 批量删除 --> <input type="submit" class="button border-red"
						value="批量删除"><font color="red">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${message}</font>
					</li>
				</ul>
				
			</div>
			<table class="table table-hover text-center">
				<tr>
					<!-- 
					<th width="120">ID</th>
					 -->
					<th width="5%" align="center"></th>
					<th width="15%">用户姓名</th>
					<th width="10%">用户性别</th>
					<th width="10%">用户联系方式</th>
					<th width="10%">产品名称</th>
					<th width="20%">产品购买日期</th>
					<th width="10%">产品问题描述</th>
					<th width="10%">创建时间</th>
					<th width="10%">操作</th>

				</tr>
				<c:forEach items="${pageResult.dataList}" var="feedback">
					<tr>
						<!-- 
						<td>${user.userId }</td>
						 -->
						<td><input type="checkbox" name="feedbackids"
							value="${feedback. feedbackId }" /></td>
						<td >${feedback.userName }</td>
						<td > ${feedback.userSex  }</td>
						<td >${feedback.userContact  }</td>
						<td >${feedback.productName  }</td>
						<td >${feedback.productBuydate }</td>
						<td >${feedback.productProblem }</td>
						<td ><fmt:formatDate value="${feedback.feedbackCreatetime }"
								pattern="yyyy-MM-dd hh:mm:ss" /></td>
						<td><a class="btn btn-primary btn-lg" data-toggle="modal" data-target="#Modal${feedback. feedbackId}"
						><span
								class="icon-trash-o"></span>已解决</a>
	<!-- 					<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
已解决该订单问题
</button> -->

	

<div class="modal fade" id="Modal${feedback. feedbackId}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h4 class="modal-title" id="myModalLabel">模态框</h4>
            </div>
            <div class="modal-body">确认已解决该订单问题吗</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <a type="button" class="btn btn-default" href="<%=basePath%>feedbackController/deletefeedback.do?feedbackId=${feedback. feedbackId}">确定</a></button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>	
				</c:forEach>
			</table>

	
		<center>
			<div id="jpager"></div>
		</center>
	</form>
<script src="js/bootstrap.min.js"></script>


	<script type="text/javascript">
		function del(id) {
			if (confirm("您确定要删除吗?")) {

			}
		}

		$("#checkall").click(function() {
			$("input[name='feedbackids']").each(function() {
				if (this.checked) {
					this.checked = false;
				} else {
					this.checked = true;
				}
			});
		})

		function DelSelect() {
			var Checkbox = false;
			$("input[name='menuids']").each(function() {
				if (this.checked == true) {
					Checkbox = true;
				}
			});
			if (Checkbox) {
				var t = confirm("您确认要删除选中的内容吗？");
				if (t == false)
					return false;
			} else {
				alert("请选择您要删除的内容!");
				return false;
			}
		}
	</script>
</body>
</html>