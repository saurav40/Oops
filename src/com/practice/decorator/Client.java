package com.practice.decorator;

public class Client {
	public static void main(String[] args) {
		// Order margerita
		BasePizza pizza = new Margherita();
		System.out.println(pizza.cost());
		
		BasePizza margerthiWithExtraChese = new ExtraCheese(new Margherita());
		System.out.println(margerthiWithExtraChese.cost());
		
		BasePizza margerihatWithExtracChessAndExtraMushroom = new Mushroom(new ExtraCheese(new Margherita()));
		System.out.println(margerihatWithExtracChessAndExtraMushroom.cost());
	}
}
