package com.practic.design_pattern.creational.factory;

public class ShapeFactory {
   Shape getShape(String shape) {
	   if(shape.equals("Circle")) {
		   return new Circle();
	   }
	   else if(shape.equals("Square")) {
		   return new Sqaure();
	   }
	   else if(shape.equals("Rectangle")) {
		   return new Rectangle();
	   }
		   
	return null;
	   
   }
}
