package com.java.comparator;

import java.util.Collection;
import java.util.Comparator;

public class JavaComparator {

	public static <T> T max(Collection<? extends T> coll, Comparator<? super T> cmp) {
		T candidate = coll.iterator().next();
		for (T elt : coll) {
			if (cmp.compare(candidate, elt) < 0) {
				candidate = elt;
			}
		}
		return candidate;
	}

	/*public static <T extends Comparator<? super T>> T max(Collection<? extends T> coll) {
		return max(coll, JavaComparator.<T>naturalOrder());
	}
	 */
}