package com.practice.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.practice.ne.Employee;
/*
 *  Iterator is a standard way to iterate over collection one by one.
 *  it has methods:
 *     hashNext();->check List has next Element of not if yes it enters in Loop
 *     next() -> to get access of element
 *     remove() -> to remove current element from the list - (Optional)
 *       
 *       Note :
 *         calling remove on an iterator obtained from an immutable collection or 
 *         Collections.unmodifiableXXX will throw an UnsupportedOperationException.
 */
public class IteratorExample {
	public static void main(String[] args) {
       List<String> names = Arrays.asList(new String[]{"Saurabh","Ashish","Poonam","Ajay"});
       
       Iterator<String> it = names.iterator();
       
       while(it.hasNext())
       {
    	   System.out.println(it.next());
    	  // it.remove();-> UnsupportedOperationException
       }
       System.out.println(names);
       List<Employee> empList = Arrays.asList(
    		   new Employee(101, 22,"saurabh", "IT"),
    		   new Employee(102, 22,"Rahul", "IT")
       );
       
       Iterator<Employee> empIt = empList.iterator();
       
       while(empIt.hasNext())
       {
    	   System.out.println(empIt.next());
    	   //empIt.remove();-> UnsupportedException 
       }
       List<Employee> empList2 = new ArrayList<>();
       empList2.add(new Employee(101, 22,"saurabh", "IT"));
       empList2.add(new Employee(103, 24,"Rahul", "Prog"));
       
       Iterator<Employee> empIt2 = empList2.iterator();
       
       while(empIt2.hasNext())
       {
    	   System.out.println(empIt2.next());
    	   empIt2.remove();
       }
       
       List<Integer> alist = new ArrayList<>();
       alist.add(2);
       alist.add(5);
       alist.add(89);
       
       Iterator<Integer> itA = alist.iterator();
       
       while(itA.hasNext())
       {
    	   System.out.println(itA.next());
    	   itA.remove();
       }
       System.out.println(alist);
	}
}
