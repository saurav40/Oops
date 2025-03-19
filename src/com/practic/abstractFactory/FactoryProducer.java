package com.practic.abstractFactory;

public class FactoryProducer {
   VehicleAbstractFactory getFactory(String value) {
	   System.out.println(value);
	   if(value.equals("Premium")) {
		   return new PremiumFactory();
	   }
	   else if(value.equals("Economic")) {
		   return new OrdinaryFactory();
	   }
	   return null;
   }
}
