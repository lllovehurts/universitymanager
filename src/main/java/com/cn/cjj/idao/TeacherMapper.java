package com.cn.cjj.idao;

import java.util.List;

import com.cn.cjj.pojo.Course;
import com.cn.cjj.pojo.Teacher;


public interface TeacherMapper {
	public List<Teacher> selectAll() ;
	public int selectCount() ;
    public List<Teacher> selectByPaging(int firstResult) ;
    public List<Teacher> selectByTeacherId(String teacherId) ;
    public void insertTeacher(Teacher teacher) ;
    public boolean selectIsTeacherId(String teacherId) ;
    public void updateTeacher(Teacher teacher) ;
    public void deleteTeacher(String id) ;
}