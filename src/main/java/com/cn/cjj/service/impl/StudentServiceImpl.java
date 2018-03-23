package com.cn.cjj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.cjj.idao.LoginMapper;
import com.cn.cjj.idao.StudentMapper;
import com.cn.cjj.pojo.Login;
import com.cn.cjj.pojo.Student;
import com.cn.cjj.service.IStudentService;

@Service("studentService")
public class StudentServiceImpl implements IStudentService{
	@Resource
	private StudentMapper studentMapper ;
	@Resource
	private LoginMapper loginMapper ;
	@Override
	public int getCount() {
		return this.studentMapper.selectCount();
	}
	@Override
	public List<Student> getStudentPaging(int firstResult) {
		return this.studentMapper.selectByPaging(firstResult);
	}
	@Override
	public List<Student> getStudent(String studentId) {
		return this.studentMapper.selectByStudentId(studentId);
	}
	@Override
	public void addStudent(Student student) {
		this.studentMapper.insertStudent(student) ;
		Login login = new Login() ;
		login.setAccount(student.getStudentid()) ;
		login.setRoleid(3) ;
		loginMapper.insertLogin(login) ;
	}
	@Override
	public boolean isStudentId(String studentId) {
		return this.studentMapper.selectIsStudentId(studentId) ;
	}

	@Override
	public void editStudent(Student student) {
		this.studentMapper.updateStudent(student) ;
	}
	@Override
	public void removeStudent(String id) {
		this.studentMapper.deleteStudent(id) ;
		this.loginMapper.deleteLogin(id) ;
	}
}
