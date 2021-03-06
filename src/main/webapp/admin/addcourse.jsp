<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>添加课程信息</title>
    
  </head>
  <!-- 顶栏 -->
  <body>
	<jsp:include page="top.jsp"></jsp:include>
	<div class="container" id="content">
		<div class="row">
			<jsp:include page="menu.jsp"></jsp:include>
			<div id="right">
				<div class="col-md-10">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="row">
						<h1 style="text-align: center;">添加课程信息</h1>
					</div>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" role="form" action="admin/addcourse" id="editfrom" method="post" onsubmit="return validate()">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">课程号</label>
							<div class="col-sm-5">
								<input type="number" class="form-control" id="courseId" name="courseid" placeholder="请输入课程号" value="${course.courseid}" onblur="idValidate()">
							</div>
							<span id = "courseIdV"></span>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">课程名称</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="courseName" name="name" placeholder="请输入课程名称" value="${course.name}" onblur="nameValidate()">
							</div>
							<span id="courseNameV"></span>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label" name="teacher">授课老师编号</label>
							<div class="col-sm-5">
								<select class="form-control" name="teacher.teacherid">
									<c:forEach items="${teacherList}" var="item">
										<c:choose>
											<c:when test="${item.teacherid eq course.teacher.teacherid}"><option value="${item.teacherid}" selected="selected">${item.teacherid}-${item.teachername}</option></c:when>
											<c:otherwise><option value="${item.teacherid}">${item.teacherid}-${item.teachername}</option></c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">上课时间</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="time" name="time" placeholder="请输入上课时间" value="${course.time}" onblur="timeValidate()">
							</div>
							<span id="timeV"></span>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">上课地点</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="addr" name="addr" placeholder="上课地点" value="${course.addr}" onblur="addrValidate()">
							</div>
							<span id="addrV"></span>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label" name="type">课程的类型：</label>
							<div class="col-sm-5">
								<select class="form-control" name="type">
									<c:choose>
										<c:when test="${'专业课' eq course.type}"><option value="专业课" selected="selected">专业课</option></c:when>
										<c:otherwise><option value="专业课">专业课</option></c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${'选修课' eq course.type}"><option value="选修课" selected="selected">选修课</option></c:when>
										<c:otherwise><option value="选修课">选修课</option></c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${'基础课' eq course.type}"><option value="基础课" selected="selected">基础课</option></c:when>
										<c:otherwise><option value="基础课">基础课</option></c:otherwise>
									</c:choose>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label" name="college">所属院系</label>
							<div class="col-sm-5">
								<select class="form-control" name="college.collegeid">
									<c:forEach items="${collegeList}" var="item">
										<c:choose>
											<c:when test="${item.collegeid eq course.college}"><option value="${item.college}" selected="selected">${item.collegename}</option></c:when>
											<c:otherwise><option value="${item.collegeid}">${item.collegename}</option></c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">学分：</label>
								<div class="col-sm-5">
								<select class="form-control" name="score">
									<c:choose>
										<c:when test="${course.score==1}"><option value="1" selected="selected">1</option></c:when>
										<c:otherwise><option value="1">1</option></c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${course.score==2}"><option value="2" selected="selected">2</option></c:when>
										<c:otherwise><option value="2">2</option></c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${course.score==3}"><option value="3" selected="selected">3</option></c:when>
										<c:otherwise><option value="3">3</option></c:otherwise>
									</c:choose>
								</select>
							</div>
						</div>
						<div class="form-group" style="text-align: center">
							<button class="btn btn-default" type="submit">提交</button>
							<button class="btn btn-default" type="button" onClick="location.href='admin/showcourse?pageNo=1'">返回</button>
						</div>
					</form>
				</div>
			</div>
		</div>
			</div><!-- AJAX -->
		</div>
	</div>
	<script type="text/javascript">
		function getXMLHttp(){
			var xmlHttp=false;
			if(window.XMLHttpRequest){
				xmlHttp=new XMLHttpRequest();
			}
			else if(window.ActiveXObject){
				try{
					xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");				
				}catch (e) {
					try{
						xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
					}catch (e) {
						window.alert("该浏览器不支持AJAX");
					}
				}
			}
			return xmlHttp;
		}
		function isExist(name){
			var flag ;
			var str = document.getElementById(name).value ;
			var xmlHttp=getXMLHttp();
			var url="admin/iscourseidexist?courseId="+str;
			xmlHttp.open("post",url,false);
			xmlHttp.onreadystatechange=hqp;
			function hqp(){
	      		if(xmlHttp.readyState==4&& xmlHttp.status==200){
		      	document.getElementById(name+"V").innerHTML=xmlHttp.responseText;
		      	flag = document.getElementById("flag").value ;
		      }else{
			     document.getElementById(name+"V").innerHTML="<p style='color:red'>正在检测课程号</p>";
		      }
			}
			xmlHttp.send();
			return flag ;
		}
		function isNullValidate(name){
			var str = document.getElementById(name).value ;
			if(str.length == 0){
				document.getElementById(name+"V").innerHTML="<p style='color:red'>不能为空</p>" ;
				return false ;
			}else{
				document.getElementById(name+"V").innerHTML="<p style='color:green'>填写正确</p>" ;
				return true ;
			}
		}
		function idValidate(){
			if(isNullValidate("courseId")){
				if(isExist("courseId") == 'true'){
					return true ;
				}else{
					return false ;
				}
			}else{
				return false ;
			} 
		}
		function nameValidate(){
			return isNullValidate("courseName") ;
		}
		function addrValidate(){
			return isNullValidate("addr") ;
		}
		function timeValidate(){
			return isNullValidate("time") ;
		}
		function validate(){
			return idValidate()&&nameValidate()&&addrValidate()&&timeValidate();
		}
	</script>
	</body>
</html>
