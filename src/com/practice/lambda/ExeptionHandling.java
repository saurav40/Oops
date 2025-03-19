package com.practice.lambda;

import java.util.function.BiConsumer;

public class ExeptionHandling {
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 4, 6, 7, 9 };
		int k = 0;

		proces(numbers, k, (a, b) -> {
			try {
				System.out.println(a / b);
			} catch (ArithmeticException e) {
				System.out.println(e.getMessage());
			}
		});

	}

	private static void proces(int[] numbers, int k, BiConsumer<Integer, Integer> consumer) {
		for (int i : numbers) {
			consumer.accept(i, k);

		}
	}
}
