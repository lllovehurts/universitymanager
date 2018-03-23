package com.cn.cjj.service;

import java.util.List;

import com.cn.cjj.pojo.Course;
import com.cn.cjj.pojo.Student;


public interface IStudentService {
	public int getCount() ;
	public List<Student> getStudentPaging(int firstResult) ;
	public List<Student> getStudent(String sudentId) ;
	public void addStudent(Student student) ;
	public boolean isStudentId(String studentId) ;
	public void editStudent(Student student) ;
	public void removeStudent(String id) ;
}
