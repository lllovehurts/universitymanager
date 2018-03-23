package com.cn.cjj.idao;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.cjj.pojo.Record;

public interface RecordMapper {
	public List<Record> selectStudentToCourse(@Param("courseId")String courseId, @Param("firstResult")int firstResult) ;
	public int selectStudentToCourseCount(String courseId) ;
	public Record selectRecord(int id) ;
	public void updateRecord(Record record) ;
	public void insertRecord(Record record) ;
	public void deleteRecord(int courseId) ;
}