package com.practice.functionalInterface;

interface MethodRef{
	public void show();
}
class MyMethodRef 
{
	void display()
	{
		System.out.println("My Method Ref");
	}
	static void staticShow()
	{
		System.out.println("Hey Method ref in Static method");
	}
}
public class MethodReference {
  public static void main(String[] args) {
	
	  MethodRef  m1 = new MyMethodRef() :: display;
	  m1.show();
	  MethodRef m2 = MyMethodRef::staticShow;
	  m2.show();
	  
	  //both are equivalent to  lambada Expression but differece we need to define a method 
	  //to write implemnetation of abstract method then we can call it by Method reference
	  
	  MethodRef lm1 = ()->{System.out.println("My Method ref using lambda");};
	  lm1.show();
	 
  }
}
