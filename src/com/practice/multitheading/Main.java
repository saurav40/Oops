package com.practice.multitheading;

public class Main {
   public static void main(String[] args) {
	MyThread t1 = new MyThread();
	MyThread2 t2 = new MyThread2();
	MyRunnable runnable = new MyRunnable();
	Thread t3 = new Thread(runnable);
	t1.start();
	t2.start();
	t3.start();
}
}
