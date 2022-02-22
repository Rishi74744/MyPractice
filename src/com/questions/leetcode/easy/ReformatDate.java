package com.questions.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class ReformatDate {

	static Map<String, String> monthMap = new HashMap<>();

	static {
		monthMap.put("Jan", "01");
		monthMap.put("Feb", "02");
		monthMap.put("Mar", "03");
		monthMap.put("Apr", "04");
		monthMap.put("May", "05");
		monthMap.put("Jun", "06");
		monthMap.put("Jul", "07");
		monthMap.put("Aug", "08");
		monthMap.put("Sep", "09");
		monthMap.put("Oct", "10");
		monthMap.put("Nov", "11");
		monthMap.put("Dec", "12");
	}

	public static String reformatDate(String date) {
		String[] dateParts = date.split(" ");
		String day = dateParts[0].substring(0, dateParts[0].length() - 2);
		return new StringBuilder(dateParts[2]).append("-").append(monthMap.get(dateParts[1])).append("-")
				.append(day.length() == 1 ? ("0" + day) : day).toString();
	}

	public static void main(String[] args) {
		System.out.println(reformatDate("20th Oct 2052"));
	}

}
