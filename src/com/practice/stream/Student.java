package com.practice.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Student {
	private String name;
	private int age;
	private double gpa;

	public Student(String name, int age, double gpa) {
		super();
		this.name = name;
		this.age = age;
		this.gpa = gpa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", gpa=" + gpa + "]";
	}

	public static void main(String[] args) {
		List<Student> students =
			Arrays.asList(new Student("Alice", 20, 3.7), 
					      new Student("Bob", 22, 3.9),
				          new Student("Charlie", 21, 3.5), 
				          new Student("David", 19, 4.0),
		                  new Student("Bob",26,4.5));
		
		//Filter -> allows you to create a new stream that contains elements matching a given condition.
		List<Student> filterd = students.stream().filter((x)->x.getGpa() >=3.5).collect(Collectors.toList());
		//System.out.println(filterd);
		
		//Map -> transforms elements in a stream by applying a given function to each element.
		List<Student> mapped = students.stream().map((x)->{return new Student("Mr. "+ x.getName(),x.getAge(),x.getGpa());}).collect(Collectors.toList());
        //System.out.println(mapped);
        
        List<Integer> ages = students.stream().map((x)->{return x.age;}).collect(Collectors.toList());
        List<String> names = students.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println(ages);
        System.out.println(names);
        
        List<String> uniqueName = students.stream().map(Student::getName).distinct().collect(Collectors.toList());
        System.out.println(uniqueName);
        
        List<Integer> limitedData = students.stream().map((x)->{return x.age;}).limit(2).collect(Collectors.toList());
        System.out.println(limitedData);
        
        List<Student> sortedStudentsByName = students.stream().sorted(Comparator.comparing(Student::getName)).collect(Collectors.toList());
	    System.out.println(sortedStudentsByName);
	}

}
