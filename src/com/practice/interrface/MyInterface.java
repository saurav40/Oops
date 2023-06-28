package com.practice.interrface;

import java.util.Random;

public interface MyInterface {
	//Static Method
	static String callme() {
		String myNummber = "";
		Random rand = new Random();
		long randomNum = rand.nextLong() % 10000000000L;
		long positiveNum = Math.abs(randomNum);
		myNummber = String.format("%010d", positiveNum);
		// System.out.printf("Random 10-digit number: %010d", Math.abs(randomNum));

		return myNummber;
	}
	
	//Concrete Method 
	 String callMyex();
	 
	//Default Method
	 default String callHerHusbandInstead() {
		return "6235089657"; 
	 }
	 
	 //Constant Varaible -> 
	 static final int CLIENT_ID =788887627;
	 
	 //Static Variable->
	  static String CLIENT_NAME ="S.Jetson";
	
}
