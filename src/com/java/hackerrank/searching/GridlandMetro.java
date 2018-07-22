package com.java.hackerrank.searching;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.sun.jndi.ldap.EntryChangeResponseControl;

public class GridlandMetro {

	// Complete the gridlandMetro function below.
	static int gridlandMetro(int n, int m, int k, int[][] track) {
		Map<Integer, Integer> hm = new HashMap<>();
		for (int i = 1; i <= k; i++) {
			int occ = 0;
			if (hm.containsKey(track[i - 1][0])) {
				occ = hm.get(track[i - 1][0]);
				int diff = Math.abs(track[i - 1][1] - track[i - 1][2]) + 1;
				if (diff > occ) {
					occ = diff;
				}
			} else {
				occ = Math.abs(track[i - 1][1] - track[i - 1][2]) + 1;
			}
			hm.put(track[i - 1][0], occ);
		}
		int totTracks = 0;
		for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
			totTracks += e.getValue();
		}
		return (n * m) - totTracks;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nmk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nmk[0]);

		int m = Integer.parseInt(nmk[1]);

		int k = Integer.parseInt(nmk[2]);

		int[][] track = new int[k][3];

		for (int i = 0; i < k; i++) {
			String[] trackRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 3; j++) {
				int trackItem = Integer.parseInt(trackRowItems[j]);
				track[i][j] = trackItem;
			}
		}

		int result = gridlandMetro(n, m, k, track);
		System.out.println(result);
		// bufferedWriter.write(String.valueOf(result));
		// bufferedWriter.newLine();

		// bufferedWriter.close();

		scanner.close();
	}

}
