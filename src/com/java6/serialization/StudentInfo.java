package com.java6.serialization;

import java.io.Serializable;

public class StudentInfo implements Serializable {

	private static final long serialVersionUID = -1036098627558999936L;
	private String studentBranch;
	private String studentAddress;
	transient private String firstName;
	private static int a = 20;

	public String getStudentBranch() {
		return studentBranch;
	}

	public void setStudentBranch(String studentBranch) {
		this.studentBranch = studentBranch;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public static int getA() {
		return a;
	}

	public static void setA(int a) {
		StudentInfo.a = a;
	}

}
