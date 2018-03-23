package com.cn.cjj.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Student {
    private Integer id;

    private String studentid;

    private String name;

    private String sex;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date enrollment;

    private College collegeid;

    @Override
	public String toString() {
		return "Student [id=" + id + ", studentid=" + studentid + ", name="
				+ name + ", sex=" + sex + ", birth=" + birth + ", enrollment="
				+ enrollment + ", collegeid=" + collegeid + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid == null ? null : studentid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public Date getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Date enrollment) {
        this.enrollment = enrollment;
    }

    public College getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(College collegeid) {
        this.collegeid = collegeid;
    }
}