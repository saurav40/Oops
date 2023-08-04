package com.practice.functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class User {
	int id;
	String name;
	int age;
	int salary;

	public User(int id, String name, int age, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}

}
interface MyPredicate<T> {
	boolean testObject(T t);
}
public class Predicate_Fucntional_Interface {
	public static void main(String[] args) {
      List<User> usrList = new ArrayList();
      usrList.add(new User(101,"Saurabh",25,69000));
      usrList.add(new User(102,"Satish",22,76000));
      usrList.add(new User(103,"Mayank",21,70000));
      usrList.add(new User(104,"Santosh",20,42000));
      usrList.add(new User(105,"Shrishti",23,38000));
      usrList.add(new User(106,"Rahul",24,41000));
      usrList.add(new User(107,"Abhishek",26,25000));
      usrList.add(new User(108,"Kritesh",23,80000));
      
     Predicate<User> p = (a)->(a.age > 20 && a.age <30);
     
     MyPredicate<User> myP = (a)->(a.name.startsWith("S"));
     List<User> collect  = new ArrayList<>();
     List<User> collectByName  = new ArrayList<>();
     
     for(User usr : usrList)
     {
    	 if(p.test(usr))
    	 {
    		 collect.add(usr);
    	 }
    	 if(myP.testObject(usr))
    	 {
    		 collectByName.add(usr);
    	 }
     }
     System.out.println(collect);
     System.out.println(collectByName);
	}
}
