package com.practic.design_pattern.creational.factory;

public class EmployeeFactory {

	public Employee getEmployee(String empType) {
		if (empType == "Android Developer") {
			return new AndroidDeveloper();
		} else if (empType == "Backend Developer") {
			return new BackendDeveloper();
		} else
			return null;
	}
}
