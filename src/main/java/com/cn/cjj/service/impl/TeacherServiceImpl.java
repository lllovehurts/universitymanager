package com.cn.cjj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.cjj.idao.CourseMapper;
import com.cn.cjj.idao.LoginMapper;
import com.cn.cjj.idao.TeacherMapper;
import com.cn.cjj.pojo.Login;
import com.cn.cjj.pojo.Teacher;
import com.cn.cjj.service.ITeacherService;

@Service("teacherService")
public class TeacherServiceImpl implements ITeacherService{
	@Resource
	private TeacherMapper teacherMapper ;
	@Resource
	private LoginMapper loginMapper ;
	@Resource
	private CourseMapper courseMapper ;
	public List<Teacher> getAll() {
		return this.teacherMapper.selectAll() ;
	}
	@Override
	public int getCount() {
		return this.teacherMapper.selectCount() ;
	}
	@Override
	public List<Teacher> getTeacherPaging(int firstResult) {
		return this.teacherMapper.selectByPaging(firstResult) ;
	}
	@Override
	public List<Teacher> getTeacher(String teacherId) {
		return this.teacherMapper.selectByTeacherId(teacherId) ;
	}
	@Override
	public void addTeacher(Teacher teacher) {
		this.teacherMapper.insertTeacher(teacher) ;
		Login login = new Login() ;
		login.setAccount(teacher.getTeacherid()) ;
		login.setRoleid(2) ;
		this.loginMapper.insertLogin(login) ;
	}
	@Override
	public boolean isTeacherId(String teacherId) {
		return this.teacherMapper.selectIsTeacherId(teacherId) ;
	}
	@Override
	public void editTeacher(Teacher teacher) {
		this.teacherMapper.updateTeacher(teacher) ;
	}
	@Override
	public void removeTeacher(String id) {
		this.teacherMapper.deleteTeacher(id) ;
		this.loginMapper.deleteLogin(id) ;
		this.courseMapper.deleteCourseByTeacherId(id) ;
	}
}