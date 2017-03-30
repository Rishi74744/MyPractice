package com.java6.serialization;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = -7456945171783095566L;
	private String studentName;
	private int studentId;
	private StudentInfo studentInfo;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public StudentInfo getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}

}
