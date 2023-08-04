package com.practice.blocks;

public class ConstructorCallFromConstrutor {
   // constructor chaining
	public ConstructorCallFromConstrutor() {
		this(2);
		
	}
	public ConstructorCallFromConstrutor(int x)
	{
		System.out.println(x);
	}
	public static void main(String[] args) {
		ConstructorCallFromConstrutor obj = new ConstructorCallFromConstrutor();
	}
}
