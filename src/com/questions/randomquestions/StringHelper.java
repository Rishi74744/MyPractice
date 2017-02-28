package com.questions.randomquestions;

import java.util.HashSet;
import java.util.Set;

public class StringHelper {
    public static Set<String> permutationFinder(String str) {
    	Set<String> perm = new HashSet<String>();
    	if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0);
        String rem = str.substring(1);
        Set<String> words = permutationFinder(rem);
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }

    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }

    public static void main(String[] args) {
        String s1 = "byz";
        String siteId = null;
        Set<String> perm = permutationFinder(s1);
        int k = perm.size() - 1;
        int c = 0;
        for(String aSiteId: perm) {
            siteId = aSiteId;
            c++;
            if(c == k){
            	break;	
            }
        }
        System.out.println(siteId);
    }
}