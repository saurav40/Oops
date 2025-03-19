package com.practice.design_patterns.factory;

public class TwoWheelerFactory implements VehicleFactory {
	@Override
	public Vehicle createVehicle()
	{
		return new TwoWheeler();
	}
	
 
}
