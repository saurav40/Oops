package com.practic.abstractFactory;

public class OrdinaryFactory implements VehicleAbstractFactory{

	@Override
	public Vehicle getVehicle(int price) {
		// TODO Auto-generated method stub
		if(price <1000000) {
			return new VehicaleOrdinaryClassB();
		}
		else if(price > 1000000 && price <= 2000000) {
			return new VehicaleOrdinaryClassA();
		}
	    
		return null;
	}
  
}
