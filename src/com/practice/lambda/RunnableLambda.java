package com.practice.lambda;

public class RunnableLambda {
	public static void main(String[] args) {
		// Custom runnable using lambda
		Runnable myLambdaRunnable = () -> {
			System.out.println("Runnable in lambda");
		};

		Thread myThread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Runnanle inside annonymous inner class");
			}
		});

		myThread.run();
		Thread thread2 = new Thread(myLambdaRunnable);
		thread2.run();
		// Or
		Thread thread3 = new Thread(()->{System.out.println("Runnabble lambda expression as an agrgument");});
		thread3.run();
	}
}
