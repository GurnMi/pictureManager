package com.dgit.domain;

import java.util.Date;

public class FileVO {
	private String fullName ;
	private String userid;
	private Date regdate;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "FileVO [fullName=" + fullName + ", userid=" + userid + ", regdate=" + regdate + "]";
	}
	
	
}
