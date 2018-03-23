package com.cn.cjj.service;

import java.util.List;
import com.cn.cjj.pojo.Course;

public interface ICourseService {
	public int getCount() ;
	public List<Course> getCoursePaging(int firstResult) ;
	public List<Course> getCourse(String courseId) ;
	public void addCourse(Course course) ;
	public boolean isCourseId(String courseId) ;
	public void editCourse(Course course) ;
	public void removeCourse(int id) ;
	public int getCountByTeacherId(String teacherId) ;
	public List<Course> getCourseByTeacherId(int firstResult , String teacherId) ;
	public List<Course> getSelectedCourse(int firstResult ,String studentId) ; 
	public int getSelectedCount(String studentId) ;
	public void removeByTeacherId(String teacherId) ;
	public List<Course> getSelectCourse(int firstResult) ; 
	public List<Course> getMarkedCourse(int firstResult ,String studentId) ;
	public int getMarkedCount(String studentId) ;
}
 