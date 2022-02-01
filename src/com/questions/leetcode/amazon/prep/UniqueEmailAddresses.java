package com.questions.leetcode.amazon.prep;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

	public static int numUniqueEmails(String[] emails) {
		Set<String> emailAddress = new HashSet<>();
		for (String email : emails) {
			String[] emailPart = email.split("@");
			String domain = emailPart[1];
			String localName = emailPart[0].replaceAll("\\.", "");
			int index = localName.indexOf("+");
			if (index != -1) {
				localName = localName.substring(0, index);
			}
			emailAddress.add(localName + "@" + domain);
		}
		return emailAddress.size();
	}

	public static void main(String[] args) {
		String emails[] = { "test.email+alex@leetcode.com", "test.email.leet+alex@code.com" };
		System.out.println(numUniqueEmails(emails));
	}

}
