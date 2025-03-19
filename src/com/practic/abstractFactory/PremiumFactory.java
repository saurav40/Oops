package com.practic.abstractFactory;

public class PremiumFactory implements VehicleAbstractFactory{
	@Override
	public Vehicle getVehicle(int price) {
		// TODO Auto-generated method stub
		if(price > 2000000 && price < 5000000) {
			return new VehiclePremiumB();
		}
		else if(price >= 5000000) {
			return new VechiclePremiumA();
		}
	    
		return null;
	}

}
