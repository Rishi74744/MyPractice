package com.java.concepts.design.patterns;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class Demo {

	private final List<String> entries = new ArrayList<>();
	private static int count = 0;

	public void addEntry(String text) {
		entries.add("" + (++count) + ": " + text);
	}

	public void removeEntry(int index) {
		entries.remove(index);
	}

	@Override
	public String toString() {
		return String.join(System.lineSeparator(), entries);
	}

}

class Persist {

	public void saveToFile(Demo demo, String fileName, boolean overwrite) throws FileNotFoundException {
		if (overwrite || new File(fileName).exists()) {
			try (PrintStream out = new PrintStream(fileName)) {
				out.println(toString());
			}
		}
	}
	
}

public class SingleResponsibilityPrinciple {
	public static void main(String[] args) {
		Demo srp = new Demo();
		srp.addEntry("First");
		srp.addEntry("Second");
		System.out.println(srp);
		
	}
}
