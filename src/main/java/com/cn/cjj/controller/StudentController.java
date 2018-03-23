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
import com.cn.cjj.pojo.Student;
import com.cn.cjj.service.ICourseService;
import com.cn.cjj.service.ILoginService;
import com.cn.cjj.service.IRecordService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Resource
	private ICourseService courseService;
	@Resource
	private ILoginService loginService;
	@Resource
	private IRecordService recordService;
	@RequestMapping("/showcourse")
	public ModelAndView showCourse(HttpServletRequest request) throws Exception {
		String currentuserid = (String)SecurityUtils.getSubject().getPrincipal();
		String pageNo = request.getParameter("pageNo") ; //获得查询页
		double totalCount = (double)(courseService.getCount()-courseService.getSelectedCount(currentuserid)-courseService.getMarkedCount(currentuserid)); //总元组数 
		int pageCount = (int) Math.ceil(totalCount/6);//得到总页数	
		int firstResult = (Integer.parseInt(pageNo)-1)*6;//得到查询起始位置
		List<Course> list = courseService.getSelectCourse(firstResult) ;
		System.out.println(list.size());
		ModelAndView mav = new ModelAndView("showcourse") ;
		mav.addObject("pageCount", pageCount);//储存总页数
		mav.addObject("list", list);//储存课程信息
		request.getSession().setAttribute("pageNo", pageNo) ;
		mav.addObject("count", (int)totalCount);//储存信息总数	
		mav.addObject("pagingUI", 1);//显示切换页面，若是单一查询则隐藏
		return mav;
	}
	
	@RequestMapping("/showselectedcourse")
	public ModelAndView showSelectedCourse(HttpServletRequest request) throws Exception {
		String currentuserid = (String)SecurityUtils.getSubject().getPrincipal();
		String pageNo = request.getParameter("pageNo") ; //获得查询页
		double totalCount = (double)courseService.getSelectedCount(currentuserid) ; //总元组数 
		int pageCount = (int) Math.ceil(totalCount/6);//得到总页数	
		int firstResult = (Integer.parseInt(pageNo)-1)*6;//得到查询起始位置
		List<Course> list = courseService.getSelectedCourse(firstResult, currentuserid) ;
		ModelAndView mav = new ModelAndView("showselectcourse") ;
		mav.addObject("pageCount", pageCount);//储存总页数
		mav.addObject("list", list);//储存课程信息
		request.getSession().setAttribute("pageNo", pageNo) ;
		mav.addObject("count", (int)totalCount);//储存信息总数	
		mav.addObject("pagingUI", 1);//显示切换页面，若是单一查询则隐藏
		return mav;
	}
	@RequestMapping("/selectcourse")
	public ModelAndView selectCourse(HttpServletRequest request,String courseId) throws Exception {
		String currentuserid = (String)SecurityUtils.getSubject().getPrincipal();
		Record record = new Record() ;
		Course course = new Course() ;
		Student student = new Student() ;
		course.setCourseid(courseId) ;
		student.setStudentid(currentuserid) ;
		record.setStudentid(student) ;
		record.setCourseid(course) ;
		recordService.addRecord(record) ;
		String pageNo = (String)request.getSession().getAttribute("pageNo") ;
		ModelAndView mav = new ModelAndView("redirect:showcourse?pageNo="+pageNo) ;
		return mav;
	}
	@RequestMapping("/quitcourse")
	public ModelAndView quitCourse(HttpServletRequest request,int courseId) throws Exception {
		recordService.removeRecord(courseId) ;
		String pageNo = (String)request.getSession().getAttribute("pageNo") ;
		ModelAndView mav = new ModelAndView("redirect:showselectedcourse?pageNo="+pageNo) ;
		return mav;
	}
	@RequestMapping("/showmarkedcourse")
	public ModelAndView showMarkedCourse(HttpServletRequest request) throws Exception {
		String currentuserid = (String)SecurityUtils.getSubject().getPrincipal();
		String pageNo = request.getParameter("pageNo") ; //获得查询页
		double totalCount = (double)courseService.getMarkedCount(currentuserid) ; 
		int pageCount = (int) Math.ceil(totalCount/6);//得到总页数	
		int firstResult = (Integer.parseInt(pageNo)-1)*6;//得到查询起始位置
		List<Course> list = courseService.getMarkedCourse(firstResult, currentuserid);
		ModelAndView mav = new ModelAndView("showmarkedcourse") ;
		mav.addObject("pageCount", pageCount);//储存总页数
		mav.addObject("list", list);//储存课程信息
		request.getSession().setAttribute("pageNo", pageNo) ;
		mav.addObject("count", (int)totalCount);//储存信息总数	
		mav.addObject("pagingUI", 1);//显示切换页面，若是单一查询则隐藏
		return mav;
	}
	@RequestMapping("/editpassword")
	public ModelAndView editPassword(String password , String newPassword) throws Exception {
		String currentuserid = (String)SecurityUtils.getSubject().getPrincipal();
		Login login = loginService.findLogin(currentuserid) ;
		ModelAndView mav = new ModelAndView("/forward") ;
		if(login.getPassword().equals(password)){
			login.setPassword(newPassword) ;
			loginService.editLogin(login) ;
			mav.addObject("msg", "修改成功") ;
			mav.addObject("path", "/student/reset.jsp") ;
		}else {
			mav.addObject("msg", "原密码错误!") ;
			mav.addObject("path", "/student/reset.jsp") ;
		}
		return mav ;
	}
}	 
