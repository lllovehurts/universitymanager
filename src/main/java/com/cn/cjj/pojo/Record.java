package com.cn.cjj.pojo;

public class Record {
    @Override
	public String toString() {
		return "Record [id=" + id + ", studentid=" + studentid + ", courseid="
				+ courseid + ", score=" + score + "]";
	}

	private Integer id;

    private Student studentid;

    private Course courseid;

    private Integer score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudentid() {
        return studentid;
    }

    public void setStudentid(Student studentid) {
        this.studentid = studentid;
    }

    public Course getCourseid() {
        return courseid;
    }

    public void setCourseid(Course courseid) {
        this.courseid = courseid;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}