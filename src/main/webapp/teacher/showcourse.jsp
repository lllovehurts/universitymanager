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
					    	<h1 class="col-md-5">我的课程</h1>
							<form class="bs-example bs-example-form col-md-5" role="form" style="margin: 20px 0 10px 0;" id="form1" onsubmit="getCourse();return false">
								<div class="input-group">
									<input type="text" class="form-control" id="num" placeholder="请输入课程号">
									<span class="input-group-addon btn" onclick="getCourse()" id="sub">搜索</span>
								</div>
							</form>
						</div>
				    </div>
				    <table class="table table-bordered">
					        <thead>
					            <tr>
							  		<th>课程号</th>
							  		<th>课程名称</th>
							  		<th>上课时间</th>
							  		<th>上课地点</th>
							  		<th>课程类型</th>
							  		<th>学分</th>
							  		<th>操作</th>
						  		</tr>
					        </thead>
					        <tbody>
							<c:forEach items="${list}" var="course">
								<tr>
									<td>${course.courseid}</td>
							  		<td>${course.name}</td>
							  		<td>${course.time}</td>
							  		<td>${course.addr}</td>
							  		<td>${course.type}</td>
							  		<td>${course.score}</td>
									<td>
										<button class="btn btn-default btn-xs btn-info" onClick="showStudent(${course.courseid})">打分</button>
									</td>
								</tr>
							</c:forEach>
					        </tbody>
				    </table>
				    <div id="updatediv"></div>
				    <input type="hidden" id="pageCount" value="${pageCount}">
				    <input type="hidden" id="pageNo" value="${pageNo}">
				    <div class="panel-footer">
				    	<c:if test="${pagingUI != null}">
					    	<nav style="text-align: center">
					    		<ul class="pagination">
								  	<li><a id="pagebotton1"  href="javascript:void(0);"   onclick="lastPage()">&laquo;上一页</a></li>
								  	<li><a>${pageNo}</a></li>
									<li><a id="pagebotton2"  href="javascript:void(0);"  onclick="nextPage()">下一页&raquo;</a></li>
									<li><a>共 ${pageCount} 页</a></li>
									<li><a>共 ${count} 条记录</a></li>
								</ul>
							</nav>
						</c:if>
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
  	function nextPage(){
			var pageCount=document.getElementById("pageCount").value; //获得总页数
			var pageNo=document.getElementById("pageNo").value; //获得当前页
			if(parseInt(pageCount)<=parseInt(pageNo)){//当前页不小于总页数则返回
				return;
			}
			var nPageNo = parseInt(pageNo)+1;//查询当前页的下一页
			window.location.href="teacher/showcourse?pageNo="+nPageNo ; //跳转
		}
		function lastPage(){
			var pageNo=document.getElementById("pageNo").value;//获得当前页
			if(parseInt(pageNo)==1){//当前页为首页则返回
				return;
			}
			var lPageNo=parseInt(pageNo)-1;//查询上一页
			window.location.href="teacher/showcourse?pageNo="+lPageNo ;//跳转
		}
		function getCourse(){
			var courseId = document.getElementById("num").value ;
			window.location.href="teacher/getcourse?courseId="+courseId ;//跳转
		}
		function showStudent(courseId){
			window.location.href = "teacher/showstudent?courseId="+courseId+"&pageNo=1" ;
		}
  </script>
  </body>
</html>
