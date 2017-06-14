package com.questions.hackerrank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.JulianFields;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class DayOfTheProgrammer {

	private static int dayOfProgrammer = 256;
	private static int JGREG = 15 + 31 * (10 + 12 * 1582);

	static String solve(int year) throws ParseException {
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.set(GregorianCalendar.YEAR, year);
		gregorianCalendar.set(GregorianCalendar.DAY_OF_YEAR, dayOfProgrammer);
		long time = gregorianCalendar.getTime().getTime();
		if (year <= 1917) {
			int array[] = new int[3];
			array[0] = year;
			array[1] = gregorianCalendar.get(GregorianCalendar.MONTH);
			array[2] = gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH);

			int array1[] = new int[3];
			array1[0] = year;
			array1[1] = 1;
			array1[2] = 1;
			// gregorianCalendar.add(GregorianCalendar.DATE, -13);
			time = (long) toJulian(array) - (long) toJulian(array1) + 1;

		}
		return new SimpleDateFormat("dd.MM.yyyy").format(new Date(time));
	}

	public static void main(String[] args) throws ParseException {
		Scanner in = new Scanner(System.in);
		int year = in.nextInt();
		String result = solve(year);
		System.out.println(result);
	}

	public static double toJulian(int[] ymd) {

		int year = ymd[0];
		int month = ymd[1]; // jan=1, feb=2,...
		int day = ymd[2];
		int julianYear = year;
		if (year < 0)
			julianYear++;
		int julianMonth = month;
		if (month > 2) {
			julianMonth++;
		} else {
			julianYear--;
			julianMonth += 13;
		}

		double julian = (java.lang.Math.floor(365.25 * julianYear) + java.lang.Math.floor(30.6001 * julianMonth) + day
				+ 1720995.0);
		if (day + 31 * (month + 12 * year) >= JGREG) {
			// change over to Gregorian calendar
			int ja = (int) (0.01 * julianYear);
			julian += 2 - ja + (0.25 * ja);
		}
		return java.lang.Math.floor(julian);
	}

}
