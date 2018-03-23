package com.cn.cjj.idao;

import java.util.List;

import com.cn.cjj.pojo.Student;

public interface StudentMapper {
	public int selectCount() ;
    public List<Student> selectByPaging(int firstResult) ;
    public List<Student> selectByStudentId(String studentId) ;
    public void insertStudent(Student student) ;
    public boolean selectIsStudentId(String studentId) ;
    public void updateStudent(Student student) ;
    public void deleteStudent(String id) ;
}