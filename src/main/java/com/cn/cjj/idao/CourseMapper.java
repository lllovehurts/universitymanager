package com.cn.cjj.idao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.cjj.pojo.Course;


public interface CourseMapper {
    public int selectCount() ;
    public List<Course> selectByPaging(int firstResult) ;
    public List<Course> selectByCourseId(String courseId) ;
    public void insertCourse(Course course) ;
    public boolean selectIsCourseId(String courseId) ;
    public void updateCourse(Course course) ;
    public void deleteCourse(int id) ;
    public int selectCountByTeacherId(String teacherId) ;
    public List<Course> selectByPagingTeacherId(@Param("teacherId")String teacherId, @Param("firstResult")int firstResult) ;
    public List<Course> selectSelectedCourse(@Param("studentId")String studentId, @Param("firstResult")int firstResult) ;
    public int selectSelectedCount(String studentId) ;
    public void deleteCourseByTeacherId(String teacherId) ;
    public List<Course> selectSelectCourse( @Param("firstResult")int firstResult) ;
    public List<Course> selectMarkedCourse(@Param("studentId")String studentId, @Param("firstResult")int firstResult) ;
    public int selectMarkedCount(String studentId) ;
}