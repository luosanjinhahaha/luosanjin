package com.smxy.healthmedical.bean;
public class User {
	private int id;
	private String username;
	private String password;
	private String repwd;
	private String realname;
	private String age;
	private String sex;
	private String phone;
	private String email;
	public User() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public User(int id, String username, String password, String repwd,
			String realname, String age, String sex, String phone, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.repwd = repwd;
		this.realname = realname;
		this.age = age;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepwd() {
		return repwd;
	}
	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", repwd=" + repwd + ", realname=" + realname
				+ ", age=" + age + ", sex=" + sex + ", phone=" + phone
				+ ", email=" + email + "]";
	}
}
