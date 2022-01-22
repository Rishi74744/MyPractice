package com.questions.leetcode.amazon.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReorderDataInLogFiles {

	public static String[] reorderLogFiles(String[] logs) {

//        Arrays.sort(logs, new Comparator<String>() {
//            @Override public int compare(String s1, String s2) {
//                String[] split1 = s1.split(" ",2);  
//                String[] split2 = s2.split(" ",2);
//                
//                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
//                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
//                
//                if(isDigit1 && !isDigit2) return 1; //1.letter logs come before all digit logs
//                else if(!isDigit1 && isDigit2) return -1; //1.letter logs come before all digit logs
//                else if(isDigit1 && isDigit2) {
//                    return 0; //3.The digit-logs maintain their relative ordering.
//                } else {//both letters            
//                    //2.if their contents are the same, then sort them lexicographically by their identifiers.
//                    int ret = split1[1].compareTo(split2[1]); //content
//                    if (ret == 0) return split1[0].compareTo(split2[0]); //id
//                    return ret;
//                }
//
//            }           
//        });
//        

		Arrays.sort(logs, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String identifier1[] = o1.split(" ", 2);
				String identifier2[] = o2.split(" ", 2);

				boolean isObject1Digit = Character.isDigit(identifier1[1].charAt(0));
				boolean isObject2Digit = Character.isDigit(identifier2[1].charAt(0));

				if (isObject1Digit && isObject2Digit) {
					return 0;
				} else if (isObject1Digit && !isObject2Digit) {
					return 1;
				} else if (!isObject1Digit && isObject2Digit) {
					return -1;
				} else {
					int compareLogs = identifier1[1].compareTo(identifier2[1]);
					if (compareLogs == 0) {
						return identifier1[0].compareTo(identifier2[0]);
					}
					return compareLogs;
				}
			}
		});
		return logs;
	}

	public static void main(String[] args) {
		String logs[] = { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" };
		String result[] = reorderLogFiles(logs);
		for (String res : result) {
			System.out.println(res.toString());
		}
	}

}
