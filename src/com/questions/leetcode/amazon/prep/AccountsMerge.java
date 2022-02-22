package com.questions.leetcode.amazon.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountsMerge {

	public static List<List<String>> accountsMerge(List<List<String>> accounts) {
		List<List<String>> result = new ArrayList<>();
		Map<String, Set<String>> userEmails = new LinkedHashMap<>();
		int index = 0;
		for (List<String> account : accounts) {
			String name = account.get(0);
			if (userEmails.containsKey(name)) {
				Set<String> emails = userEmails.get(name);
				Set<String> currentEmails = new LinkedHashSet<>(account);
				Set<String> copyEmails = new LinkedHashSet<>(account);
				currentEmails.remove(name);
				if (currentEmails.removeAll(emails)) {
					copyEmails.addAll(emails);
					userEmails.put(name, copyEmails);
				} else {
					userEmails.put(name + index, copyEmails);
					index++;
				}
			} else {
				Set<String> copyEmails = new LinkedHashSet<>(account);
				userEmails.put(name, copyEmails);
			}
		}
		result = userEmails.entrySet().stream().map(e -> {
			return new ArrayList<>(e.getValue());
		}).collect(Collectors.toList());
		return result;
	}

	public static void main(String[] args) {
		String[][] accounts = { { "John", "johnsmith@mail.com", "john_newyork@mail.com" },
				{ "John", "johnsmith@mail.com", "john00@mail.com" }, { "Mary", "mary@mail.com" },
				{ "John", "johnnybravo@mail.com" } };
		List<List<String>> accountsInfo = new ArrayList<>();
		for (int i = 0; i < accounts.length; i++) {
			List<String> email = new ArrayList<>();
			for (int j = 0; j < accounts[i].length; j++) {
				email.add(accounts[i][j]);
			}
			accountsInfo.add(email);
		}
		System.out.println(accountsMerge(accountsInfo));
	}

}
