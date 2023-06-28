package com.practice.multitheading;

public class MyThread extends Thread {
  public void run()
  {
	  for(int i=1;i<=10;i++)
	  {
		System.out.println("Thread 1 "+i);  
	  }
  }
}
