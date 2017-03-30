package com.java.designpatterns.singleton;

/**
 * Double check locking singleton is used to remove the overhead of thread safe
 * singleton in which in the beginning multiple threads try to call
 * getInstance().
 * 
 * @author Rishi
 *
 */
public class DoubleCheckLockingSingleton {

	private static DoubleCheckLockingSingleton doubleCheckLockingSingleton;

	private DoubleCheckLockingSingleton() {
	}

	public static DoubleCheckLockingSingleton getInstance() {
		if (doubleCheckLockingSingleton == null) {
			synchronized (DoubleCheckLockingSingleton.class) {
				if (doubleCheckLockingSingleton == null) {
					doubleCheckLockingSingleton = new DoubleCheckLockingSingleton();
				}
			}
		}
		return doubleCheckLockingSingleton;
	}
}
