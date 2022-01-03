package com.java.concepts.ctci.chapter2;

import java.util.HashSet;
import java.util.Set;

public class RemoveDups {

	public static void removeDups(SingleLinkedListModel node) {
		SingleLinkedListModel previousNode = node;
		Set<Integer> buffer = new HashSet<>();
		while (node != null) {
			if (buffer.contains(node.data)) {
				previousNode.next = node.next;
				node = node.next;
			} else {
				buffer.add(node.data);
			}
			if (node != null) {
				previousNode = node;
				node = node.next;
			}
		}
	}

}
