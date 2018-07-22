package com.java.hackerrank.warmup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TimeConversion {

	/*
	 * Complete the timeConversion function below.
	 */
	static String timeConversion(String s) {
		String t = s.split(":")[2].split("")[2];
		String ft;
		if ("P".equals(t)) {
			if (Integer.parseInt(s.split(":")[0]) == 12) {
				ft = "12:" + s.split(":")[1] + ":" + s.split(":")[2].split("")[0] + s.split(":")[2].split("")[1];
			} else {
				ft = (Integer.parseInt(s.split(":")[0]) + 12) + ":" + s.split(":")[1] + ":"
						+ s.split(":")[2].split("")[0] + s.split(":")[2].split("")[1];
			}
		} else {
			if (Integer.parseInt(s.split(":")[0]) == 12) {
				ft = "00:" + s.split(":")[1] + ":" + s.split(":")[2].split("")[0] + s.split(":")[2].split("")[1];
			} else {
				ft = s.split(":")[0] + ":" + s.split(":")[1] + ":" + s.split(":")[2].split("")[0]
						+ s.split(":")[2].split("")[1];
			}
		}
		return ft;
	}

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = scan.nextLine();

		String result = timeConversion(s);

		bw.write(result);
		bw.newLine();

		bw.close();
	}

}
