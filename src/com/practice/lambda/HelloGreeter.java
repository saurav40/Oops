package com.practice.lambda;

public class HelloGreeter implements Greeter {
  @Override
  public void perform() {
	  System.out.println("Hello, world!");
  }
}
