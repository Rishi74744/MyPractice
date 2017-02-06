package com.algorithms;

import java.util.Scanner;

/**
 * Complexity of this program is O(nlog(logn)).
 * Loop in method applySieve() runs for square root of total numbers thus making loop complexity
 * as log(logn). That loop internally calls 
 * markAllMultiplesOfNumberAsNonPrimeIfNumberPrime(int number) method which runs a loop of n times.
 * Thus making program complexity as a whole O(nlog(logn))
 */
public class SieveOfEratosthenes {
	
	static boolean[] isPrime;
	static int totalPrimes;
	static int totalNumbers;
	static Scanner sc;
	
    public static void main(String[] args) {
    	sc = new Scanner(System.in);
    	takeInputAndInitializeIsPrime();
        if(validateInputRange()){
        	displayInputRangeExceededMessageIfInputIsNotValid();
        }else{
	        findTotalNumberOfPrimesIfInputValid();
	        printTotalNumberOfPrimes();
        }
    }

	private static void takeInputAndInitializeIsPrime() {
		System.out.println("Enter total numbers : ");
        totalNumbers = sc.nextInt();
        isPrime = new boolean[totalNumbers+1];
	}

    private static boolean validateInputRange() {
		return (totalNumbers > 1000000000);
	}
    
	private static void displayInputRangeExceededMessageIfInputIsNotValid() {
		System.out.println("Input range exceeded!! Must be less than 10 million!");
	}

	private static void findTotalNumberOfPrimesIfInputValid() {
		markAllIntgersInRangeAsPrime();
		applySieve();
		countNumberOfPrimeNumbers();
	}

	private static void markAllIntgersInRangeAsPrime() {
		for (int i = 2; i <= totalNumbers; i++) {
            isPrime[i] = true;
        }
	}

	private static void applySieve() {
		for (int i = 2; (i * i) <= totalNumbers; i++) {
            markAllMultiplesOfNumberAsNonPrimeIfNumberPrime(i);
        }
	}
	
	private static void markAllMultiplesOfNumberAsNonPrimeIfNumberPrime(int number) {
		if (isPrime(number)) {
		    markAllMultiplesOfNumberAsNonPrime(number);
		}
	}

	private static void markAllMultiplesOfNumberAsNonPrime(int number) {
		for (int j = number; (number * j) <= totalNumbers; j++) {
		    isPrime[number * j] = false;
		}
	}

	private static int countNumberOfPrimeNumbers() {
		for (int i = 2; i <= totalNumbers; i++) {
            if (isPrime(i)){
            	incrementTotalPrimes();
            }
        }
		return totalPrimes;
	}

	private static void incrementTotalPrimes() {
		totalPrimes++;
	}
	
	private static void printTotalNumberOfPrimes() {
		System.out.println("Total Number of Primes in range 2 to "+totalNumbers+" are:" + totalPrimes);
	}
	
	private static boolean isPrime(int number) {
		return isPrime[number];
	}
	
}