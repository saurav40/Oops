package com.practice.lambda;


interface Add{
	int add(int a, int b);
}

// Greeter Interface

public class Main {
	int x;
	int y;
	int z;
	public Main(int x, int y){
		this.x = x;
		this.y = y;
		this.z = 0;
	}
	public void add(Add adder) {
		this.z= adder.add(x, y);
	}
	
	
	public void greet(Greeter greeter) {
		greeter.perform();
	}
	public static void main(String[] args) {
		Main obj = new Main(100,23);

		// Passing an interface to a function with as object
		Greeter helloGreeter = new HelloGreeter();
		obj.greet(helloGreeter);
       
		// Lambda expression 
		Greeter lamdbaGreeter = ()-> System.out.println("Hello, World!");
		obj.greet(lamdbaGreeter);
		
		// Anonymous inner class
		Greeter innerGreeter = new Greeter() {
			@Override
			public void perform() {
				System.out.println("Hello, World!");
			}
		};
		
		obj.greet(innerGreeter);
		/*
		 * 
		 * Before Java 8
		 * ---------------
		 * In case of creating implementation of method , We need to create an instance of a class or a instance of anonymous class.
		 * and still it is not entirely achieve the functional programming in java, because the method present in interface is encapsulated in object.
		 * 
		 * After Java 8
		 * -------------
		 * Lambda expression, it enables the functional programming.
		 * What it does it define the interface method directly without creating an object.
		 * 
		 * 
		 */
				
	}
}
