package com.questions.hackerrank;

import java.util.Scanner;

public class CircularRotation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int q = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i< n; i++){
			arr[i] = sc.nextInt();
		}
		int numOfRot = k % n;
		for(int i = 0; i < q; i++){
			int m = sc.nextInt();
			if((m - numOfRot) >= 0){
				System.out.println(arr[m - numOfRot]);
			}else{
				System.out.println(arr[m - numOfRot + arr.length]);
			}
		}

	}

}
