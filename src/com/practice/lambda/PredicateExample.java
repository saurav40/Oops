package com.practice.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/*
 *  Predicate is a prd-defined/generic type functional interface that contains a method.
 *   boolean test(Object o);
 *   
 *  So whenever we need a method which take an object as argument and return a boolean value 
 *  we can use predicate directly.
 */
public class PredicateExample {
	public static void main(String[] args) {
	       List<Person> persons = Arrays.asList(new Person("Saurabh", 26, 7000),
	    		   new Person("Anil", 25, 8999),
	    		   new Person("Ashok", 23, 637782),
	    		   new Person("Vikash", 26,37872),
	    		   new Person("Xavior", 25, 7278));
	       
	       // print the person if age is greater than 25
	       
	       Predicate<Person> ageCondition= (p)->{
	    	   return p.getAge() > 20;
	       };
	       /*
	        *  Consumer is a Functional interface it contains a function.
	        *   void accept(Object o)
	        *   It accept an object and return nothing
	        * 
	        */
	       Consumer<Person> consumer = (p)->System.out.println(p);
	       printByCondtion(persons, ageCondition, consumer);
	       // or
	       printByCondtion(persons, (p)->p.getAge()>25, (p)->System.out.println(p));
	       
	}
   static void printByCondtion(List<Person> persons, Predicate<Person> condtion, Consumer<Person> consumer)
   {
	   for(Person p : persons)
	   {
		   if(condtion.test(p))
			   consumer.accept(p);
	   }
	   System.out.println();
   }
}
