package com.practice.blocks;

public class static_block {
	static int i;
	static {
		i=10;
		System.out.println("It called Automatically when class loaded in memory");
	}
	public static void main(String[] args) {
	 System.out.println(static_block.i);	
	}
}
