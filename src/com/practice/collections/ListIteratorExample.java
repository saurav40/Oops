package com.practice.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/*
 *  List iterator is similar to Iterator but it is bidirectional.
 *  means we can traverse in both direction
 */
public class ListIteratorExample {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("saurbh");
		names.add("sunny");
		names.add("jhon");
		names.add("Hitesh");
		names.add("Komal");
		names.add("Ranjit");
		
		ListIterator<String> itName = names.listIterator();
		
		while(itName.hasNext())
		{
			System.out.print(itName.nextIndex()+" ");
			int idx = itName.nextIndex();
			System.out.print(itName.next()+" ");			
		}
		System.out.println();
		while(itName.hasPrevious())
		{
			System.out.print(itName.previousIndex()+" ");
			System.out.print(itName.previous()+" ");
		}

	}
}
