package com.practice.ne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Test {
 public static void main(String[] args) {
	Map<Character,Integer> mp = new HashMap();
//	String s = "geeksforgeeks";
//	for(int i=0;i<s.length();i++)
//	{
//		char c = s.charAt(i);
//		if(mp.containsKey(c))
//		{
//			mp.put(c,mp.get(c)+1);
//		}
//		else
//			mp.put(c,1);
//	}
//	for(Entry<Character, Integer> e : mp.entrySet())
//	{
//		System.out.println(e.getKey()+" "+e.getValue());
//	}
	ArrayList<Integer> a = new ArrayList<>(Arrays.asList(10, -1, 2, 3, -4, 100));
	ArrayList<Integer> res = maxset(a);
	for(int x : res)
		System.out.println(x);
 }
 public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
     
     ArrayList<Integer> ans = new ArrayList<>();
     int i = 0;
     int j = 0;
     int sum1 = 0;
     int sum2 = Integer.MIN_VALUE;
     int start = 0;
     int end = 0;
     while(i<A.size())
     {
         if(A.get(i) >= 0)
         {
             sum1 += A.get(i);
         }
         if(A.get(i) < 0)
         {
        	 
             if(sum1 > sum2){
             start = j;
             end = i;
             sum2 = Math.max(sum1,sum2);
             j=i;
             sum1 = 0;
             }
             else 
             {
            	 sum1 = 0;
            	 j=i;
             }
             j++;
         }
         i++;
     }
     if(sum1 > sum2)
     {
    	 start = j;
    	 end = i;
     }
     for(i=start;i<end;i++)
       ans.add(A.get(i));
     return ans; 
}
}
