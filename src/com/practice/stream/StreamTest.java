package com.practice.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.practice.ne.Employee;

public class StreamTest {
 public static void main(String[] args) {
	 List<String> words = Arrays.asList(new String[]{"World","Week","work","new","old","and","life","death"});
	 
	 //Map- To do operation on elements of a Collection
	 List<String> map = words.stream().map((a)->(a.substring(0,1).toLowerCase()+a.substring(1).toUpperCase())).collect(Collectors.toList());
	 System.out.println(map);
	 
	 //Filter - To filter a Collection
	 List<String> filter = words.stream().filter((a)->(a.startsWith("wo") || a.startsWith("o"))).collect(Collectors.toList());
	 System.out.println(filter);
	 
	 List<String> sorted = words.stream().sorted().collect(Collectors.toList());
	 System.out.println(sorted);
	 
	 //ForEach
	 words.stream().forEach(
			    (x)->{System.out.print(x+" ");}
			    );
	 //or
	 words.stream().forEach(
			    (x->System.out.print(x+" "))
			    );
	 System.out.println("****************************************************************");
	 List<Employee> empList = new ArrayList<>();
     empList.add(new Employee(1, 22,"Saurabh", "Sales"));
     empList.add(new Employee(2, 23,"Rahul", "Hr"));
     empList.add(new Employee(3, 26,"Kesav", "Sales"));
     empList.add(new Employee(4, 22,"Naryana", "Sales"));
     empList.add(new Employee(5, 23,"Manish", "Hr"));
     empList.add(new Employee(6, 28,"Kiran", "Sales"));
     empList.add(new Employee(7, 29,"Satya", "Digital"));
     
     //findbydepartments 
     List<Employee> findByDepartments = empList.stream().filter((x)->(x.getDepartment().equals("Sales"))).collect(Collectors.toList());
     
     int minAge = findByDepartments.stream().mapToInt(a->(a.getAge())).min().orElseThrow(null);
     
     List<Employee> filterByAge = findByDepartments.stream().filter((x->x.getAge() == minAge)).collect(Collectors.toList());
     System.out.println(filterByAge);
     
 }
}
