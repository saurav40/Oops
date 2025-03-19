package com.practice.graph;

import java.util.ArrayList;
import java.util.List;

public class CityNode {
	String city;
	List<String> connectedCities;

	CityNode(String city, List<String> connectedCities){
		this.city = city;
		this.connectedCities = new ArrayList<>(connectedCities);
	}

}
