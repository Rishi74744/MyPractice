package com.java6.externalization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationInJavaUsingExternalizable {

	public static void main(String[] args) {
		Student student = new Student();
		student.setId(103);
		student.setStudentName("ASDED");
		try{
			FileOutputStream fileOutputStream = new FileOutputStream("./student_info_ext.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(student);
			objectOutputStream.close();
			fileOutputStream.close();
			System.out.println("Serialization Complete Using Externalizable");
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
