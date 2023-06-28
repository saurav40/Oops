package com.practice.functionalInterface;

public class PersonClass implements person {
	@Override
	public void sum(int x, int y) {
		// TODO Auto-generated method stub
        System.out.println("Sum = "+(x+y));
	}
	public static void main(String[] args) {
		PersonClass obj = new PersonClass();
		obj.sum(10,6);
		new person() {
			
			@Override
			public void sum(int x, int y) {
				// TODO Auto-generated method stub
				System.out.println(x+y);
			}
		}.sum(10, 10);
		
	  
	}
}
