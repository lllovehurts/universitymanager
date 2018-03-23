package com.cn.cjj.service;

import java.util.List;

import com.cn.cjj.pojo.Record;



public interface IRecordService {
	public List<Record> findStudentToCourse(String courseId ,int firstResult) ;
	public int selectStudentToCourseCount(String courseId) ;
	public Record getRecord(int id) ;
	public void editRecord(Record record) ;
	public void addRecord(Record record) ;
	public void removeRecord(int courseId) ;
}
