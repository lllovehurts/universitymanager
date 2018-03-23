package com.cn.cjj.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.cjj.pojo.Course;
import com.cn.cjj.pojo.Login;
import com.cn.cjj.pojo.Record;
import com.cn.cjj.service.ICollegeService;
import com.cn.cjj.service.ICourseService;
import com.cn.cjj.service.ILoginService;
import com.cn.cjj.service.IRecordService;
import com.cn.cjj.service.IStudentService;
import com.cn.cjj.service.ITeacherService;


@Controller
@RequestMapping("/teacher")
public class TeacherController {
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
	@Resource
	private IRecordService recordService ;
	@RequestMapping("/showcourse")
	public ModelAndView showCourse(HttpServletRequest request) throws Exception {
		String currentuserid = (String)SecurityUtils.getSubject().getPrincipal();//获得教师编号
		String pageNo = request.getParameter("pageNo") ; //获得查询页
		double totalCount = (double)courseService.getCountByTeacherId(currentuserid) ; //总元组数 
		int pageCount = (int) Math.ceil(totalCount/6);//得到总页数	
		int firstResult = (Integer.parseInt(pageNo)-1)*6;//得到查询起始位置
		List<Course> list = courseService.getCourseByTeacherId(firstResult, currentuserid);
		ModelAndView mav = new ModelAndView("showcourse") ;
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
	@RequestMapping("/showstudent")
	public ModelAndView showStudent(HttpServletRequest request) throws Exception {
		String courseId = request.getParameter("courseId") ;
		String pageNo = request.getParameter("pageNo") ; //获得查询页
		double totalCount = (double)recordService.selectStudentToCourseCount(courseId) ; //总元组数 
		int pageCount = (int) Math.ceil(totalCount/6);//得到总页数	
		int firstResult = (Integer.parseInt(pageNo)-1)*6;//得到查询起始位置
		List<Record> list = recordService.findStudentToCourse(courseId, firstResult);
		ModelAndView mav = new ModelAndView("showstudent") ;
		mav.addObject("pageCount", pageCount);//储存总页数
		mav.addObject("list", list);//储存课程信息
		request.getSession().setAttribute("pageNo", pageNo) ;
		request.getSession().setAttribute("courseId", courseId) ;
		mav.addObject("count", (int)totalCount);//储存信息总数
		mav.addObject("pagingUI", 1);//显示切换页面，若是单一查询则隐藏
		return mav;
	}
	@RequestMapping("/markpage")
	public ModelAndView markPage(int recordId) throws Exception {
		ModelAndView mav = new ModelAndView("markpage") ;
		Record record = recordService.getRecord(recordId) ;
		mav.addObject("record", record) ;
		return mav;
	}
	@RequestMapping("/mark")
	public ModelAndView mark(HttpServletRequest request,Record record) throws Exception {
		String pageNo = (String)request.getSession().getAttribute("pageNo") ;
		String courseId = (String)request.getSession().getAttribute("courseId") ;
		ModelAndView mav = new ModelAndView("redirect:showstudent?pageNo="+pageNo+"&courseId="+courseId) ;
		recordService.editRecord(record) ;
		return mav ;
	}
	@RequestMapping("/editpassword")
	public ModelAndView editPassword(String password , String newPassword) throws Exception {
		String currentuserid = (String)SecurityUtils.getSubject().getPrincipal();//获得教师编号
		Login login = loginService.findLogin(currentuserid) ;
		ModelAndView mav = new ModelAndView("/forward") ;
		if(login.getPassword().equals(password)){
			login.setPassword(newPassword) ;
			loginService.editLogin(login) ;
			mav.addObject("msg", "修改成功") ;
			mav.addObject("path", "/teacher/reset.jsp") ;
		}else {
			mav.addObject("msg", "原密码错误!") ;
			mav.addObject("path", "/teacher/reset.jsp") ;
		}
		return mav ;
	}
}
	