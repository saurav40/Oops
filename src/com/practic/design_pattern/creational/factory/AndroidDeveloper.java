package com.practic.design_pattern.creational.factory;

public class AndroidDeveloper implements Employee{
   @Override
   public int getSalary()
   {
	 System.out.println("Android Developer Salary:");
     return 50000;
   }
}
