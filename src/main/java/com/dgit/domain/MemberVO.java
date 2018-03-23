package com.dgit.domain;

public class MemberVO {
	private String userid;
	private String userpw;
	private String username;	
	private String email;
	private String phone;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", username=" + username + ", userpw=" + userpw + ", email=" + email
				+ ", phone=" + phone + "]";
	}

	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberVO(String userid, String username, String userpw, String email, String phone) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpw = userpw;
		this.email = email;
		this.phone = phone;
	}

}
