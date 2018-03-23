<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
	<div class="col-md-2">
	    <ul class="nav nav-pills nav-stacked" id="nav">
	        <li><a href="javascript:void(0)" onclick="showCourse()">我的课程<span class="glyphicon glyphicon-cog pull-right"></span></a></li>
	        <li><a href="javascript:void(0)" onclick="resetPassword()">修改密码<sapn class="glyphicon glyphicon-repeat pull-right" /></a></li>
	    </ul>
	</div>
	<script type="text/javascript">
		function showCourse(){
			window.location.href="teacher/showcourse?pageNo=1" ; //显示第一页
		}
		function resetPassword(){
			window.location.href="teacher/reset.jsp" ;
		}
	</script>
</body>

