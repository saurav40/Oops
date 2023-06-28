package com.practice.compostion;

public class Main {
 public static void main(String[] args) {
	
	Address address = new Address("Nh85","Chapra", "Bihar");
	Person person = new Person(101,"Saurabh",25,address);
	System.out.println(person);
}
}
