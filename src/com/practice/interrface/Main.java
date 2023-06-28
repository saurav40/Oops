package com.practice.interrface;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         String takeMyNo = MyInterface.callme();
         System.out.println("Call me in need on this number :"+takeMyNo);
         
         System.out.println("Call my ex :"+new MyClass().callMyex());
         System.out.println("Call her husband :"+new MyClass().callHerHusbandInstead());
         
         MyClass2 obj2 = new MyClass2();
         System.out.println(obj2);
        // obj2.client_id =10;
         obj2.client_name = "YoungSoft";
         System.out.println(obj2);
         Main obj= new Main();
         obj.show();
         
	}
	public static void test()
	{
		System.out.println("test");
	}
	public void show()
	{
		test();
	}

}
