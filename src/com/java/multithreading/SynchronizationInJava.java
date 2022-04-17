package com.java.multithreading;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SynchronizationInJava extends Thread {

	private SortedSet<Integer> availableSlots = new TreeSet<>();
	private Set<Integer> occupiedSlots = new HashSet<>();
	{
		availableSlots.add(1);
		availableSlots.add(2);
		availableSlots.add(3);
	}

	public void run() {
		book(1);
	}

	public synchronized boolean book(int slot) {
		try {
			System.out.println("Removing slot from available list : " + slot);
			availableSlots.remove(1);
			System.out.println("Adding slot in occupied list : " + slot);
			occupiedSlots.add(1);
			System.out.println("Waiting");
			Thread.sleep(3000);
			System.out.println("Waiting End");
			System.out.println("Occupied : " + occupiedSlots + " Available : " + availableSlots);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean remove(int slot) {
		System.out.println("Removing slot from occupied list : " + slot);
		occupiedSlots.remove(1);
		System.out.println("Adding slot in available list : " + slot);
		availableSlots.add(1);
		System.out.println("Occupied : " + occupiedSlots + " Available : " + availableSlots);
		return true;
	}

	public static void main(String[] args) {
		SynchronizationInJava s = new SynchronizationInJava();
		Thread t = new Thread(s);
		t.start();
		s.remove(1);
	}

}
