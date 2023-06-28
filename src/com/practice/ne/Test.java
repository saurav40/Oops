package com.practice.ne;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Test {
 public static void main(String[] args) {
	Map<Character,Integer> mp = new HashMap();
	String s = "geeksforgeeks";
	for(int i=0;i<s.length();i++)
	{
		char c = s.charAt(i);
		if(mp.containsKey(c))
		{
			mp.put(c,mp.get(c)+1);
		}
		else
			mp.put(c,1);
	}
	for(Entry<Character, Integer> e : mp.entrySet())
	{
		System.out.println(e.getKey()+" "+e.getValue());
	}
 }
}
