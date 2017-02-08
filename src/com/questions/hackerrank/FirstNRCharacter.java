package com.questions.hackerrank;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FirstNRCharacter {

	public static void main(String[] args) {
		String s1 = "teeterry1fyded";
		int a[] = {1,1,2,3,9,9,3};
		Map<Integer,Integer> map = new LinkedHashMap<Integer, Integer>();
		for(int i=0; i < a.length;i++){
			if(map.containsKey(a[i])){
				int val = map.get(a[i]);
				map.put(a[i], ++val);
			}else{
				map.put(a[i], 1);
			}
		}
		System.out.println(map);
		
		for(Entry<Integer, Integer> key: map.entrySet()){
			if(key.getValue() == 1){
				System.out.println("First non-repeating character is:"+key.getKey());
				break;
			}
		}
	}

}
