package com.java.concepts.crack.code.interview.questions.chapter10;

public class SparseSearch {

	private static int findString(String s[], int first, int last, String search) {
		if (first == last) {
			if (s[first].equals(search)) {
				return first;
			} else {
				return -1;
			}
		} else {
			int mid = (first + last) / 2;
			int right = mid + 1;
			int left = mid - 1;
			if (s[mid].equals(search)) {
				return mid;
			} else {
				while (s[left].isEmpty()) {
					left--;
				}
				while (s[right].isEmpty()) {
					right++;
				}
				if (search.equals(s[left])) {
					return left;
				}
				if (search.equals(s[right])) {
					return right;
				}
				if (search.compareTo(s[left]) <= -1) {
					return findString(s, first, left - 1, search);
				}
				if (search.compareTo(s[right]) >= 1) {
					return findString(s, right + 1, last, search);
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String s[] = { "at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "", "mad" };
		String search = "dad";
		int index = findString(s, 0, s.length, search);
		System.out.println(index + 1);
	}

}