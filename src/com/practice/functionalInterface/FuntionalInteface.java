package com.practice.functionalInterface;

//@FunctionalInterface
public interface FuntionalInteface {
   int sum(int a,int b);
   
   static void show()
   {
	   System.out.println("show");
   }
   public static void hide(String str)
   {
	 System.out.println(str);   
   }
   
   default void message()
   {
	   System.out.println("Hi Buddy, how r u !!");
   }
}
