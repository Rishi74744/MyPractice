package com.java.hackerrank.string;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class WeightedUniformStrings {

	// Complete the weightedUniformStrings function below.
	static String[] weightedUniformStrings(String s, int[] queries) {
		Set<Integer> s1 = new HashSet<>();
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum = sum + ((int) s.charAt(i)) - 96;
			s1.add(sum);
			if ((i < s.length() - 1) && s.charAt(i) != s.charAt(i + 1)) {
				sum = 0;
			}
		}
		System.out.println(s1);
		String result[] = new String[queries.length];
		for (int j = 0; j < queries.length; j++) {
			if(s1.contains(queries[j])) {
				result[j] = "Yes";
			} else {
				result[j] = "No";
			}
			
		}
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		String s = scanner.nextLine();

		int queriesCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] queries = new int[queriesCount];

		for (int i = 0; i < queriesCount; i++) {
			int queriesItem = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			queries[i] = queriesItem;
		}

		String[] result = weightedUniformStrings(s, queries);

		for (int i = 0; i < result.length; i++) {
			// bufferedWriter.write(result[i]);

			System.out.println(result[i]);
			/*
			 * if (i != result.length - 1) { bufferedWriter.write("\n"); }
			 */
		}

		/*
		 * bufferedWriter.newLine();
		 * 
		 * bufferedWriter.close();
		 */

		scanner.close();
	}
	
	
	/**
	 * 
	 * 
		Map<Integer, Integer> m = new HashMap<>();
		
		
		String result[] = new String[queries.length];
		for (int j = 0; j < queries.length; j++) {
			int sum = 0;
			for (int i = 0; i < s.length(); i++) {
				sum = sum + ((int) s.charAt(i)) - 96;
				if (sum == queries[j]) {
					result[j] = "Yes";
					break;
				} else {
					if ((i < s.length() - 1) && s.charAt(i) != s.charAt(i + 1)) {
						sum = 0;
					}
				}
			}
			if (result[j] == null) {
				result[j] = "No";
			}
		}
		return result;
	
	 * 
	 * 
	 * 
	 * 
	 */

}