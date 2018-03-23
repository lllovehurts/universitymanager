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
    <title>添加学生信息</title>
    
  </head>
  
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
									<h1 style="text-align: center;">添加学生信息</h1>
								</div>
							</div>
							<div class="panel-body">
								<form class="form-horizontal" role="form" action="admin/addstudent" id="editfrom" method="post" onsubmit="return validate()">
									<div class="form-group">
										<label for="inputEmail3" class="col-sm-2 control-label">学号</label>
										<div class="col-sm-5">
											<input type="number" class="form-control" id="studentId" name="studentid" placeholder="请输入学号"  onblur="idValidate()">
										</div>
										<span id = "studentIdV"></span>
									</div>
									<div class="form-group">
										<label for="inputPassword3" class="col-sm-2 control-label">学生名称</label>
										<div class="col-sm-5">
											<input type="text" class="form-control" id="name" name="name" placeholder="请输入学生名称"  onblur="nameValidate()">
										</div>
										<span id="nameV"></span>	
									</div>
									<div class="form-group">
										    <label for="inputPassword3" class="col-sm-2 control-label">性别</label>
										    <div class="col-sm-5">
											    <label class="checkbox-inline">
												   	<c:choose>
															<c:when test="${'男' eq student.sex}"><input type="radio" name="sex" value="男" checked>男</c:when>
															<c:otherwise><input type="radio" name="sex" value="男" checked="checked">男</c:otherwise>
													</c:choose>
												</label>
												<label class="checkbox-inline">
													<c:choose>
															<c:when test="${'女' eq student.sex}"><input type="radio" name="sex" value="女" checked>女</c:when>
															<c:otherwise><input type="radio" name="sex" value="女">女</c:otherwise>
													</c:choose>
												</label>
										    </div>
										  </div>
									<div class="form-group">
										    <label for="inputPassword3" class="col-sm-2 control-label">出生年份</label>
										    <div class="col-sm-5">
											    <input type="date"  value="1995-05-16" id="birth" name="birth" onblur="birthValidate()"/>
										    </div>
										    <span id="birthV"></span>
									</div>
									<div class="form-group">
										    <label for="inputPassword3" class="col-sm-2 control-label">入学日期</label>
										    <div class="col-sm-5">
											    <input type="date" value="1995-05-16" id="enrollment" name="enrollment" onblur="enrollmentValidate()">
										    </div>
										    <span id="enrollmentV"></span>
								    </div>
									<div class="form-group">
										<label for="inputPassword3" class="col-sm-2 control-label" name="collegeid">所属院系</label>
										<div class="col-sm-5">
											<select class="form-control" name="collegeid.collegeid">
												<c:forEach items="${collegeList}" var="item">
													<c:choose>
														<c:when test="${item.collegeid eq student.collegeid}"><option value="${item.collegeid}" selected="selected">${item.collegename}</option></c:when>
														<c:otherwise><option value="${item.collegeid}">${item.collegename}</option></c:otherwise>
													</c:choose>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group" style="text-align: center">
										<button class="btn btn-default" type="submit">提交</button>
										<button class="btn btn-default" type="button" onClick="location.href='admin/showstudent?pageNo=1'">返回</button>
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
			var url="admin/isstudentidexist?studentId="+str;
			xmlHttp.open("post",url,false);
			xmlHttp.onreadystatechange=hqp;
			function hqp(){
	      		if(xmlHttp.readyState==4&& xmlHttp.status==200){
		      	document.getElementById(name+"V").innerHTML=xmlHttp.responseText;
		      	flag = document.getElementById("flag").value ;
		      }else{
			     document.getElementById(name+"V").innerHTML="<p style='color:red'>正在检测学号</p>";
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
		function dateCheack(name){
			var a = /^(\d{4})-(\d{2})-(\d{2})$/
			if (!a.test(document.getElementById(name).value)) { 
				document.getElementById(name+"V").innerHTML="<p style='color:red'>日期格式为yyyy-MM-dd</p>" ;
				return false 
			} 
			else
				document.getElementById(name+"V").innerHTML="<p style='color:green'>填写正确</p>" ;
				return true 
		} 
		function idValidate(){
			if(isNullValidate("studentId")){
				if(isExist("studentId") == 'true'){
					return true ;
				}else{
					return false ;
				}
			}else{
				return false ;
			} 
		}
		function nameValidate(){
			return isNullValidate("name") ;
		}
		function birthValidate(){
			return dateCheack("birth") ;
		}
		function enrollmentValidate(){
			return dateCheack("enrollment")
		}
		function validate(){
			return idValidate()&&nameValidate()&&birthValidate()&&enrollmentValidate();
		}
	</script>
  </body>
</html>
