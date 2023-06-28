package com.practice.innerclasses;

public class TestStaticInner {
	public static void main(String[] args) {
		// To access Non-Static Member Of Static Inner Class : U have to create object
		// of that class without
		// creating object Of outer class. Since Inner Class Is Static ,It is
		// independent like Static Method and
		// Static Fields in a class.
		StaticInnerClass1.Inner innerObject = new StaticInnerClass1.Inner();
		System.out.println(innerObject);
		System.out.println(innerObject.getName());

		// -----------------------------------
		System.out.println("Age:" + StaticInnerClass2.Inner.getAge() + " Mobile No :" + StaticInnerClass2.Inner.mobile);
		// To access not static member in Static Inner Class we have to instanciate
		// object of Static Inner Class
		// In below x is a non-static member of Inner Class
		StaticInnerClass2.Inner innerObject2 = new StaticInnerClass2.Inner();
		System.out.println(innerObject2.mobile + " " + innerObject2.x + " " + innerObject2.getAge());
		
		/** 
		 * Note : We can't access non-static methods and fields inside Static Inner Class
		 */
	}
}
