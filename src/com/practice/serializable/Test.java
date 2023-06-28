package com.practice.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream out = new FileOutputStream("person.txt");
        ObjectOutputStream objectOut = new ObjectOutputStream(out);
        
        Person person = new Person("Saurabh",25);
        
        objectOut.writeObject(person);
        
        FileInputStream in = new FileInputStream("person.txt");
        
        ObjectInputStream inputObject = new ObjectInputStream(in);
        
        Person person2 = (Person)inputObject.readObject();
        
        System.out.println(person2.getAge()+" "+person2.getName());
	}

}
