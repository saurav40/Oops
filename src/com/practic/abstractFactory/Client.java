package com.practic.abstractFactory;


public class Client {
	public static void main(String[] args) {
     FactoryProducer factoryProducer = new FactoryProducer();
     VehicleAbstractFactory vehiclePremiumFactory = factoryProducer.getFactory("Premium");
     Vehicle vehicle = vehiclePremiumFactory.getVehicle(5000000);
     Vehicle vehicle2 = vehiclePremiumFactory.getVehicle(2100000);
     vehicle.cost();
     vehicle2.cost();
     
     VehicleAbstractFactory vehicleEconomicFactory = factoryProducer.getFactory("Economic");
     Vehicle vehicle3 = vehicleEconomicFactory.getVehicle(200000);
     vehicle3.cost();
	}
}
