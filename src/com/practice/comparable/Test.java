package com.practice.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

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
	PriorityQueue<NormalPair> pq = new PriorityQueue<NormalPair>();
	
	pq.add(new NormalPair(3,6));
	pq.add(new NormalPair(3, 8));
	pq.add(new NormalPair(3, 1));
	
	while(!pq.isEmpty())
	{
		System.out.println(pq.peek().first+","+pq.peek().second);
		pq.remove();
	}
	
	
//	Set<Integer> set = new TreeSet<>();
//	set.add(1);
//	set.add(2);
//	set.add(-10);
//	set.add(-9);
//	set.add(3);
//	System.out.println(set);
//	pq.add(new Pair(3, 4));
//	pq.add(new Pair(3, 2));
//	while(!pq.isEmpty())
//	{
//		int first = pq.peek().first;
//		int second = pq.peek().second;
//		pq.remove();
//		System.out.println("{"+first+","+second+"}");
//	}
}
}
