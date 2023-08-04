package com.practice.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//Serialization
		FileOutputStream out = new FileOutputStream("person1.txt");
		ObjectOutputStream objectOut = new ObjectOutputStream(out);

		Person person = new Person("Saurabh", 25);
		objectOut.writeObject(person);
	}

}
