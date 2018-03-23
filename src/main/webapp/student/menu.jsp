<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-md-2">
    <ul class="nav nav-pills nav-stacked" id="nav">
        <li><a href="javascript:void(0)" onclick="showCourse()">所有课程<span class="glyphicon glyphicon-cog pull-right"></span></a></li>
        <li><a href="javascript:void(0)" onclick="showSelectedCourse()">已选课程<span class="glyphicon glyphicon-cog pull-right"></span></a></li>
        <li><a href="javascript:void(0)" onclick="showMarkedCourse()">已修课程<span class="glyphicon glyphicon-cog pull-right"></span></a></li>
        <li><a href="javascript:void(0)" onclick="resetPassword()">密码修改<sapn class="glyphicon glyphicon-repeat pull-right" /></a></li>
    </ul>
</div>
<script type="text/javascript">
	function showCourse(){
		window.location.href="student/showcourse?pageNo=1" ; //显示第一页
	}
	function showSelectedCourse(){
		window.location.href="student/showselectedcourse?pageNo=1" ; //显示第一页
	}
	function showMarkedCourse(){
		window.location.href="student/showmarkedcourse?pageNo=1" ; //显示第一页
	}
	function resetPassword(){
			window.location.href="student/reset.jsp" ;
		}
</script>
