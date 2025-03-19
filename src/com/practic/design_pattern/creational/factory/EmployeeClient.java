package com.practic.design_pattern.creational.factory;

public class EmployeeClient {
	public static void main(String[] args) {
		 Employee emp = new AndroidDeveloper();
	     System.out.println("tightly coubpled employee: "+emp.getSalary());
		/*
		 * This is tightly Coupled because we are creating object for Android Developer - and if client
		 * need salary for Backend developer then we need to create object for Backend again. 
		 * So instead of doing we can create a factory that will return or create object of
		 * Employee based on requirement- Factory Design Pattern
		 */
	     EmployeeFactory empFactory = new EmployeeFactory();
         
//	     Employee employee = empFactory.getEmployee("Android Developer");
//         System.out.println("Salary:"+employee.getSalary());
//         
//         Employee employee2 = empFactory.getEmployee("Backend Developer");
//         System.out.println("Salary:"+employee2.getSalary());
	}
}
