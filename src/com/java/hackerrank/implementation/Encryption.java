package com.java.hackerrank.implementation;

public class Encryption {

	public static String encrypt(String input) {
		input = input.replaceAll(" ", "");
		int l = input.length();
		double lsqrt = Math.sqrt(l);
		int rows = (int) Math.floor(lsqrt);
		int columns = (int) Math.ceil(lsqrt);
		while ((rows * columns) < l) {
			rows++;
		}
		char arr[][] = new char[rows][columns];
		int strIndex = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (strIndex == l) {
					break;
				}
				arr[i][j] = input.charAt(strIndex);
				strIndex++;
			}
		}
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				if(arr[j][i] != '\u0000') {
					output.append(arr[j][i]);
				}
				if (j == rows - 1) {
					output.append(" ");
				}
			}
		}
		return output.substring(0, output.length() - 1);
	}

	public static void main(String[] args) {
		String input = "if man was meant to stay on the ground god would have given us roots";
		System.out.println(encrypt(input));
	}

}
