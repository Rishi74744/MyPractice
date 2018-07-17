package com.questions.randomquestions;

public class NumberPattern {

	public static void main(String[] args) {
		PrintMinNumberForPattern("MMNMMNNM");
	}

	static void PrintMinNumberForPattern(String ar) {
		int curr_max = 0;
		int last_entry = 0;
		int j;
		
		String arr[] = ar.split("");
		System.out.println("Array : " + ar);
		for (int i = 0; i < arr.length; i++) {
			int noOfNextM = 0;
			switch (arr[i]) {
			case "N":
				j = i + 1;
				while (j < arr.length && "M".equals(arr[j])) {
					noOfNextM++;
					j++;
				}
				if (i == 0) {
					curr_max = noOfNextM + 2;
					System.out.print((++last_entry));
					System.out.print(curr_max);
					last_entry = curr_max;
				} else {
					curr_max = curr_max + noOfNextM + 1;
					last_entry = curr_max;
					System.out.print(last_entry);
				}
				for (int k = 0; k < noOfNextM; k++) {
					System.out.print((--last_entry));
					i++;
				}
				break;
			case "M":
				if (i == 0) {
					j = i + 1;
					while (j < arr.length && "M".equals(arr[j])) {
						noOfNextM++;
						j++;
					}
					curr_max = noOfNextM + 2;
					System.out.print(curr_max + "" + (curr_max - 1));
					last_entry = curr_max - 1;
				} else {
					System.out.print((last_entry - 1));
					last_entry--;
				}
				break;
			}
		}
		System.out.println();
	}

}
