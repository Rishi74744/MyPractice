package com.questions.hackerrank;

import java.util.Scanner;

public class BoneTrousel {
	long sum = 0;
	public void subset(long[] A, long k, long start, long currLen, boolean[] used, long numOfSticks) {
		if (currLen == k) {
			sum = 0;
			for (long i = 0; i < A.length; i++) {
				if (used[(int) i] == true) {
					sum += A[(int) i];
				}
			}
			if(sum == numOfSticks){
				for (long i = 0; i < A.length; i++) {
					if (used[(int) i] == true) {
						System.out.print(A[(int) i]);
					}
				}
			}
			return;
		}
		if (start == A.length || sum == numOfSticks) {
			return;
		}
		used[(int) start] = true;
		subset(A, k, start + 1, currLen + 1, used,numOfSticks);
		used[(int) start] = false;
		subset(A, k, start + 1, currLen, used,numOfSticks);
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long noOfTrip = sc.nextInt();
		long[] noOfSticks = new long[(int) noOfTrip];
		long[] noOfBoxesForSale = new long[(int) noOfTrip];
		long[] noOfBoxesToBuy = new long[(int) noOfTrip];
		for(int i = 0; i < noOfTrip; i++){
			noOfSticks[i] = sc.nextInt();
			noOfBoxesForSale[i] = sc.nextInt();
			noOfBoxesToBuy[i] = sc.nextInt();
		}
		
		
		BoneTrousel bone = new BoneTrousel();
		for(long i = 0; i < noOfTrip; i++){
			bone.sum = 0;
			//System.out.println("Current i: "+i+" noOfSticks: "+noOfSticks[i]+" noOfBoxesForSale: "+noOfBoxesForSale[i]+"noOfBoxesToBuy: "+noOfBoxesToBuy[i]);
			long[] n = new long[(int) noOfBoxesForSale[(int) i]];
			boolean[] B = new boolean[(int) noOfBoxesForSale[(int) i]];
			for(long j = 0; j < noOfBoxesForSale[(int) i]; j++){
				n[(int) j] = j+1;
			}
			bone.subset(n,noOfBoxesToBuy[(int) i],0,0,B,noOfSticks[(int) i]);
			System.out.println("Returning");
			if(bone.sum != noOfSticks[(int) i]){
				System.out.print("-1");
			}
			System.out.println();
		}
	}
}
