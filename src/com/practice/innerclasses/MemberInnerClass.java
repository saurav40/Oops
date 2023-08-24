package com.practice.innerclasses;

import com.practice.innerclasses.MemberInnerClass.Inner.Inner2;

//Regular Inner Class
public class MemberInnerClass {
	private int x = 30;
	private int y =10;

	void msg(){
		System.out.println(x);
	}
	
	class Inner {
		private int x = 60;

		void msg() {
			System.out.println(x+"data is " + MemberInnerClass.this.x+" "+y);
			MemberInnerClass.this.msg();
		}

		class Inner2 {
			private int x = 90;

			void msg() {
				System.out
						.println("data is " + MemberInnerClass.Inner.this.x + ":" + MemberInnerClass.this.x + ":" + x+" "+y);
			}
		}
	}

	public static void main(String args[]) {
		MemberInnerClass obj = new MemberInnerClass();
		MemberInnerClass.Inner in = obj.new Inner();
		in.msg();
		System.out.println(in.x);
		MemberInnerClass.Inner.Inner2 obj1 = new MemberInnerClass().new Inner().new Inner2();
		obj1.msg();
		System.out.println(obj1.x);
	}
}
