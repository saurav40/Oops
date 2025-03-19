package com.practice.math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Evaluate_mathematical_expression {
	private static int intial_val = 10;
	public static void main(String[] args) {
      String [] expression1 = {"X<Y","Y<Z","Z<W"};
      String [] expression2 = {"X>Y","Y<Z","Z<X","W>Q"};
      Arrays.sort(expression1, (s1, s2) -> {
          char mid1 = s1.charAt(1);
          char mid2 = s2.charAt(1);
          return Character.compare(mid1, mid2);
      });
      System.out.println(isValid(expression1));
	}
	private static boolean isValid(String[] expressions)
	{
		Map<Character,Integer> mp = new HashMap<Character, Integer>();
		for(String exp :expressions)
		{
			System.out.println(exp);
			if(!evalExpression(exp,mp))
			{
				return false;
			}
		}
		return true;
	}
	private static boolean evalExpression(String exp,Map<Character,Integer> mp)
	{
		char left = exp.charAt(0);
		char op = exp.charAt(1);
		char right = exp.charAt(2);
		if(op == '<')
		{
			 if(mp.containsKey(left) && mp.containsKey(right))
			 {
				 return mp.get(left) < mp.get(right);
			 }
			 if(mp.containsKey(left) && !mp.containsKey(right))
			 {
				 mp.put(right, mp.get(left)+1);
				 return true;
			 }
			 if(!mp.containsKey(left) && mp.containsKey(right))
			 {
				 mp.put(left, right-1);
				 return true;
			 }
			 mp.put(left,intial_val++);
			 mp.put(right,intial_val++);
			 return true;
			 
		}
		if(op == '>')
		{
			if(mp.containsKey(left) && mp.containsKey(right))
			 {
				 return mp.get(left) > mp.get(right);
			 }
			 if(mp.containsKey(left) && !mp.containsKey(right))
			 {
				 mp.put(right, mp.get(left)-1);
				 return true;
			 }
			 if(!mp.containsKey(left) && mp.containsKey(right))
			 {
				 mp.put(left, right+1);
				 return true;
			 }
			 mp.put(left,intial_val--);
			 mp.put(right,intial_val--);
			 return true;
		}
		return false;
	}
}
