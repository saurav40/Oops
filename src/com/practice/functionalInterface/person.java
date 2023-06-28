package com.practice.functionalInterface;

/* @FunctionalInterface annotation
 * 
 * s used to ensure that the functional interface can’t have more than one abstract method.
 *  In case more than one abstract methods are present, the compiler flags an ‘Unexpected @FunctionalInterface annotation’ message.
 */
@FunctionalInterface
public interface person {
	void sum(int x, int y);
	// void mult();
}
