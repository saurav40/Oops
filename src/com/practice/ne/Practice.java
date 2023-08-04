package com.practice.ne;

import java.util.ArrayList;
import java.util.List;

public class Practice {
	public static void main(String[] args) {
      List<Employee> empList = new ArrayList<>();
      empList.add(new Employee(1, 22,"Saurabh", "Sales"));
      empList.add(new Employee(2, 23,"Rahul", "Hr"));
      empList.add(new Employee(3, 26,"Kesav", "Sales"));
      empList.add(new Employee(4, 22,"Naryana", "Sales"));
      empList.add(new Employee(5, 23,"Manish", "Hr"));
      empList.add(new Employee(6, 28,"Kiran", "Sales"));
      empList.add(new Employee(7, 29,"Satya", "Digital"));
      
      //find by Department - Sales 
      List<Employee> res = findByDepartment(empList,"Sales");
      for(Employee emp : res)
    	  System.out.println(emp);
	 }
	static List<Employee> findByDepartment(List<Employee> empList,String department)
	{
		List<Employee> filterd = new ArrayList<>();
		int minAge = Integer.MAX_VALUE;
		for(Employee emp : empList)
		{
			if(emp.getDepartment().equals("Sales"))
			{
				filterd.add(emp);
				minAge = Math.min(minAge,emp.getAge());
			}
		}
		List<Employee> finalListWithMinAge = new ArrayList<>();
		for(Employee emp : filterd)
		{
			if(emp.getAge() == minAge)
				finalListWithMinAge.add(emp);
		}
		return finalListWithMinAge;
	}
	//Id age name Department
	// sales
}
