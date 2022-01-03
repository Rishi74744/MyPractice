package com.java.concepts.ctci.chapter1;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class URLify {

	public static String urlify(String input, int trueLength) {
		char input_char[] = new char[trueLength * 3];
		for (int i = 0; i < trueLength; i++) {
			input_char[i] = input.charAt(i);
		}
		int lastIndex = trueLength - 1;
		for (int i = 0; i <= lastIndex; i++) {
			if (input_char[i] == ' ') {
				shiftCharacterByTwo(input_char, lastIndex, i);
				replaceSpacesWithEncodedFormat(input_char, i);
				i += 2;
				lastIndex += 2;
			}
		}
		return Stream.of(input_char).map(arr -> new String(arr)).collect(Collectors.joining());
	}

	private static void replaceSpacesWithEncodedFormat(char[] input_char, int i) {
		input_char[i] = '%';
		input_char[i + 1] = '2';
		input_char[i + 2] = '0';
	}

	private static void shiftCharacterByTwo(char[] input_char, int lastIndex, int i) {
		for (int j = lastIndex; j > i; j--) {
			input_char[j + 2] = input_char[j];
		}
	}

	public static void main(String[] args) {
		String input = "      M r J  o h n S m i t h    ";
		int trueLength = 28;// input.trim().length();
		System.out.println(urlify(input, trueLength));
	}
}
