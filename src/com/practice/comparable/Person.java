package com.practice.comparable;

public class Person implements Comparable<Person> {
	private int age;
	private String name;
	private int id;

	public Person() {
	}

	public Person(int age, String name, int id) {
		super();
		this.age = age;
		this.name = name;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", id=" + id + "]";
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.id, o.id);
	}

}
