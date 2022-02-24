package com.java.prep.math;

/**
 * Given a string columnTitle that represents the column title as appear in an
 * Excel sheet, return its corresponding column number.
 * 
 * For example:
 * 
 * A -> 1
 * 
 * B -> 2
 * 
 * C -> 3
 * 
 * ...
 * 
 * Z -> 26
 * 
 * AA -> 27
 * 
 * AB -> 28
 * 
 * Example 1: Input: columnTitle = "A" Output: 1
 * 
 * Example 2: Input: columnTitle = "AB" Output: 28
 * 
 * Example 3: Input: columnTitle = "ZY" Output: 701
 * 
 * Constraints:
 * 
 * 1 <= columnTitle.length <= 7
 * 
 * columnTitle consists only of uppercase English letters.
 * 
 * columnTitle is in the range ["A", "FXSHRXW"].
 *
 */

public class ExcelSheetColumnNumber {

	public int titleToNumber(String columnTitle) {
		int columnNumber = 0;
		for (int i = 0; i < columnTitle.length(); i++) {
			columnNumber = (columnNumber * 26) + columnTitle.charAt(i) - 'A' + 1;
		}
		return columnNumber;
	}

	/**
	 * Complexity - O(n) where n -> Length of column title
	 * 
	 * Space - O(1)
	 */

	public static void main(String[] args) {
		ExcelSheetColumnNumber e = new ExcelSheetColumnNumber();
		System.out.println(e.titleToNumber("XYZA"));
	}

}
