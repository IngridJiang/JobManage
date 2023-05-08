package com.lero.model;

public class Student {
	private int studentId;
	private String stuNum;
	private String name;
	private String password;
	private int jianliId;
	private String city;
	private String userName;
	private String email;
	private String sex;
	private String tel;
	
	public Student() {
	}
	
	public Student(String userName, String password) {
		this.stuNum = userName;
		this.userName = userName;
		this.password = password;
	}
	
	
	public Student(String stuNum, String password, int jianliId,
			String city, String name, String sex, String tel,String email) {
		this.stuNum = stuNum;
		this.userName = stuNum;
		this.password = password;
		this.jianliId = jianliId;
		this.email = email;
		this.name = name;
		this.sex = sex;
		this.tel = tel;
                this.city = city;
	}

	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
		this.stuNum = userName;
	}
	public String getStuNum() {
		return stuNum;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
		this.userName = stuNum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getjianliId() {
		return jianliId;
	}

	public void setjianliId(int jianliId) {
		this.jianliId = jianliId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
