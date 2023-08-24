package com.practice.blocks;

public class ConstructorCallFromConstrutor {
   // constructor chaining
	public ConstructorCallFromConstrutor() {
		this(2);
		
	}
	public ConstructorCallFromConstrutor(int x)
	{
		this(x,"Saurabh");
		System.out.println(x);
	}
	public ConstructorCallFromConstrutor(int x,String name)
	{
		System.out.println(x+" "+name);
	}
	public static void main(String[] args) {
		ConstructorCallFromConstrutor obj = new ConstructorCallFromConstrutor();
	}
}
