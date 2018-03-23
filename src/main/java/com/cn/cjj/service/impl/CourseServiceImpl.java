package com.cn.cjj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.cjj.idao.CourseMapper;
import com.cn.cjj.pojo.Course;
import com.cn.cjj.service.ICourseService;

@Service("courseService")
public class CourseServiceImpl implements ICourseService{
	@Resource
	private CourseMapper courseMapper ;
	public int getCount() {
		return this.courseMapper.selectCount() ;
	}
	public List<Course> getCoursePaging(int firstResult) {
		return this.courseMapper.selectByPaging(firstResult);
	}
	public List<Course> getCourse(String courseId) {
		return this.courseMapper.selectByCourseId(courseId) ;
	}
	public void addCourse(Course course) {
		this.courseMapper.insertCourse(course);
	}
	public boolean isCourseId(String courseId) {
		return this.courseMapper.selectIsCourseId(courseId);
	}
	public void editCourse(Course course) {
		this.courseMapper.updateCourse(course) ;
	}
	public void removeCourse(int id) {
		this.courseMapper.deleteCourse(id) ;
	}
	public int getCountByTeacherId(String teacherId) {
		return this.courseMapper.selectCountByTeacherId(teacherId) ;
	}
	public List<Course> getCourseByTeacherId(int firstResult, String teacherId) {
		return this.courseMapper.selectByPagingTeacherId(teacherId, firstResult) ;
	}
	public List<Course> getSelectedCourse(int firstResult, String studentId) {
		return this.courseMapper.selectSelectedCourse(studentId, firstResult);
	}
	public int getSelectedCount(String studentId) {
		return this.courseMapper.selectSelectedCount(studentId) ;
	}
	public void removeByTeacherId(String teacherId) {
		this.courseMapper.deleteCourseByTeacherId(teacherId) ;
	}
	public List<Course> getSelectCourse(int firstResult) {
		return this.courseMapper.selectSelectCourse( firstResult) ;
	}
	public List<Course> getMarkedCourse(int firstResult, String studentId) {
		return this.courseMapper.selectMarkedCourse(studentId, firstResult) ;
	}
	public int getMarkedCount(String studentId) {
		return this.courseMapper.selectMarkedCount(studentId) ;
	}
}
