<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>管理系统（管理员）</title>
    <style type="text/css">
    	#ctop{
    		height: 50px;
    		background: #F8F8F8;
    	}
    	#ctop p{
    		margin-top:8px;
    		margin-left:20px;
    		font-size: 30px;
    		color:#555;
    		float: left;
    	}
    	#cmid{
    		height: 350px;
    		margin-top: 50px;
    		margin-left: 200px;
    	}
    
    </style>
  </head>
  
  <body>
  	<!-- 顶栏 -->
	<jsp:include page="top.jsp"></jsp:include>
	<div class="container" id="content">
		<div class="row">
			<jsp:include page="menu.jsp"></jsp:include>
			<div class="col-md-10">
		<div class="panel panel-default">
		    <div class="panel-heading">
				<div class="row">
			    	<h1 class="col-md-5">密码重置</h1>
				</div>
		    </div>
		  	<form class="form-horizontal" style="margin: 50px;">
    		  <div class="form-group">
			    <label for="inputText3" class="col-sm-2 control-label">账号</label>
			    <div class="col-sm-3">
			      <input type="text" class="form-control" id="account" name="account" value ="${login.account}">
			    </div>
			    	<span id = "accountV" style="color: red">${accountMsg}</span>
			  </div>
			  <div class="form-group">
			    <label for="inputText3" class="col-sm-2 control-label">原密码</label>
			    <div class="col-sm-3">
			      <input type="password" class="form-control" id="password" name="password" value="${login.password}">
			    </div>
			    	<span id = "passwordV"></span>
			  </div>
			  <div class="form-group">
			    <label for="inputText3" class="col-sm-2 control-label">新密码</label>
			    <div class="col-sm-3">
			      <input type="password" class="form-control" id="newPassword" name="newPassword">
			    </div>
			    <span id = "newPasswordV"></span>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-7">
			      <button type="button" class="btn btn-default" onclick="findPassword()">找回密码</button>
			      <button type="button" class="btn btn-default" onclick="editPassword()">修改密码</button>
			    </div>
			  </div>
			</form>  
		</div>
	</div>
		</div>
	</div>
	<script type="text/javascript">
		function findPassword(){
			var str = document.getElementById("account").value ;
			window.location.href="admin/findpassword?account="+str ;
		}
		function editPassword(){
			var str = document.getElementById("account").value ;
			var newPassword = document.getElementById("newPassword").value ;
			window.location.href="admin/editpassword?account="+str+"&newPassword="+newPassword ;
		}
	</script>
  </body>
</html>

