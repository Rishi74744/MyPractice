package com.algorithms;

import java.util.Scanner;

class BST{
	BST leftSubTree;
	BST rightSubTree;
	int value;
}

public class BinarySearchTree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		BST b = new BST();
		for(int i = 0; i < n; i++){
			arr[i] = sc.nextInt();
			if(b.leftSubTree == null && b.rightSubTree == null){
				b.value = arr[i];
			}else{
				placeElementInBST(b, arr[i]);
			}
		}
		
	}
	
	public static void placeElementInBST(BST b, int value){
		if(b.value <= value){
			if(b.leftSubTree == null){
				BST bst = new BST();
				bst.value = value;
				b.leftSubTree = bst;
			}else{
				placeElementInBST(b.leftSubTree, value);
			}
		}else{
			if(b.rightSubTree == null){
				BST bst = new BST();
				bst.value = value;
				b.rightSubTree = bst;
			}else{
				placeElementInBST(b.rightSubTree, value);
			}
		}
	}
	
}
