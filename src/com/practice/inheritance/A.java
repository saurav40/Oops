package com.practice.inheritance;

public abstract class A {
    String run() {
    	make();	
    	return "A";
    }
    private String make() {
    	return "ABC";
    }
}
