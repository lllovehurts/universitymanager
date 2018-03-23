package com.cn.cjj.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Teacher {
    private Integer id;

    private String teacherid;

    private String teachername;

    private String sex;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date entry;

    @Override
	public String toString() {
		return "Teacher [id=" + id + ", teacherid=" + teacherid
				+ ", teachername=" + teachername + ", sex=" + sex + ", birth="
				+ birth + ", entry=" + entry + ", collegeid=" + collegeid
				+ ", position=" + position + "]";
	}

	private College collegeid;

    private String position;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid == null ? null : teacherid.trim();
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername == null ? null : teachername.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getEntry() {
        return entry;
    }

    public void setEntry(Date entry) {
        this.entry = entry;
    }

    public College getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(College collegeid) {
        this.collegeid = collegeid;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }
}