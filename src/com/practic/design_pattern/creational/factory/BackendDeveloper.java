package com.practic.design_pattern.creational.factory;

public class BackendDeveloper implements Employee{
  @Override
  public int getSalary()
  {
	  System.out.println("Backend Developer Salary:");
	  return 600000;
  }
}
