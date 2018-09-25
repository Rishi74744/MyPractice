package com.java.designpatterns.decorator;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DecoratorEveryDayDemo {

	public static void main(String[] args) throws IOException {
		File file = new File("./output.txt");
		file.createNewFile();

		OutputStream outputStream = new FileOutputStream(file);

		DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
		dataOutputStream.writeChars("This is a text");

		dataOutputStream.close();
		outputStream.close();
	}

}