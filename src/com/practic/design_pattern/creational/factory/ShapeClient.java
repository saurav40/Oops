package com.practic.design_pattern.creational.factory;

public class ShapeClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       ShapeFactory shapeFactory = new ShapeFactory();
       shapeFactory.getShape("Circle").draw();
       shapeFactory.getShape("Square").draw();
       shapeFactory.getShape("Rectangle").draw();
	}

}
