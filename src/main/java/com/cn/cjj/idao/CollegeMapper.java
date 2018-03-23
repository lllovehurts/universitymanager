package com.cn.cjj.idao;

import java.util.List;

import com.cn.cjj.pojo.College;

public interface CollegeMapper {
    List<College> selectAll(); //查询全部学院
}