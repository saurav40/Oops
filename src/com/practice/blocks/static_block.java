package com.practice.blocks;

public class static_block {
	static int i;
	static void show()
	{
		System.out.println("Called inside static block");
	}
	static {
		i=10;
		show();
		System.out.println("It called Automatically when class loaded in memory");
	}
	public static void main(String[] args) {
	 System.out.println(static_block.i);	
	}
}
