package com.cn.cjj.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.cjj.pojo.College;
import com.cn.cjj.pojo.Course;
import com.cn.cjj.pojo.Login;
import com.cn.cjj.pojo.Student;
import com.cn.cjj.pojo.Teacher;
import com.cn.cjj.service.ICollegeService;
import com.cn.cjj.service.ICourseService;
import com.cn.cjj.service.ILoginService;
import com.cn.cjj.service.IStudentService;
import com.cn.cjj.service.ITeacherService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource
	private ICourseService courseService ;
	@Resource
	private ITeacherService teacherService ;
	@Resource
	private ICollegeService collegeService ;
	@Resource
	private IStudentService studentService ;
	@Resource
	private ILoginService loginService ;
	@RequestMapping("/showcourse")
	public ModelAndView showCourse(HttpServletRequest request) throws Exception {
		String pageNo = request.getParameter("pageNo") ; //获得查询页
		double totalCount = (double)courseService.getCount() ; //总元组数 
		int pageCount = (int) Math.ceil(totalCount/6);//得到总页数	
		int firstResult = (Integer.parseInt(pageNo)-1)*6;//得到查询起始位置
		List<Course> list = courseService.getCoursePaging(firstResult);
		ModelAndView mav = new ModelAndView("showcourse") ;
		mav.addObject("pageCount", pageCount);//储存总页数
		mav.addObject("list", list);//储存课程信息
		mav.addObject("pageNo", pageNo);//储存当前页数
		mav.addObject("count", (int)totalCount);//储存信息总数	
		mav.addObject("pagingUI", 1);//显示切换页面，若是单一查询则隐藏
		return mav;
	}
	@RequestMapping("/showstudent")
	public ModelAndView showStudent(String pageNo) throws Exception {
		double totalCount = (double)studentService.getCount() ; //总元组数 
		int pageCount = (int) Math.ceil(totalCount/6);//得到总页数	
		int firstResult = (Integer.parseInt(pageNo)-1)*6;//得到查询起始位置
		List<Student> list = studentService.getStudentPaging(firstResult) ;
		ModelAndView mav = new ModelAndView("showstudent") ;
		mav.addObject("pageCount", pageCount);//储存总页数
		mav.addObject("list", list);//储存课程信息
		mav.addObject("pageNo", pageNo);//储存当前页数
		mav.addObject("count", (int)totalCount);//储存信息总数	
		mav.addObject("pagingUI", 1);//显示切换页面，若是单一查询则隐藏
		return mav;
	}
	@RequestMapping("/showteacher")
	public ModelAndView showTeacher(String pageNo) throws Exception {
		double totalCount = (double)teacherService.getCount() ; //总元组数 
		int pageCount = (int) Math.ceil(totalCount/6);//得到总页数	
		int firstResult = (Integer.parseInt(pageNo)-1)*6;//得到查询起始位置
		List<Teacher> list = teacherService.getTeacherPaging(firstResult) ;
		ModelAndView mav = new ModelAndView("showteacher") ;
		mav.addObject("pageCount", pageCount);//储存总页数
		mav.addObject("list", list);//储存课程信息
		mav.addObject("pageNo", pageNo);//储存当前页数
		mav.addObject("count", (int)totalCount);//储存信息总数	
		mav.addObject("pagingUI", 1);//显示切换页面，若是单一查询则隐藏
		return mav;
	}
	@RequestMapping("/getcourse")
	public ModelAndView getCourse(HttpServletRequest request) throws Exception {
		String courseId = request.getParameter("courseId") ;
		List<Course> list = courseService.getCourse(courseId) ;
		ModelAndView mav = new ModelAndView("showcourse") ;
		mav.addObject("list", list);//储存课程信息
		mav.addObject("pagingUI", null);//显示切换页面，若是单一查询则隐藏
		return mav;
	}
	@RequestMapping("/getstudent")
	public ModelAndView getStudent(String studentId) throws Exception {
		List<Student> list = studentService.getStudent(studentId) ;
		ModelAndView mav = new ModelAndView("showstudent") ;
		mav.addObject("list", list);//储存课程信息
		mav.addObject("pagingUI", null);//显示切换页面，若是单一查询则隐藏
		return mav;
	}
	@RequestMapping("/getteacher")
	public ModelAndView getTeacher(String teacherId) throws Exception {
		List<Teacher> list = teacherService.getTeacher(teacherId) ;
		ModelAndView mav = new ModelAndView("showteacher") ;
		mav.addObject("list", list);//储存课程信息
		mav.addObject("pagingUI", null);//显示切换页面，若是单一查询则隐藏
		return mav;
	}
	@RequestMapping("/addcoursepage")
	public ModelAndView addCoursePage() throws Exception {
		ModelAndView mav=new ModelAndView("addcourse");
		List<Teacher> teacherList = teacherService.getAll() ;
		List<College> collegeList = collegeService.getAll() ;
		mav.addObject("teacherList", teacherList);
		mav.addObject("collegeList", collegeList);
		return mav;
	}
	@RequestMapping("/addstudentpage")
	public ModelAndView addStudentPage() throws Exception {
		ModelAndView mav=new ModelAndView("addstudent");
		List<College> collegeList = collegeService.getAll() ;
		mav.addObject("collegeList", collegeList);
		return mav;
	}
	@RequestMapping("/addteacherpage")
	public ModelAndView addTeacherPage() throws Exception {
		ModelAndView mav=new ModelAndView("addteacher");
		List<College> collegeList = collegeService.getAll() ;
		mav.addObject("collegeList", collegeList);
		return mav;
	}
	@RequestMapping("/iscourseidexist")
	public ModelAndView isCourseIdExist(String courseId) throws Exception {
		ModelAndView mav=new ModelAndView("isexist");
		if(!courseService.isCourseId(courseId)){
			mav.addObject("msg","<p style='color:green'>课程号可用</p>");
			mav.addObject("exist", "true");
		}else {
			mav.addObject("msg","<p style='color:red'>课程号已经存在</p>");
			mav.addObject("exist", "false");
		}
		return mav;
	}
	@RequestMapping("/isteacheridexist")
	public ModelAndView isTeacherIdExist(String teacherId) throws Exception {
		ModelAndView mav=new ModelAndView("isexist");
		if(!teacherService.isTeacherId(teacherId)){
			mav.addObject("msg","<p style='color:green'>教师号可用</p>");
			mav.addObject("exist", "true");
		}else {
			mav.addObject("msg","<p style='color:red'>教师号已经存在</p>");
			mav.addObject("exist", "false");
		}
		return mav;
	}
	@RequestMapping("/isstudentidexist")
	public ModelAndView isStudentIdExist(String studentId) throws Exception {
		ModelAndView mav=new ModelAndView("isexist");
		if(!studentService.isStudentId(studentId)){
			mav.addObject("msg","<p style='color:green'>学号可用</p>");
			mav.addObject("exist", "true");
		}else {
			mav.addObject("msg","<p style='color:red'>学号已经存在</p>");
			mav.addObject("exist", "false");
		}
		return mav;
	}
	@RequestMapping("/addcourse")
	public ModelAndView addCourse(Course course) throws Exception {
		courseService.addCourse(course) ;
		ModelAndView mav=new ModelAndView("/forward");
		mav.addObject("msg", "添加成功!") ;
		mav.addObject("path", "/admin/addcoursepage") ;
		return mav;
	}
	@RequestMapping("/addstudent")
	public ModelAndView addStudent(Student student) throws Exception {
		studentService.addStudent(student) ;
		ModelAndView mav=new ModelAndView("/forward");
		mav.addObject("msg", "添加成功!") ;
		mav.addObject("path", "/admin/addstudentpage") ;
		return mav;
	}
	@RequestMapping("/addteacher")
	public ModelAndView addTeacher(Teacher teacher) throws Exception {
		teacherService.addTeacher(teacher) ;
		ModelAndView mav=new ModelAndView("/forward");
		mav.addObject("msg", "添加成功!") ;
		mav.addObject("path", "/admin/addteacherpage") ;
		return mav;
	}
	@RequestMapping("/editcoursepage")
	public ModelAndView editCoursePage(String courseId) throws Exception {
		ModelAndView mav=new ModelAndView("updatecourse");
		List<Teacher> teacherList = teacherService.getAll();
		List<College> collegeList = collegeService.getAll();
		mav.addObject("teacherList", teacherList);
		mav.addObject("collegeList", collegeList);
		List<Course> course=courseService.getCourse(courseId) ;
		mav.addObject("update",course);
		return mav;
	}
	@RequestMapping("/editstudentpage")
	public ModelAndView editStudentPage(String studentId) throws Exception {
		ModelAndView mav=new ModelAndView("updatestudent");
		List<College> collegeList = collegeService.getAll();
		mav.addObject("collegeList", collegeList);
		List<Student> student=studentService.getStudent(studentId) ;
		mav.addObject("update",student);
		return mav;
	}
	@RequestMapping("/editteacherpage")
	public ModelAndView editTeacherPage(String teacherId) throws Exception {
		ModelAndView mav=new ModelAndView("updateteacher");
		List<College> collegeList = collegeService.getAll();
		mav.addObject("collegeList", collegeList);
		List<Teacher> teacher=teacherService.getTeacher(teacherId) ;
		mav.addObject("update",teacher);
		return mav;
	}
	@RequestMapping("/editcourse")
	public ModelAndView editCourse(Course course) throws Exception {
		courseService.editCourse(course) ;
		ModelAndView mav=new ModelAndView("/forward");
		mav.addObject("msg", "修改成功!") ;
		mav.addObject("path", "/admin/showcourse?pageNo=1") ;
		return mav;
	}
	@RequestMapping("/editstudent")
	public ModelAndView editStudent(Student student) throws Exception {
		studentService.editStudent(student) ;
		ModelAndView mav=new ModelAndView("/forward");
		mav.addObject("msg", "修改成功!") ;
		mav.addObject("path", "/admin/showstudent?pageNo=1") ;
		return mav;
	}
	@RequestMapping("/editteacher")
	public ModelAndView editTeacher(Teacher teacher) throws Exception {
		teacherService.editTeacher(teacher) ;
		ModelAndView mav=new ModelAndView("/forward");
		mav.addObject("msg", "修改成功!") ;
		mav.addObject("path", "/admin/showteacher?pageNo=1") ;
		return mav;
	}
	@RequestMapping("/removecourse")
	public ModelAndView removeCourse(int id) throws Exception {
		courseService.removeCourse(id) ;
		ModelAndView mav=new ModelAndView("/forward");
		mav.addObject("msg", "删除成功!") ;
		mav.addObject("path", "/admin/showcourse?pageNo=1") ;
		return mav;
	}
	@RequestMapping("/removestudent")
	public ModelAndView removeStudent(String id) throws Exception {
		studentService.removeStudent(id) ;
		ModelAndView mav=new ModelAndView("/forward");
		mav.addObject("msg", "删除成功!") ;
		mav.addObject("path", "/admin/showstudent?pageNo=1") ;
		return mav;
	}
	@RequestMapping("/removeteacher")
	public ModelAndView removeTeacher(String id) throws Exception {
		teacherService.removeTeacher(id) ;
		ModelAndView mav=new ModelAndView("/forward");
		mav.addObject("msg", "删除成功!") ;
		mav.addObject("path", "/admin/showteacher?pageNo=1") ;
		return mav;
	}
	@RequestMapping("/findpassword")
	public ModelAndView findPassword(String account) throws Exception {
		Login login = loginService.findLogin(account) ;
		ModelAndView mav = new ModelAndView("reset") ;
		if(login == null){
			mav.addObject("accountMsg", "账号不存在") ;
			return mav ;
		}else{
			mav.addObject("login", login) ;
			return mav ;
		}
	}
	@RequestMapping("/editpassword")
	public ModelAndView editPassword(String account , String newPassword) throws Exception {
		Login login = loginService.findLogin(account) ;
		ModelAndView mav ;
		if(login == null){
			mav = new ModelAndView("reset") ;
			mav.addObject("accountMsg", "账号不存在") ;
			return mav ;
		}else{
			login.setPassword(newPassword) ;
			loginService.editLogin(login) ;
			mav = new ModelAndView("/forward") ;
			mav.addObject("msg", "修改成功!") ;
			mav.addObject("path", "/admin/reset.jsp") ;
			return mav ;
		}
	}
}
	