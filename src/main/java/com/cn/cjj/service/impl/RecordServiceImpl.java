package com.cn.cjj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.cjj.idao.RecordMapper;
import com.cn.cjj.pojo.Record;
import com.cn.cjj.pojo.Student;
import com.cn.cjj.service.IRecordService;

@Service("recordService")
public class RecordServiceImpl implements IRecordService{
	@Resource
	private RecordMapper recordMapper ;
	public List<Record> findStudentToCourse(String courseId, int firstResult) {
		return this.recordMapper.selectStudentToCourse(courseId, firstResult) ;
	}
	public int selectStudentToCourseCount(String courseId) {
		return this.recordMapper.selectStudentToCourseCount(courseId) ;
	}
	public Record getRecord(int id) {
		return this.recordMapper.selectRecord(id) ;
	}
	public void editRecord(Record record) {
		this.recordMapper.updateRecord(record) ;
	}
	public void addRecord(Record record) {
		this.recordMapper.insertRecord(record) ;
	}
	public void removeRecord(int courseId) {
		this.recordMapper.deleteRecord(courseId) ;
	}
}
