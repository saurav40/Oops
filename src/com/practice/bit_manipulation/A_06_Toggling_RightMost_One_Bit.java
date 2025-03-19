package com.practice.bit_manipulation;
/*
  Note: The problem is to toggle or remove rightmost set bit (1).
 */
public class A_06_Toggling_RightMost_One_Bit {
	// Toggling rightmost either 0/1  by using xor - but this is not the question
	private int toggle_last_bit_zero_or_one(int n)
	{
		return n ^ (1 << 0);
	}
	// 
	private int toggle_rightmost_set_bit(int n)
	{
		return n & (n-1);
	}
	public static void main(String[] args) {
		A_06_Toggling_RightMost_One_Bit obj = new A_06_Toggling_RightMost_One_Bit();
		int i =0;
		int n = 8;
		int n2 = 75;
		while(i < 5)
		{
			n = obj.toggle_last_bit_zero_or_one(n);
			n2 = obj.toggle_rightmost_set_bit(n2);
			System.out.println(n+" "+n2);
			i++;
		}
	}

}
