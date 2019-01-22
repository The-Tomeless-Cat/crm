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
<link href="css/bootstrap.min.css" rel="stylesheet">

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
	<form method="post" action="<%=basePath%>orderController/deleteOrderPL.do">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 订单管理</strong>
			</div>
			<div class="padding border-bottom">
				<ul class="search">
					<li>
						<button type="button" class="button border-green" id="checkall">
							<span class="icon-check"></span> 全选
						</button> <!-- 批量删除 --> <input type="submit" class="button border-red"
						value="批量删除">
					</li>
				</ul>
			</div>
			<table class="table table-hover text-center">
				<tr>
					<!-- 
					<th width="120">ID</th>
					 -->
					<th width="5%" align="center"></th>
					<th width="15%">订单ID</th>
					<th width="7%">订单类型</th>
					<th width="7%">订单状态</th>
					<th width="20%">用户ID</th>
					<th width="10%">订单总价</th>
					<th width="10%">创建时间</th>
					<th colspan="2" width="20%">操作</th>
				</tr>
				<c:forEach items="${pageResult.dataList}" var="order">
					<tr>
						<!-- 
						<td>${user.userId }</td>
						 -->
						<td><input type="checkbox" name="orderids"
							value="${order.orderId }" /></td>
						<td>${order.orderId }</td>
						<td>${order.orderType }</td>
						<td>${order.orderState }</td>
						<td>${order.userId }</td>
						<td>${order.orderTotal }</td>
						<td><fmt:formatDate value="${order.orderCreatetime}"
								pattern="yyyy-MM-dd hh:mm:ss" /></td>
						<td><a class="button border-red"
							href="<%=basePath%>orderController/deleteOrder.do?orderId=${order.orderId}"><span
								class="icon-trash-o"></span>删除</a> &nbsp;&nbsp; <a
							class="button border-red"
							href="<%=basePath%>orderController/updateOrderUI.do?orderId=${order.orderId}"><span
								class="icon-trash-o"></span>订单修改</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<center>
			<div id="jpager"></div>
		</center>
	</form>
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

	<script type="text/javascript">
		function del(id) {
			if (confirm("您确定要删除吗?")) {

			}
		}

		$("#checkall").click(function() {
			$("input[name='orderids']").each(function() {
				if (this.checked) {
					this.checked = false;
				} else {
					this.checked = true;
				}
			});
		})

		function DelSelect() {
			var Checkbox = false;
			$("input[name='userids']").each(function() {
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