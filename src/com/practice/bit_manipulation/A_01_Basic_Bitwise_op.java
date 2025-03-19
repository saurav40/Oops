package com.practice.bit_manipulation;

public class A_01_Basic_Bitwise_op {
	
	private int AND(int a,int b)
	{
		return a&b;
	}
	
	private int OR(int a,int b)
	{
		return a|b;
	}
	private int ExOR(int a,int b)
	{
		return a^b;
	}
	private int LeftShiftByK(int a,int k)
	{
		return a << k;
	}
	// Note : If the value is un-signed then right shift will fill the vacated bit positions with 
	private int rightShiftByk(int a,int k)
	{
		return a >> k;
	}
	//Bitwise not or one's complement - 32 bit (4byte as it an integer)
	private int NOT(int a)
	{
		return ~a;
	}
	private byte NOT(byte a)
	{
		return (byte) ~a;
	}
	public static void main(String[] args) {
		A_01_Basic_Bitwise_op object = new A_01_Basic_Bitwise_op();
		System.out.println(object.AND(1, 2));
		System.out.println(object.OR(1, 2));
		System.out.println(object.ExOR(1,2));
		System.out.println(object.NOT(127));
		System.out.println("Max: "+Byte.MAX_VALUE+" min: "+Byte.MIN_VALUE);
		byte val = 127;
		System.err.println("Binary representation "+Integer.toBinaryString(object.NOT(Integer.MAX_VALUE)));
		System.out.println(object.NOT(val));
		
		//shifts
		System.out.println(object.LeftShiftByK(8, 2));
		System.out.println(object.rightShiftByk(8,2));
	}

}
