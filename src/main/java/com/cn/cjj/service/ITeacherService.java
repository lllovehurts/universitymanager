package com.cn.cjj.service;

import java.util.List;

import com.cn.cjj.pojo.Course;
import com.cn.cjj.pojo.Teacher;

public interface ITeacherService {
	public List<Teacher> getAll() ;
	public int getCount() ;
	public List<Teacher> getTeacherPaging(int firstResult) ;
	public List<Teacher> getTeacher(String teacherId) ;
	public void addTeacher(Teacher teacher) ;
	public boolean isTeacherId(String teacherId) ;
	public void editTeacher(Teacher teacher) ;
	public void removeTeacher(String id) ;
}
