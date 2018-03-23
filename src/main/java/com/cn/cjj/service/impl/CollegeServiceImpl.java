package com.cn.cjj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.cjj.idao.CollegeMapper;
import com.cn.cjj.pojo.College;
import com.cn.cjj.service.ICollegeService;

@Service("collegeService")
public class CollegeServiceImpl implements ICollegeService{
	@Resource
	private CollegeMapper collegeMapper ;
	public List<College> getAll() {
		return this.collegeMapper.selectAll();
	}
	
}
