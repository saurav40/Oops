package com.practice.bit_manipulation;

public class A_03_Set_Kth_bit {
    private int setKthBit(int n,int k)
    {
    	return n | (1 <<(k-1));
    }
    public static void main(String[] args) {
		A_03_Set_Kth_bit obj = new A_03_Set_Kth_bit();
		System.out.println(obj.setKthBit(8, 2));
	}
}
