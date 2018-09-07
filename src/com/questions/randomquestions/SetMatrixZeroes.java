package com.questions.randomquestions;

import java.util.ArrayList;

public class SetMatrixZeroes {

	public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
		ArrayList<Integer> columns = new ArrayList<>(a.get(0));
		for (int i = 1; i < a.size(); i++) {
			boolean isRow = false;
			for (int j = 0; j < columns.size(); j++) {
				if (a.get(i).get(j) == 0) {
					a.get(0).set(j, 0);
					isRow = true;
				}
			}
			if (isRow) {
				a.set(i, createZeroList(a.get(i).size()));
			}
		}
		for (int i = 1; i < a.size(); i++) {
			for (int j = 0; j < columns.size(); j++) {
				if (a.get(0).get(j) == 0) {
					a.get(i).set(j, 0);
				}
			}
		}
		if (columns.contains(0)) {
			a.set(0, createZeroList(a.get(0).size()));
		}
		for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i));
		}

	}

	public static ArrayList<Integer> createZeroList(int n) {
		ArrayList<Integer> rows = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			rows.add(0);
		}
		return rows;
	}

	public static void setColumnZero(ArrayList<Integer> list, ArrayList<Integer> columns) {
		for (Integer i : columns) {
			list.set(i, 0);
		}
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		b.add(1);
		b.add(1);
		// b.add(0);
		// b.add(0);
		// b.add(1);
		// b.add(0);
		// System.out.println(b.indexOf(0));
		a.add(b);
		ArrayList<Integer> c = new ArrayList<>();
		c.add(1);
		c.add(0);
		/*
		 * c.add(1); c.add(1); c.add(1);
		 */
		a.add(c);
		/*
		 * ArrayList<Integer> d = new ArrayList<>(); d.add(1); d.add(1);
		 * d.add(1); d.add(1); d.add(0);
		 */
		// a.add(d);
		setZeroes(a);
	}

}
