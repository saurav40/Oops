package com.practice.functionalInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.practice.ne.Employee;

public class AnnonymousCoparatorAge {
   
	static Comparator<Employee> comp = new Comparator<Employee>() {

		@Override
		public int compare(Employee o1, Employee o2) {
			// TODO Auto-generated method stub
			return Integer.compare(o1.getAge(), o2.getAge());
		}
	};
	
	static Comparator<Employee> compLambdaName = (a,b)->{
		return a.getName().compareTo(b.getName());
	};
	static Comparator<Employee> compId = (a,b)-> (Integer.compare(a.getId(), b.getId()));
	
	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<>();
	      empList.add(new Employee(1, 22,"Saurabh", "Sales"));
	      empList.add(new Employee(2, 23,"Rahul", "Hr"));
	      empList.add(new Employee(3, 26,"Kesav", "Sales"));
	      empList.add(new Employee(4, 22,"Naryana", "Sales"));
	      empList.add(new Employee(5, 23,"Manish", "Hr"));
	      empList.add(new Employee(6, 28,"Kiran", "Sales"));
	      empList.add(new Employee(7, 29,"Satya", "Digital"));
	      
	      Collections.sort(empList,comp);
	      System.out.println(empList);
	      Collections.sort(empList,compLambdaName);
	      System.out.println(empList);
	      
	      Collections.sort(empList,compId);
	      System.out.println(empList);
	      
	      Collections.sort(empList,(a,b)->(a.getDepartment().compareTo(b.getDepartment())));
	      
	      System.out.println(empList);
	      
	      //Method Reference
	      Collections.sort(empList,Comparator.comparing(Employee::getName));
	      System.out.println(empList);
	      
	}
}
