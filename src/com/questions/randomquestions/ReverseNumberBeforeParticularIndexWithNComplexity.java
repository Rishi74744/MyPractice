package com.questions.randomquestions;

public class ReverseNumberBeforeParticularIndexWithNComplexity {

	public static void main(String[] args) {
		int arr[] = {5,9,8,7,14,6,21,15,65};
		int m = 6;
		int j = 0;
		for(int k = 0; k < arr.length; k++){
			System.out.print(arr[k]+ " ");
		}
		int i = m-2;
		while(i>j){
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i--;
			j++;
		}
		System.out.println("Reverse after particular index");
		for(int k = 0; k < arr.length; k++){
			System.out.print(arr[k]+ " ");
		}
		
	}
	
}
