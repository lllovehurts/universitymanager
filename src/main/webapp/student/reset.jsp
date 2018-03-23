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
    <title>管理系统（学生）</title>
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
					    	<h1 class="col-md-5">修改密码</h1>
						</div>
				    </div>
				  	<form class="form-horizontal" style="margin: 50px;" action="student/editpassword" onsubmit="return passwordValidate()">
					  <div class="form-group">
					    <label for="inputText3" class="col-sm-2 control-label">原密码</label>
					    <div class="col-sm-3">
					      <input type="password" class="form-control" id="inputText2" name="password" value="">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="inputText3" class="col-sm-2 control-label">新密码</label>
					    <div class="col-sm-3">
					      <input type="password" class="form-control" id="newPassword" name="newPassword" value="" onblur="passwordValidate()">
					    </div>
					    <span id = "newPasswordV"></span>
					  </div>
					  <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-7">
					      <button type="submit" class="btn btn-default">修改密码</button>
					    </div>
					  </div>
					</form>  
					<div class="panel-footer">
				    </div>
				</div>
			</div>
		</div>
	</div>
	<div class="container" id="footer">
		<div class="row">
			<div class="col-md-12"></div>
		</div>
	</div>
	<script type="text/javascript">
		function passwordValidate(){
			var str = document.getElementById("newPassword").value ;
			if(str.length == 0){
				document.getElementById("newPasswordV").innerHTML = "<p style='color:red'>不能为空</p>" ;
				return false ;
			}else{
				if(str.indexOf(" ") >= 0){
					document.getElementById("newPasswordV").innerHTML = "<p style='color:red'>密码不能有空格</p>" ;
					return false ;
				}else{
					return true ;
				}
			}
		}
	</script>
  </body>
</html>

