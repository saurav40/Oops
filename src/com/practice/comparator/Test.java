package com.practice.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Test {
 public static void main(String[] args) {
	 List<Person> plist = new ArrayList<>();
		Person p1 = new Person(27,"Saurabh",100);
		Person p2 = new Person(26,"Ravi", 102);
		Person p3 = new Person(28,"R Sharma",101);
		Person p4 = new Person(25,"Saurabh Sah",103);
		plist.add(p1);
		plist.add(p2);
		plist.add(p3);
		plist.add(p4);
		
		Collections.sort(plist);
		
		for(Person p : plist)
		{
			System.out.println(p);
		}
		
		AgeComparator ageComparator = new AgeComparator();
		Collections.sort(plist,ageComparator);
		for(Person p : plist)
		{
			System.out.println(p);
		}
		
		NameCompartor nameCompartor = new NameCompartor();
		Collections.sort(plist,nameCompartor);
		for(Person p : plist)
		{
			System.out.println(p);
		}
		
} 
}
