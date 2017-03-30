package com.java6.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationInJava {

	public static void main(String[] args) {
		Student student = new Student();
		student.setStudentName("SDDMEWDP");
		student.setStudentId(192);
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setFirstName("SDDM");
		studentInfo.setStudentBranch("CSE");
		studentInfo.setStudentAddress("DEL");
		student.setStudentInfo(studentInfo);
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("./student_info.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(student);
			objectOutputStream.close();
			fileOutputStream.close();
			System.out.println("Serialization Complete");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
