<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
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
					    	<h1 class="col-md-5">学生打分</h1>
						</div>
				    </div>
				    <form class="form-horizontal" style="margin: 50px;" action="teacher/mark" method="post" onsubmit="return markValidate()">
				    	<input type="hidden" name="id" value="${record.id}">
		    		  <div class="form-group">
					    <label for="inputText3" class="col-sm-2 control-label">学号</label>
					    <div class="col-sm-3">
					      <input type="text" class="form-control" id="inputText1" name="studentid.studentid" readonly value="${record.studentid.studentid}">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="inputText3" class="col-sm-2 control-label">姓名</label>
					    <div class="col-sm-3">
					      <input type="text" class="form-control" id="inputText2" name="studentid.name" readonly value="${record.studentid.name}">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="inputText3" class="col-sm-2 control-label">成绩</label>
					    <div class="col-sm-3">
					      <input type="number" class="form-control" id="score" name="score" onblur="markValidate()">
					    </div>
					    <span id = "markV"></span>
					  </div>
					  <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-7">
					      <button type="submit" class="btn btn-default">提交</button>
					    </div>
					  </div>
					</form>
				    <div id="updatediv"></div>
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
		function markValidate(){
			var mark = document.getElementById("score").value ;
			if(mark.length > 0){
				if(mark>=0&&mark<=100){
					return true ;
				}else{
					document.getElementById("markV").innerHTML="<p style='color:red'>成绩输入错误</p>" ;
					return false ;
				}
			}else{
			document.getElementById("markV").innerHTML="<p style='color:red'>成绩不能为空</p>"
				return false ;
			}
		}
	</script>
  </body>
</html>
