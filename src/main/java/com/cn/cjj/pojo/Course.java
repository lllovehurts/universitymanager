package com.cn.cjj.pojo;



public class Course {
    private Integer id;
    private String name;
    private Teacher teacher;
    private String time;
    private String addr;
    private Integer score;
    private College college;
    private String type;
    @Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", teacher=" + teacher
				+ ", time=" + time + ", addr=" + addr + ", score=" + score
				+ ", college=" + college + ", type=" + type + ", courseid="
				+ courseid + "]";
	}
	private String courseid;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }
    public String getAddr() {
        return addr;
    }
    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }
    public Integer getScore() {
        return score;
    }
    public void setScore(Integer score) {
        this.score = score;
    }
    public College getCollege() {
        return college;
    }
    public void setCollege(College college) {
        this.college = college;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
    public String getCourseid() {
        return courseid;
    }
    public void setCourseid(String courseid) {
        this.courseid = courseid == null ? null : courseid.trim();
    }
}