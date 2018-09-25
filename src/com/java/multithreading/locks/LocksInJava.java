package com.java.multithreading.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LocksInJava {

	static Lock lock = new ReentrantLock();
	static Condition notFull = lock.newCondition();
	static Condition notEmpty = lock.newCondition();

	public void testLock() {
		Lock lock = new ReentrantLock();
		Condition notFull = lock.newCondition();
		try {
			if (lock.tryLock(1, TimeUnit.SECONDS)) {
				notFull.signal();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}

class Producer {
	public void produce() {
		try {
			ReadWriteLock rw = new ReentrantReadWriteLock();
			rw.writeLock();
			rw.readLock();
			LocksInJava.lock.lock();
		} finally {

		}
	}
}
