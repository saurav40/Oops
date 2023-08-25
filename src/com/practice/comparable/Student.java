package com.practice.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student implements Comparable<Student>{
	private int id;
	private String name;
	private int age;
    
	@Override
//	public int compareTo(Student obj)
//	{
//		return Integer.compare(obj.id,this.id);
//	}
	public int compareTo(Student obj)
	{
		return this.name.compareTo(obj.name);
	}
	public Student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.add(new Student(1,"Manoj", 21));
		students.add(new Student(2,"Vivek", 20));
		students.add(new Student(3,"Bhushan", 22));
		students.add(new Student(4,"Abhishek", 27));
		students.add(new Student(5,"Rahul", 26));
		students.add(new Student(6,"Sandeep", 19));
		Collections.sort(students);
		for(Student student:students)
		{
			System.out.println(student);
		}
	}
}
