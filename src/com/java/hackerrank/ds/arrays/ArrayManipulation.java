package com.java.hackerrank.ds.arrays;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ArrayManipulation {
	
	static long arrayManipulation(int n, int[][] queries) {
		Map<Long, Long>	map = new HashMap<>();
		for(int i = 0; i < queries.length; i++) {
			
		}
		return 0;
	}
	

	/*static long arrayManipulation(int n, int[][] queries) {
		BigInteger arr[] = new BigInteger[n];
		Arrays.fill(arr, BigInteger.ZERO);
		for (int i = 0; i < queries.length; i++) {
			BigInteger k = new BigInteger(queries[i][2] + "");
			for (int j = queries[i][0] - 1; j < queries[i][1] - 1; j++) {
				arr[j] = arr[j].add(k);
			}
		}
		Optional<BigInteger> max = Arrays.stream(arr).max(new Comparator<BigInteger>() {
			@Override
			public int compare(BigInteger o1, BigInteger o2) {
				return o1.compareTo(o2);
			}
		});
		return max.get().longValue();
	}*/
	
	/* static long arrayManipulation(int n, int[][] queries) {
	        long arr[] = new long[n];
			for (int i = 0; i < queries.length; i++) {
				int a = queries[i][0] - 1;
				int b = queries[i][1] - 1;
				int k = queries[i][2];
				while (a <= b) {
					arr[a] = arr[a] + k;
					if (a != b) {
						arr[b] = arr[b] + k;
					}
					a++;
					b--;
				}
			}
			return Arrays.stream(arr).max().getAsLong();
	    }
*/
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0]);

		int m = Integer.parseInt(nm[1]);

		int[][] queries = new int[m][3];

		for (int i = 0; i < m; i++) {
			String[] queriesRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 3; j++) {
				int queriesItem = Integer.parseInt(queriesRowItems[j]);
				queries[i][j] = queriesItem;
			}
		}

		long result = arrayManipulation(n, queries);
		System.out.println(result);
		// bufferedWriter.write(String.valueOf(result));
		// bufferedWriter.newLine();

		// bufferedWriter.close();

		scanner.close();
	}
}
