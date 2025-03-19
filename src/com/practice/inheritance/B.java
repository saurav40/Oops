package com.practice.inheritance;

public class B extends A {
  @Override
  String run() {
	  return "B";
  }
  // PRIVATE METHOD CAN'T BE OVERIDDEN BY CHILD CLASS - METHOD HIDING(OWN IMPLEMENTATION)
  String make() {
	  return "Make";
  }
}
