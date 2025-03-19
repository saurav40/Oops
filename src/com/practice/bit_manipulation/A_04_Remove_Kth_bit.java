package com.practice.bit_manipulation;

public class A_04_Remove_Kth_bit {
	private int unsetKthBit(int n, int k) {
		return n & ~(1 << k-1);
	}

	public static void main(String[] args) {
		A_04_Remove_Kth_bit obj = new A_04_Remove_Kth_bit();
		System.out.println(obj.unsetKthBit(10, 2));

	}
}
