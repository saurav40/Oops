package com.practice.innerclasses;

public class StaticInnerClass1 {

	static String name = "saurabh";
    static String exName = "Kristy";
    static void printEx ()
    {
    	System.out.println(exName );
    }
    
    static class Inner {
		String getName() {
			printEx();
			return name;
		}
	}
	public static void main(String args[])
	{
		StaticInnerClass1.Inner obj1 = new StaticInnerClass1.Inner();
		System.out.println(obj1.getName());
	}
}
