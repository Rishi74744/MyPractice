package com.questions.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HackerrankInAString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		String reqSubstring = "hackerrank";
		for (int w = 0; w < q; w++) {
			String s = sc.next();
			int n = s.length();
			Map<String,Integer> m1 = new HashMap<>();
			while (n != 0) {
				if(m1.containsKey(Character.toString(s.charAt(n)))){
					int val = m1.get(Character.toString(s.charAt(n))) + 1;
					m1.put(Character.toString(s.charAt(n)), val);
				}else{
					m1.put(Character.toString(s.charAt(n)), 1);
				}
			}
			
		}
	}

}
