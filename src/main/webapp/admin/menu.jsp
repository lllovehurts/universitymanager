<%@ page contentType="text/html;charset=UTF-8" language="java" %>
	<div class="col-md-2">
    <ul class="nav nav-pills nav-stacked" id="nav">
        <li><a href="javascript:void(0)" onclick="showCourse()">课程管理<span class="glyphicon glyphicon-cog pull-right"></span></a></li>
        <li><a href="javascript:void(0)" onclick="showTeacher()">教师管理<span class="glyphicon glyphicon-cog pull-right"></span></a></li>
        <li><a href="javascript:void(0)" onclick="showStudent()">学生管理<span class="glyphicon glyphicon-cog pull-right"></span></a></li>
        <li><a href="javascript:void(0)" onclick="resetPassword()">密码重置<sapn class="glyphicon glyphicon-repeat pull-right" /></a></li>
    </ul>
	</div>
	<script type="text/javascript">
		function showCourse(){
			window.location.href="admin/showcourse?pageNo=1" ; //显示第一页
		}
		function showStudent(){
			window.location.href="admin/showstudent?pageNo=1" ; //显示第一页
		}
		function showTeacher(){
			window.location.href="admin/showteacher?pageNo=1" ; //显示第一页
		}
		function resetPassword(){
			window.location.href="admin/reset.jsp" ; //显示第一页
		}
	</script>
</body>

