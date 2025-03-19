package com.practice.starategyPattern;

public class Client {
	public static void main(String[] args) {
		Sorter sorter = new Sorter(new InsertionSort());
		int arr[] = {2,7,1,0,-1,8};
		sorter.sortstrategy.sort(arr);
		for(int x : arr) {
			System.out.print(x+" ");
		}
		System.out.println();
		int arr2 [] = {10,27,3,7,2,1,5,3,0};
		BubbleSorter bubbleSorter = new BubbleSorter();
		bubbleSorter.sortstrategy.sort(arr2);
		for(int x : arr2) {
			System.out.print(x+" ");
		}
	}
}
