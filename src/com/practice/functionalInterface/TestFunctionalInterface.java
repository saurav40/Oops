package com.practice.functionalInterface;

public class TestFunctionalInterface {
	public static void main(String[] args) {
		FuntionalInteface lambda = (a,b) ->{
        	 System.out.println(a+b);
        	 return a+b;
        };
        lambda.sum(10,20);
        lambda.message();//defulat method call - Introduced in Java 8
        FuntionalInteface lambda1 = (a,b) -> {return a+b;};
        System.out.println(lambda1.sum(30, 20));
        
        //without return single statement
        FuntionalInteface lambda2 = (a,b) -> (a+b);
        System.out.println(lambda2.sum(50,70));
        
        FuntionalInteface.hide("Hide for me");// static method call
        FuntionalInteface.show();//
	}
}
