package com.practice.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExampleA {
	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName());
		List<Integer> salaryList = new ArrayList<>();
		salaryList.addAll(Arrays.asList(5000,6000,3000,2000,7000,10000,20000));
		
		long count = salaryList.stream().filter((Integer sal) -> sal>3000).count();
		
		System.out.println(count);
	}
}
