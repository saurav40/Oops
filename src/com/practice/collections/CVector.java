package com.practice.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.Vector;
import java.util.stream.Collectors;

public class CVector {
  public static void main(String[] args) {
	  //Thread Safe
	Vector<Integer> v = new Vector<>();
	v.add(10);
	v.add(3);
	v.add(4);
	v.add(90);
	System.out.println(v);
	Collections.sort(v);
	System.out.println(v);
 }
}
