package com.java6.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationInJava {

	public static void main(String[] args) {
		Student student = null;
		try {
			FileInputStream fileInputStream = new FileInputStream("./student_info.txt");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			student = (Student) objectInputStream.readObject();
			objectInputStream.close();
			fileInputStream.close();
			System.out.println("Student Name : " + student.getStudentName());
			System.out.println("Student Id : " + student.getStudentId());
			System.out.println("Student Name from info : " + student.getStudentInfo().getFirstName());
			System.out.println("a : " + student.getStudentInfo().getA());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
