package com.practice.lambda;

@FunctionalInterface
public interface Functional {
  void print();
  default void call_defult() {
	  System.out.println("Default method");
  }
  static void step1() {
	  System.out.println(0);
  }
  static void step2(int x) {
	  System.out.println(x);
  }
}
/*
 *  The interface, who has only one abstract method is called a functional interface.
 *  The lamdba expression implements the  abstract method signature.
 *  The functional interface could have as much method it wants, but there would be a single abstract method.
 *  
 *  An interface can have three methods, default method -> implemented method in interface itself.
 *  2. Abstract method
 * 
 **/

