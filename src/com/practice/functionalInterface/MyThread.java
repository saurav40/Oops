package com.practice.functionalInterface;

public class MyThread {
  public static void main(String[] args) {
	Thread thread = new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i = 1;i<10;i++) 
			  System.out.println("Inside new Thread:"+i);
		}
	});
	Thread thread2 = new Thread(()->
	{
	   for(int i = 1; i < 10; i++)
	   {
		   System.out.println("Inside new thread 2:"+i);
	   }
	});
	
	thread.start();
	thread2.run();
	for(int i=1;i<10;i++)
	  System.out.println("Inside Main Thread :"+i);
	
	
	}
}
