package com.questions.hackerrank;

import java.util.Scanner;

public class BonAppetit {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfItems = in.nextInt();
		int kthItem = in.nextInt();
		int[] itemCost = new int[noOfItems];
		for(int i = 0; i < noOfItems; i++){
			itemCost[i] = in.nextInt();
		}
		int bcharged = in.nextInt();
		int annaTot = 0;
		for(int i = 0; i < noOfItems; i++){
			if(i != kthItem){
				annaTot += itemCost[i];
			}
		}
		int bactual = annaTot / 2;
		if(bactual == bcharged){
			System.out.println("Bon Appetit");
		}else{
			System.out.println(bcharged - bactual);
		}
	}

}
