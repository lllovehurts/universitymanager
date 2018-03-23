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
					    	<h1 class="col-md-5">课程名单管理</h1>
						</div>
				    </div>
				    <table class="table table-bordered">
					        <thead>
					            <tr>
							  		<th>课程号</th>
							  		<th>课程名称</th>
							  		<th>授课老师</th>
							  		<th>上课时间</th>
							  		<th>上课地点</th>
							  		<th>开课学院</th>
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
							  		<td>${course.teacher.teachername}</td>
							  		<td>${course.time}</td>
							  		<td>${course.addr}</td>
							  		<td>${course.college.collegename}</td>
							  		<td>${course.type}</td>
							  		<td>${course.score}</td>
									<td>
										<button class="btn btn-default btn-xs btn-info" onClick="location.href='student/quitcourse?courseId=${course.courseid}'">退课</button>
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
			window.location.href="student/showselectedcourse?pageNo="+nPageNo ; //跳转
		}
		function lastPage(){
			var pageNo=document.getElementById("pageNo").value;//获得当前页
			if(parseInt(pageNo)==1){//当前页为首页则返回
				return;
			}
			var lPageNo=parseInt(pageNo)-1;//查询上一页
			window.location.href="student/showselectedcourse?pageNo="+lPageNo ;//跳转
		}
	</script>
  </body>
</html>
