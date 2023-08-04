package com.practice.functionalInterface;

interface Operation {
	public int operation(int a, int b);
}

public class LambdaExpressionAsArgument {
	public static void main(String[] args) {
       Operation operation = (a,b)->(a+b);
       System.out.println(result(10, 20, operation));
       System.out.println(result(20, 10,(x,y)->(x-y)));
       System.out.println(result(20,19, (x,y)->x*y));
       System.out.println(result(30, 5, (x,y)->x/y));
       System.out.println(result(60, 10, (x,y)->x%y));
	}
	public static int result(int a,int b,Operation op)
	{
		return op.operation(a, b);
	}
}
