package com.practice.bit_manipulation;

public class A_05_Toggle_Kth_bit {
 private int toggleKthBit(int n,int k)
 {
	 return n ^ (1 << (k-1));
 }
 public static void main(String[] args) {
	 A_05_Toggle_Kth_bit obj  = new A_05_Toggle_Kth_bit();
	 int i = 0;
	 int n = 10;
	 int k = 2;
	 while(i < 5)
	 {
	     n = obj.toggleKthBit(n, k);
	     System.out.println(n);
		 i++;
	 }
	//System.out.println(obj.toggleKthBit(10, 2));
}
}
