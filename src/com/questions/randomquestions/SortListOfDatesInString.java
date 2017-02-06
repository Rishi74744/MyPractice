package com.questions.randomquestions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListOfDatesInString {

	public static void main(String[] args) {
		List<String> datestring=new ArrayList<String>();
		datestring.add("01/15/2017 03:13:00");
		datestring.add("01/30/2017 14:37:00");
		datestring.add("01/11/2017 10:41:00");
		datestring.add("01/21/2017 10:48:00");
		datestring.add("01/28/2017 06:16:00");
		datestring.add("01/05/2017 06:19:00");
		datestring.add("01/05/2017 05:19:00");
		datestring.add("01/16/2017 15:19:00");
		
		System.out.println("Before Sorting : "+datestring);
		
		
		Collections.sort(datestring,new Comparator<String>() {
			DateFormat f = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
			@Override
			public int compare(String o1, String o2) {
				try{
					return f.parse(o1).compareTo(f.parse(o2));
				} catch(Exception e){
					throw new IllegalArgumentException();
				}
			}
		});
		
		
		System.out.println("After Sorting : "+datestring);
	}
}
