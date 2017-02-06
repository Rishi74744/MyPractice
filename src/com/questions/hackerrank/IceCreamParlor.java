package com.questions.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class IceCreamParlor {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			for(int i = 0; i < t; i++){
				int m = sc.nextInt();
				int n = sc.nextInt();
				Integer arr[] = new Integer[n];
				for(int j = 0; j < n; j++){
					arr[j] = sc.nextInt();
				}
				List<Integer> k = new ArrayList<Integer>(Arrays.asList(arr));
				Collections.sort(k);
				Integer sortArr[] = new Integer[n];
				k.toArray(sortArr);
				int start = 0;
				int end = sortArr.length - 1;
				while(start != end){
					int s = sortArr[start] + sortArr[end];
					if(s == m){
						findAndPrintIndexes(arr, sortArr, start, end);
						break;
					}else if(s > m){
						end--;
					}else{
						start++;
					}
				}
			}
		}

		private static void findAndPrintIndexes(Integer[] arr, Integer[] sortArr, int start, int end) {
			int startIndex = 0;
			int endIndex = 0;
			if(sortArr[start] == sortArr[end]){
				for(int i = 0; i<arr.length; i++){
					if(arr[i] == sortArr[start]){
						startIndex = i;
					}
				}
				System.err.println(startIndex);
				for(int i = 0; i<arr.length; i++){
					if(arr[i] == sortArr[end] && i != startIndex){
						endIndex = i;
					}
				}
				System.out.println((startIndex + 1)+" "+(endIndex + 1));
			}else{
				System.out.println((Arrays.asList(arr).indexOf(sortArr[start]) + 1)+" "+(Arrays.asList(arr).indexOf(sortArr[end]) + 1));
			}
		}

}
