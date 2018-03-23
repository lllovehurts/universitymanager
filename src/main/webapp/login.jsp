<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>校园管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/init.css">
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style type="text/css">
		body{
			background:url(images/timg.jpg);
			
		}
		form{
			margin:150px 0 0 300px;
			padding:70px;
		}
		h4{
			text-align: center;
			color: red;
		}
	</style>
  </head>
  
  <body>
		<form class="form-horizontal" action="login" method="post">
		  <div class="form-group" >
		  	<label class="col-md-5 control-label">欢迎使用！</label>
		  </div>
		  <div class="form-group" >
		    <label for="account" class="col-md-2 control-label">账号</label>
		    <div class="col-md-5">
		      <input type="text" class="form-control" id="account" name="account" placeholder="请输入账号">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="password" class="col-md-2 control-label">密码</label>
		    <div class="col-md-5">
		      <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-md-offset-5 col-md-5">
		      <button type="submit" class="btn btn-default">登陆</button><br>
		    </div>
		  </div>
		  <h4>${msg}</h4>
		</form>
  </body>
</html>
