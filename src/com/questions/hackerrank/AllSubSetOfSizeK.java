package com.questions.hackerrank;

public class AllSubSetOfSizeK {
	int sum = 0;
	public void subset(int[] A, int k, int start, int currLen, boolean[] used, int numOfSticks) {
		if(sum == numOfSticks){
			return;
		}
		if (currLen == k) {
			sum = 0;
			for (int i = 0; i < A.length; i++) {
				if (used[i] == true) {
					System.out.print(A[i] + " ");
					sum += A[i];
				}
			}
			System.out.print("    Sum:"+sum);
			System.out.println();
			return;
		}
		if (start == A.length || sum == numOfSticks) {
			return;
		}
		used[start] = true;
		subset(A, k, start + 1, currLen + 1, used,numOfSticks);
		used[start] = false;
		subset(A, k, start + 1, currLen, used,numOfSticks);
		
		
	}

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 4, 5 };
		boolean[] B = new boolean[A.length];
		AllSubSetOfSizeK i = new AllSubSetOfSizeK();
		i.subset(A, 3, 0, 0, B, 8);

	}

}