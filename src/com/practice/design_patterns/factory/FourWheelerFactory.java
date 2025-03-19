package com.practice.design_patterns.factory;

public class FourWheelerFactory implements VehicleFactory {

	@Override
	public Vehicle createVehicle() {
		// TODO Auto-generated method stub
		return new FourWheeler(); 
	}

}
