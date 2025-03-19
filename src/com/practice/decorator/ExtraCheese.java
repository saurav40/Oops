package com.practice.decorator;

public class ExtraCheese extends ToppingDecorator{
    BasePizza basePizza;
    // Constructor injection
    public ExtraCheese(BasePizza basePizza) {
		// TODO Auto-generated constructor stub
    	this.basePizza = basePizza;
	}
	@Override
	int cost() {
		// TODO Auto-generated method stub
		return basePizza.cost() + 20;
	}

}
