package com.practice.compostion;

public class Person {
	int id;
	String name;
	int age;
	private Address address;
	public Person() {}
    public Person(int id, String name, int age, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}



//    public Person(String street, String city, String state) {
//        this.address = new Address(street, city, state);
//    }
//
//    public String getAddressDetails() {
//        return address.getStreet() + ", " + address.getCity() + ", " + address.getState();
//    }
}
