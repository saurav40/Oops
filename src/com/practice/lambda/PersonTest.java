package com.practice.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
interface Condition{
	boolean test(Person p);
}
public class PersonTest {
	public static void main( String[] args) {
       List<Person> persons = Arrays.asList(new Person("Saurabh", 26, 7000),
    		   new Person("Anil", 25, 8999),
    		   new Person("Ashok", 23, 637782),
    		   new Person("Vikash", 26,37872),
    		   new Person("Xavior", 25, 7278));
       // Before java 8
       Collections.sort(persons, new NameComparator());
       // ----> Comparator.comparing(Person::getName) this is feature of java 8 we need to create a custom comparator(NameComparator) to pass as an argument.
       print(persons);
       
       // print a person whose name start with A.
       printConditional(persons);
       System.out.println();
      
       // After 
       Collections.sort(persons, (p1,p2)->(Integer.compare(p1.getAge(), p2.getAge())));
       print(persons);
       
      // or
       Condition personCondtion = (p)->{
    	   return p.getName().startsWith("V");
       };
       
       
       printConditional(persons, personCondtion);
       // Stream in java 8
//       List<Person> sortedByName = persons.stream().sorted(Comparator.comparing(Person::getName)).collect(Collectors.toList());
//       
//       for(Person o : sortedByName)
//    	   System.out.println(o);
	}
	static void print(List<Person> persons) {
		for(Person p : persons)
			System.out.println(p);
		
		System.out.println();
	}
	static void printConditional(List<Person> persons) {
		for(Person p : persons)
		{
			if(p.getName().startsWith("A")) {
				System.out.println(p);
			}
		}
		
	}
	static void printConditional(List<Person> persons, Condition condition) {
		for(Person p : persons)
		{
			if(condition.test(p)) {
				System.out.println(p);
			}
		}
	}
}
