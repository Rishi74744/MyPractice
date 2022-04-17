package com.java.prep.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A transaction is possibly invalid if:
 * 
 * the amount exceeds $1000, or;
 * 
 * if it occurs within (and including) 60 minutes of another transaction with
 * the same name in a different city.
 * 
 * You are given an array of strings transaction where transactions[i] consists
 * of comma-separated values representing the name, time (in minutes), amount,
 * and city of the transaction.
 * 
 * Return a list of transactions that are possibly invalid. You may return the
 * answer in any order.
 * 
 * Example 1:
 * 
 * Input: transactions = ["alice,20,800,mtv","alice,50,100,beijing"] Output:
 * ["alice,20,800,mtv","alice,50,100,beijing"]
 * 
 * Explanation: The first transaction is invalid because the second transaction
 * occurs within a difference of 60 minutes, have the same name and is in a
 * different city. Similarly the second one is invalid too.
 * 
 * Example 2:
 * 
 * Input: transactions = ["alice,20,800,mtv","alice,50,1200,mtv"] Output:
 * ["alice,50,1200,mtv"]
 * 
 * Example 3:
 * 
 * Input: transactions = ["alice,20,800,mtv","bob,50,1200,mtv"] Output:
 * ["bob,50,1200,mtv"]
 * 
 * Constraints:
 * 
 * transactions.length <= 1000
 * 
 * Each transactions[i] takes the form "{name},{time},{amount},{city}"
 * 
 * Each {name} and {city} consist of lowercase English letters, and have lengths
 * between 1 and 10.
 * 
 * Each {time} consist of digits, and represent an integer between 0 and 1000.
 * 
 * Each {amount} consist of digits, and represent an integer between 0 and 2000.
 */
public class InvalidTransaction {

	public List<String> invalidTransactions(String[] transactions) {
		List<String> result = new ArrayList<>();
		if (transactions.length <= 1) {
			return result;
		}
		int n = transactions.length;
		Map<String, List<Integer>> txnsByName = new HashMap<>();
		String name[] = new String[n];
		int time[] = new int[n];
		int amount[] = new int[n];
		String city[] = new String[n];
		boolean isInvalid[] = new boolean[n];
		for (int i = 0; i < n; i++) {
			String[] currentTxn = transactions[i].split(",");
			name[i] = currentTxn[0];
			time[i] = Integer.parseInt(currentTxn[1]);
			amount[i] = Integer.parseInt(currentTxn[2]);
			city[i] = currentTxn[3];
			if (amount[i] > 1000) {
				result.add(transactions[i]);
				isInvalid[i] = true;
			}
			List<Integer> txnIndexes = txnsByName.getOrDefault(name[i], new ArrayList<>());
			txnIndexes.add(i);
			txnsByName.put(name[i], txnIndexes);
		}
		for (int i = 0; i < n; i++) {
			if (isInvalid[i]) {
				continue;
			}
			List<Integer> txnIndexes = txnsByName.get(name[i]);
			for (int txns : txnIndexes) {
				if (txns == i) {
					continue;
				}
				if (Math.abs(time[txns] - time[i]) <= 60 && !city[txns].equals(city[i])) {
					result.add(transactions[i]);
					isInvalid[i] = true;
					if (!isInvalid[txns]) {
						result.add(transactions[txns]);
						isInvalid[txns] = true;
					}
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		InvalidTransaction i = new InvalidTransaction();
		String[] transactions = { "alice,20,800,mtv", "alice,50,100,mtv", "alice,51,100,frankfurt" };
		System.out.println(i.invalidTransactions(transactions));
	}

}
