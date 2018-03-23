<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
%>

<script>
	alert("${msg}");
	window.location.href="<%=basePath%>/universitymanager5${path}";
</script>