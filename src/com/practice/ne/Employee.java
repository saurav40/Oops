package com.practice.ne;

public class Employee {
	private int id;
	private int age;
	private String name;
	private String department;

	public Employee(int id, int age, String name, String department) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", age=" + age + ", name=" + name + ", department=" + department + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
