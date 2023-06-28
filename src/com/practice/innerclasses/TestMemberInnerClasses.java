package com.practice.innerclasses;

public class TestMemberInnerClasses {
	public static void main(String[] args) {
	  MemberInnerClass obj = new MemberInnerClass();
	  obj.msg();//Parent Class
	  MemberInnerClass.Inner obj1 = new MemberInnerClass().new Inner();
	  obj1.msg();//Inner Child
	  MemberInnerClass.Inner.Inner2 obj2= new MemberInnerClass().new Inner().new Inner2();
	  obj2.msg();
	}
}
