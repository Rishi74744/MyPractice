package com.questions.randomquestions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReadWriteFile {

	public static void main(String[] args) {
		File inputFile = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String line = null;
		try {
			inputFile = new File("D:/Input.txt");
			fileReader = new FileReader(inputFile);
			bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				String repeatedNumbers = findRepeatingNumbers(line);
				System.out.println(repeatedNumbers);
			}
			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String findRepeatingNumbers(String s) {
		StringBuilder repeatedNumber = new StringBuilder();
		Map<Integer, Integer> countMap = new LinkedHashMap<>();
		String arr[] = s.split(" ");
		int count = 0;
		while (count != arr.length) {
			if (countMap.containsKey(Integer.parseInt(arr[count]))) {
				int value = countMap.get(Integer.parseInt(arr[count])) + 1;
				countMap.put(Integer.parseInt(arr[count]), value);
			} else {
				countMap.put(Integer.parseInt(arr[count]), 1);
			}
			count++;
		}
		for (Map.Entry<Integer, Integer> e : countMap.entrySet()) {
			if (e.getValue() > 1) {
				repeatedNumber.append(e.getKey() + " ");
			}
		}
		return repeatedNumber.toString().substring(0, repeatedNumber.length() - 1);
	}

}
