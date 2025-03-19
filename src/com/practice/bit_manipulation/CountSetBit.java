package com.practice.bit_manipulation;

public class CountSetBit {
	public static void main(String[] args) {
		int x = 128;
		int cnt = 0;
		while(x > 0) {
			if((x & 1) == 1) {
			   cnt ++;	
			}
			System.out.println(x);
			x = x >> 1;
		}
		System.out.println(cnt);
		
	}
}
