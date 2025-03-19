package com.practice.lambda;

public class FunctionalMain {
	public static void main(String[] args) {
       Functional greet = ()->{
    	   System.out.println("Print invoked");
       };
       greet.print();
	}
}
