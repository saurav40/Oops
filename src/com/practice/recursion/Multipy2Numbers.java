package com.practice.recursion;

public class Multipy2Numbers {
   public static void main(String[] args) {
	  int a = 10;
	  int b = 30;
	  if(a>b)
        System.out.println(multiply(a,b));
	  else
		 System.out.println(multiply(b, a));
   }
   private static int multiply(int a,int b)
   {
	   if(b==0)
		   return 0;
	   return a+multiply(a, b-1);
   }
}
