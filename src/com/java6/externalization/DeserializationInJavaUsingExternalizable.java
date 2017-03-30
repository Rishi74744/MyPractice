package com.java6.externalization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationInJavaUsingExternalizable {

	public static void main(String[] args) {
		Student student = null;
		try{
			FileInputStream fileInputStream = new FileInputStream("./student_info_ext.txt");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			student = (Student)objectInputStream.readObject();
			objectInputStream.close();
			fileInputStream.close();
			System.out.println("Student Id : " + student.getId());
			System.out.println("Student Name : " + student.getStudentName());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
