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
    <title>添加教师信息</title>
    
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
						<h1 style="text-align: center;">添加教师信息</h1>
					</div>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" role="form" action="admin/addteacher" id="editfrom" method="post" onsubmit="return validate()">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">教师号</label>
							<div class="col-sm-5">
								<input type="number" class="form-control" id="teacherId" name="teacherid" placeholder="请输入教师号" onblur="idValidate()">
							</div>
								<span id="teacherIdV"></span>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">教师名称</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="teacherName" name="teachername" placeholder="请输入教师名称" onblur="nameValidate()">
							</div>
							<span id="teacherNameV"></span>
						</div>
						<div class="form-group">
							    <label for="inputPassword3" class="col-sm-2 control-label">性别</label>
							    <div class="col-sm-5">
								    <label class="checkbox-inline">
									   	<c:choose>
												<c:when test="${'男' eq teacher.sex}"><input type="radio" name="sex" value="男" checked>男</c:when>
												<c:otherwise><input type="radio" name="sex" value="男" checked="checked">男</c:otherwise>
										</c:choose>
									</label>
									<label class="checkbox-inline">
										<c:choose>
												<c:when test="${'女' eq teacher.sex}"><input type="radio" name="sex" value="女" checked>女</c:when>
												<c:otherwise><input type="radio" name="sex" value="女">女</c:otherwise>
										</c:choose>
									</label>
							    </div>
							  </div>
						<div class="form-group">
							    <label for="inputPassword3" class="col-sm-2 control-label">出生年份</label>
							    <div class="col-sm-5">
								    <input type="date"  id="birth" name="birth" value="1995-05-16" onblur="birthValidate()">
							    </div>
							    <span id="birthV"></span>
						</div>
						<div class="form-group">
							    <label for="inputPassword3" class="col-sm-2 control-label">入职日期</label>
							    <div class="col-sm-5">
								    <input type="date" id="entry" name="entry" value="1995-05-16" onblur="entryValidate()">
							    </div>
							    <span id="entryV"></span>
					    </div>
						<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label" name="position">职称：</label>
								<div class="col-sm-5">
									<select class="form-control" name="position">
										<c:choose>
												<c:when test="${'教师' eq teacher.position}"><option value="教师" selected="selected">教师</option></c:when>
												<c:otherwise><option value="教师">教师</option></c:otherwise>
										</c:choose>
										<c:choose>
												<c:when test="${'助教' eq teacher.position}"><option value="助教" selected="selected">助教</option></c:when>
												<c:otherwise><option value="助教">助教</option></c:otherwise>
										</c:choose>
										<c:choose>
												<c:when test="${'讲师' eq teacher.position}"><option value="讲师" selected="selected">讲师</option></c:when>
												<c:otherwise><option value="讲师">讲师</option></c:otherwise>
										</c:choose>
										<c:choose>
												<c:when test="${'副教授' eq teacher.position}"><option value="副教授" selected="selected">副教授</option></c:when>
												<c:otherwise><option value="副教授">副教授</option></c:otherwise>
										</c:choose>
										<c:choose>
												<c:when test="${'教授' eq teacher.position}"><option value="教授" selected="selected">教授</option></c:when>
												<c:otherwise><option value="教授">教授</option></c:otherwise>
										</c:choose>
									</select>
								</div>
							</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label" name="college">所属院系</label>
							<div class="col-sm-5">
								<select class="form-control" name="collegeid.collegeid">
									<c:forEach items="${collegeList}" var="item">
										<c:choose>
											<c:when test="${item.collegeid eq teacher.collegeid.collegeid}"><option value="${item.collegeid}" selected="selected">${item.collegename}</option></c:when>
											<c:otherwise><option value="${item.collegeid}">${item.collegename}</option></c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group" style="text-align: center">
							<button class="btn btn-default" type="submit">提交</button>
							<button class="btn btn-default" type="button" onClick="location.href='admin/showteacher?pageNo=1'">返回</button>
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
			var url="admin/isteacheridexist?teacherId="+str;
			xmlHttp.open("post",url,false);
			xmlHttp.onreadystatechange=hqp;
			function hqp(){
	      		if(xmlHttp.readyState==4&& xmlHttp.status==200){
		      	document.getElementById(name+"V").innerHTML=xmlHttp.responseText;
		      	flag = document.getElementById("flag").value ;
		      }else{
			     document.getElementById(name+"V").innerHTML="<p style='color:red'>正在检测教师号</p>";
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
			if(isNullValidate("teacherId")){
				if(isExist("teacherId") == 'true'){
					return true ;
				}else{
					return false ;
				}
			}else{
				return false ;
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
		function birthValidate(){
			return dateCheack("birth") ;
		}
		function entryValidate(){
			return dateCheack("entry")
		} 
		function nameValidate(){
			return isNullValidate("teacherName") ;
		}
		function validate(){
			return idValidate()&&nameValidate()&&birthValidate()&&entryValidate();
		}
	</script>
	</body>
</html>
