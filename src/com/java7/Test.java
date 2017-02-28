package com.java7;

import java.util.Scanner;

public class Test {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String time = in.next();
		String s[] = time.split(":");
		for (String i : s) {
			//System.out.println(i);
		}
		String a = s[2].substring(2);
	///	System.out.println(a);
		String b = s[2].substring(0, 2);
		//System.out.println(b);

		if (a.contains("PM")) {
			int x = Integer.parseInt(s[0]);
			int y = x + 12;
			System.out.println(y + ":" + s[1] + ":" + b);
		} else {
			System.out.println(s);
		}
	}
}
