package com.questions.randomquestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayPattern {

	public static void main(String[] args) {
		int arr[] = { 100, 1, 1341240, 2200, 9999, 12000 };
		List<Integer> l1 = new ArrayList<>();
		List<String> l2 = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			l1.add(arr[i]);
			l2.add(Integer.toString(arr[i]));
		}
		Collections.sort(l1);
		String s1 = Integer.toString(l1.get(arr.length - 1));
		int len = s1.length();
		linePattern(l2, len);
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == len){
				System.out.print(arr[i]);
			}else{
				for(int j = 0; j < (len - l2.get(i).length()); j++){
					System.out.print(" ");
				}
				System.out.print(arr[i]);
			}
			System.out.print(" ");
		}
		System.out.println();
		linePattern(l2, len);
	}

	private static void linePattern(List<String> l2, int len) {
		for (int i = 0; i < l2.size(); i++) {
			for (int j = 0; j < len; j++) {
				System.out.print("-");
			}
			if (i != l2.size() - 1)
				System.out.print("+");
		}
	}

}
