package com.practic.design_pattern.creational.factory;

public class AndroidDeveloper implements Employee{
   @Override
   public int getSalary()
   {
	 System.out.println("Android Developer Salary:");
     return 500000;
   }
   public String sayHello()
   {
	   System.out.println("Hello world");
	   for(int i=0;i<10;i++)
		   System.out.println(i);
		  
       return "";
   }
}
