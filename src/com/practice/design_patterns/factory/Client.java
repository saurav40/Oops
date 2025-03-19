package com.practice.design_patterns.factory;

public class Client {
	private Vehicle vehicle;

	public Client(VehicleFactory factory) {
		vehicle = factory.createVehicle();
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public static void main(String[] args) {
		
		TwoWheelerFactory factory = new TwoWheelerFactory();
		
		Client client = new Client(factory);
		
		Vehicle vehicle= client.getVehicle();
	    vehicle.vechile_info();
	}
}
