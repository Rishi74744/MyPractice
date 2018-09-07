package com.java.concepts.crack.code.interview.questions.chapter3;

import java.util.Scanner;
import java.util.Stack;

public class AnimalShelter {

	static Stack<Integer> oldestAnimal = new Stack<>();
	static Stack<Integer> dog = new Stack<>();
	static Stack<Integer> cat = new Stack<>();

	public static void enqueue(int data, String animalType) {
		oldestAnimal.push(data);
		if ("d".equalsIgnoreCase(animalType.trim())) {
			dog.push(data);
		} else {
			cat.push(data);
		}
	}

	public static void dequeue() {
		Stack<Integer> next = new Stack<>();
		next.addAll(oldestAnimal);
		while (!oldestAnimal.isEmpty()) {
			next.add(oldestAnimal.pop());
		}
		int n = next.pop();
		System.out.println(n);
		while (!next.isEmpty()) {
			oldestAnimal.push(next.pop());
		}
		next = new Stack<>();
		next.addAll(dog);
		while (!dog.isEmpty()) {
			int d = dog.pop();
			if (d != n) {
				next.add(dog.pop());
			}
		}
		dog = new Stack<>();
		dog.addAll(next);
		while (!next.isEmpty()) {
			dog.push(next.pop());
		}

		next = new Stack<>();
		next.addAll(cat);
		while (!cat.isEmpty()) {
			int d = cat.pop();
			if (d != n) {
				next.add(cat.pop());
			}
		}
		cat = new Stack<>();
		cat.addAll(next);
		while (!next.isEmpty()) {
			cat.push(next.pop());
		}
	}

	public static void dequeueDog() {
		Stack<Integer> next = new Stack<>();
		while (!dog.isEmpty()) {
			next.add(dog.pop());
		}
		int n = next.pop();
		System.out.println(n);
		dog = new Stack<>();
		dog.addAll(next);
		while (!next.isEmpty()) {
			dog.push(next.pop());
		}

		next = new Stack<>();
		next.addAll(oldestAnimal);
		while (!oldestAnimal.isEmpty()) {
			int d = oldestAnimal.pop();
			if (d != n) {
				next.add(oldestAnimal.pop());
			}
		}
		oldestAnimal = new Stack<>();
		oldestAnimal.addAll(next);
		while (!next.isEmpty()) {
			oldestAnimal.push(next.pop());
		}
	}

	public static void dequeueCat() {
		Stack<Integer> next = new Stack<>();
		while (!cat.isEmpty()) {
			next.add(cat.pop());
		}
		int n = next.pop();
		System.out.println(n);
		cat = new Stack<>();
		cat.addAll(next);
		while (!next.isEmpty()) {
			cat.push(next.pop());
		}

		next = new Stack<>();
		while (!oldestAnimal.isEmpty()) {
			int d = oldestAnimal.pop();
			if (d != n) {
				next.add(oldestAnimal.pop());
			}
		}

		oldestAnimal = new Stack<>();
		while (!next.isEmpty()) {
			oldestAnimal.push(next.pop());
		}

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int total = scanner.nextInt();
		for (int i = 0; i < total; i++) {
			enqueue(scanner.nextInt(), scanner.nextLine());
		}
		System.out.println("Choose Preference Oldest Animal (O) or Oldest Cat (C) or Oldest Dog (D) : ");
		String choice = scanner.nextLine();
		if ("O".equalsIgnoreCase(choice)) {
			dequeue();
		} else if ("C".equalsIgnoreCase(choice)) {
			dequeueCat();
		} else if ("D".equalsIgnoreCase(choice)) {
			dequeueDog();
		}
		scanner.close();
	}

}
