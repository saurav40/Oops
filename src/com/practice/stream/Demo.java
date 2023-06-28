package com.practice.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Demo {
	public static void main(String[] args) {

		List<Integer> number = Arrays.asList(2, 3, 4, 5);

		List<Integer> square = number.stream().map(x -> x * x).collect(Collectors.toList());
		System.out.println(square);

		// create a list of String
		List<String> names = Arrays.asList("Reflection", "Collection", "Stream");

		List<String> filterName = names.stream().filter(s -> s.startsWith("S")).collect(Collectors.toList());
		System.out.println(filterName);

		List<String> sortedNames = names.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedNames);
		
		Set<Integer> squareSet = number.stream().map(x->x*x).sorted().collect(Collectors.toSet());
		System.out.println(squareSet);
		
		number.stream().map(x->x*x*2).sorted().forEach(a->System.out.print(a+" "));
		

	}
}
