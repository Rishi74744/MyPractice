package com.java.ctc.c1;

public class ArrayAndStringsIsUnique_2 {

	public static boolean isUnique(String input) {
		int length = input.length();
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				if(input.charAt(i) == input.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String input = "abc _56378a";
		boolean isUnique = isUnique(input);
		System.out.println(isUnique);
	}

}
