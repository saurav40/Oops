package com.practice.bit_manipulation;

public class A_02_Check_Kth_bit_set_or_Not {
	private boolean isSetKthBit(int n,int k)
	{
	
		return (n & (1 << (k-1))) != 0;
	}
	public static void main(String[] args) {
		A_02_Check_Kth_bit_set_or_Not obj = new A_02_Check_Kth_bit_set_or_Not();
        System.out.println(obj.isSetKthBit(16, 4));
	}
}
