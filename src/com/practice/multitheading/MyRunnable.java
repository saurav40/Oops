package com.practice.multitheading;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<=10;i++)
		  {
			System.out.println("Thread 3 "+i);  
		  }
	}

}
