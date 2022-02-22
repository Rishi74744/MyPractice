package com.questions.leetcode.amazon.prep;

public class ComplexNumberMultiplication {

	public static String complexNumberMultiply(String num1, String num2) {
		String[] numbers1 = num1.split("\\+");
		String[] numbers2 = num2.split("\\+");
		String real1 = numbers1[0];
		String real2 = numbers2[0];
		String imaginary1 = numbers1[1].split("i")[0];
		String imaginary2 = numbers2[1].split("i")[0];
		int first = Integer.parseInt(real1) * Integer.parseInt(real2);
		int second = Integer.parseInt(real1) * Integer.parseInt(imaginary2);		
		int third = Integer.parseInt(imaginary1) * Integer.parseInt(real2);
		int fourth = Integer.parseInt(imaginary1) * Integer.parseInt(imaginary2) * -1;
		int part1 = first + fourth;
		int part2 = second + third;
		return part1 + "+" + part2 + "i";
	}

	public static void main(String[] args) {
		System.out.println(complexNumberMultiply("-18+-123i", "124+5i"));
	}
}
