package com.practice.innerclasses;

public class TestMethodInnerClass {
 public static void main(String[] args) {
	 MethodInnerClass obj = new MethodInnerClass();
	 obj.setCount(10);
	 System.out.println(obj.getCount());
	 obj.InnerFunction(2);
	 System.out.println(obj.getCount());
	 /**/
	 
}
}
