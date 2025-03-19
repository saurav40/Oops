package com.practice.pp;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
 * you are given an array of strings representing book titles. Sort the titles alphabetically,
 *  but ignore the articles "a", "an", and "the" at the beginning of the titles when comparing them.
 *  Example: Input:["The Lord of the Rings", "A Game of Thrones", "Ancillary Justice", "1984"] 
 *  
 */
public class test1 {
	private static String[] removeArt(String [] input) {
		String filtered[] = new String[input.length];
		Set<String> set = new HashSet<>(Arrays.asList("a","an","the"));
		int idx = 0;
		for(String s : input) {
			String article = s.split(" ")[0].toLowerCase();
			if(set.contains(article)) {
				filtered[idx++]=s.substring(s.indexOf(" ")+1);
			}	
			else {
				filtered[idx++]=s;
			}
		}
		return filtered;
	}
	public static void main(String[] args) {
       String [] input= {"The Lord of the Rings", "A Game of Thrones", "Ancillary Justice", "1984"};
       String[] result = removeArt(input);
       Arrays.sort(result);
       for(String s : result) {
    	   System.out.println(s);
       }
       
	}
}
