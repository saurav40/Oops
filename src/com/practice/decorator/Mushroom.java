package com.practice.decorator;

public class Mushroom extends ToppingDecorator{
	BasePizza basePizza;
	public Mushroom(BasePizza basePizza) {
		// TODO Auto-generated constructor stub
		this.basePizza = basePizza;
	}
	@Override
	int cost() {
		// TODO Auto-generated method stub
		return basePizza.cost() + 40;
	}

}
