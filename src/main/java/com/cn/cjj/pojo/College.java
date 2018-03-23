package com.cn.cjj.pojo;

public class College {
    private Integer collegeid;

    private String collegename;

    public Integer getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }

    @Override
	public String toString() {
		return "College [collegeid=" + collegeid + ", collegename="
				+ collegename + "]";
	}

	public String getcollegename() {
        return collegename;
    }

    public void setcollegename(String collegename) {
        this.collegename = collegename == null ? null : collegename.trim();
    }
}