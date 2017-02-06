package com.questions.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class YetAnotherMinimaxProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = sc.nextInt();
		}
		List<Long> l = new ArrayList<>();
		int s = 1;
		while(s!=arr.length){
			l.add((long) (arr[s-1]^arr[s]));
			s++;
		}
		Collections.sort(l);
		System.out.println(Collections.max(l));
	}

}
