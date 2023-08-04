package com.practice.blocks;

public class MethodOverriding {

	int sum(int a, int b, int result) {
		return result = a + b;
	}

	float sum(float a, float b) {
		return a + b;
	}

	void sum(int x, int y) {
		System.out.println(x + y);
	}

	public static void main(String[] args) {
        MethodOverriding obj = new MethodOverriding();
        System.out.println(obj.sum(1.2f, 2.3f));
        obj.sum(30, 40);
        System.out.println(obj.sum(30,70,0));
        
        
	}
}
