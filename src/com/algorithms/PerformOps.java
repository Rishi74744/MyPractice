package com.algorithms;

import java.util.ArrayList;

public class PerformOps {

	/**
	 * Generate a CRON expression is a string comprising 6 or 7 fields separated
	 * by white space.
	 *
	 * @param seconds
	 *            mandatory = yes. allowed values = {@code  0-59    * / , -}
	 * @param minutes
	 *            mandatory = yes. allowed values = {@code  0-59    * / , -}
	 * @param hours
	 *            mandatory = yes. allowed values = {@code 0-23   * / , -}
	 * @param dayOfMonth
	 *            mandatory = yes. allowed values = {@code 1-31  * / , - ? L W}
	 * @param month
	 *            mandatory = yes. allowed values =
	 *            {@code 1-12 or JAN-DEC    * / , -}
	 * @param dayOfWeek
	 *            mandatory = yes. allowed values =
	 *            {@code 0-6 or SUN-SAT * / , - ? L #}
	 * @param year
	 *            mandatory = no. allowed values = {@code 1970–2099    * / , -}
	 * @return a CRON Formatted String.
	 */
	private static String generateCronExpression(final String minutes, final String hours, final String month,
			final String dayOfWeek, final String year) {
		return String.format("%1$s %2$s %3$s %4$s %5$s", minutes, hours, month, dayOfWeek, year);
	}

	public static void main(String[] args) {
		/*
		 * ArrayList<ArrayList<Integer>> A = new ArrayList<>(); int k = 1; for
		 * (int i = 0; i < 3; i++) { ArrayList<Integer> ar = new ArrayList<>();
		 * for (int j = 0; j < 4; j++) { ar.add(k); k++; } A.add(ar); }
		 * System.out.println(A); ArrayList<ArrayList<Integer>> B =
		 * performOps(A); for (int i = 0; i < B.size(); i++) { for (int j = 0; j
		 * < B.get(i).size(); j++) { System.out.print(B.get(i).get(j) + " "); }
		 * }
		 */
		System.out.println(generateCronExpression("33", "13", "*", "*", "*"));
	}

	static ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < A.size(); i++) {
			B.add(new ArrayList<Integer>());

			for (int j = 0; j < A.get(i).size(); j++) {
				B.get(i).add(0);
			}

			for (int j = 0; j < A.get(i).size(); j++) {
				B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
			}
		}
		return B;
	}
}
