package com.java.hackerrank.ds.arrays;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DynamicArray {

	static int[] dynamicArray(int n, int[][] queries) {
		List<Integer> result = new ArrayList<>();
		Map<Integer, List<Integer>> m = new HashMap<>();
		for (int i = 0; i < n; i++) {
			m.put(i, new ArrayList<>());
		}
		int last = 0;
		for (int i = 0; i < queries.length; i++) {
			int query = queries[i][0];
			int x = queries[i][1];
			int y = queries[i][2];
			int seq = findSeq(x, last, n);
			List<Integer> sequence;
			if (m.containsKey(seq)) {
				sequence = m.get(seq);
			} else {
				sequence = new ArrayList<>();
			}
			if (query == 1) {
				int app = performQueryOne(y);
				sequence.add(app);
			} else {
				int app = performQueryTwo(y, sequence.size());
				last = sequence.get(app);

				result.add(last);
				System.out.println(last);
			}
			m.put(seq, sequence);
		}
		return result.stream().mapToInt(Integer::intValue).toArray();
	}

	static int findSeq(int x, int last, int n) {
		int seq = (x ^ last) % n;
		return seq;
	}

	static int performQueryOne(int y) {
		return y;
	}

	static int performQueryTwo(int y, int size) {
		if (size == 0) {
			return 0;
		}
		return (y % size);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nq = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nq[0].trim());

		int q = Integer.parseInt(nq[1].trim());

		int[][] queries = new int[q][3];

		for (int queriesRowItr = 0; queriesRowItr < q; queriesRowItr++) {
			String[] queriesRowItems = scanner.nextLine().split(" ");

			for (int queriesColumnItr = 0; queriesColumnItr < 3; queriesColumnItr++) {
				int queriesItem = Integer.parseInt(queriesRowItems[queriesColumnItr].trim());
				queries[queriesRowItr][queriesColumnItr] = queriesItem;
			}
		}

		int[] result = dynamicArray(n, queries);
		System.out.println(result);

		/*
		 * for (int resultItr = 0; resultItr < result.length; resultItr++) {
		 * bufferedWriter.write(String.valueOf(result[resultItr]));
		 * 
		 * if (resultItr != result.length - 1) { bufferedWriter.write("\n"); } }
		 * 
		 * bufferedWriter.newLine();
		 * 
		 * bufferedWriter.close();
		 */
	}

}
