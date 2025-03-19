package com.SystemDesign.SnakeAndLadder;

import java.util.Objects;

public class Dice {
	private int noOfDice;

	public Dice(int noOfDice) {
		super();
		this.noOfDice = noOfDice;
	}

	public int getNoOfDice() {
		return noOfDice;
	}

	public void setNoOfDice(int noOfDice) {
		this.noOfDice = noOfDice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(noOfDice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dice other = (Dice) obj;
		return noOfDice == other.noOfDice;
	}
	
	int rollDice() {
		return ((int)(Math.random()*(noOfDice*6 - noOfDice*1)))+1;
	}

}
