package com.practice.multitheading;

class InterfaceThread implements Runnable
{
	@Override
	public void run()
	{
		for(int i=0;i<21;i++)
		{
		  System.out.println("Inside thread made using interface"+i);	
		}
	}
}
/*
 *  Less priority thread : DameonThread
 */
class DameonThread extends Thread
{
	@Override
	public void run()
	{
		for(int i=0;i<21;i++)
		{
		   System.out.println("Damaeon Thread"+i);
		}
	}
}
public class ClassForThread extends Thread{
  
	@Override
	public void run()
	{
		for(int i=0;i<21;i++)
		{
			if(Thread.currentThread().isDaemon())
			{
				System.out.println("Inside class thread is Dameon"+i);
			}
			else
			  System.out.println("Inside class thread:"+Thread.currentThread().getName()+" "+i);
		}
	}
	/*
	 * Thread priority - 1 to 10
	 * Default Priority for main method is 5
	 */
	public static void main(String[] args) {
		ClassForThread t = new ClassForThread();
		//t.setDaemon(true);
		t.setPriority(10);
		t.setName("GC");
	    DameonThread dameon = new DameonThread();
	    dameon.setDaemon(true);
	    //dameon.setPriority(1);
	    dameon.start();
	    t.start();
//		InterfaceThread runnable = new InterfaceThread();
//		Thread t3 = new Thread(runnable);
//		t3.start();
		for(int i=0;i<21;i++)
		{
			System.out.println("Inside main method"+i);
		}
	}
}
