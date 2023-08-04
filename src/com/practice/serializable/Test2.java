package com.practice.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

class Test2 {
	public static void main(String[] args) {
		//Deserialization
		try {
			FileInputStream in = new FileInputStream("person3.txt");
			ObjectInputStream inputObject = new ObjectInputStream(in);
			Person person2 = (Person) inputObject.readObject();
			System.out.println(person2.getAge() + " " + person2.getName());
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
