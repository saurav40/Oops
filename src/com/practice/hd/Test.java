package com.practice.hd;

public class Test {
	public static void main(String[] args) {
//       int n = 4;
//       int ans = 1;
//       for(int i=1;i*i<=n;i++) {
//    	   ans = i;
//       }
//       //O(Sqrt(n))-> best case & average case
//       //O(n/2) -> O(n) = worst case
//       System.out.println(ans);
		printPyramid(3);
		swap(10, 5);
	}
	private static void printPyramid(int n) {
		int start = 1;
		for(int i=1;i<=n;i++) { // O(n)
			for(int k=1;k<=n-i;k++) { //O(n-1)
				System.out.print(" ");
			}
			for(int j=1;j<=start;j++){ // O(n)
				System.out.print("*");
			}
			start += 2;
			System.out.println();
		}
		// O(n^2)
	}
	private static void swap(int x, int y) {
		System.out.println(x + " "+ y);
		x = x ^ y;
		y = x ^ y;
		x = x ^ y;
		System.out.println(x +" "+ y);
	}
}
