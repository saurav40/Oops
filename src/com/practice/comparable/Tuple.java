package com.practice.comparable;

public class Tuple implements Comparable<Tuple> {
	int v;
	int dist;

	public Tuple(int v, int dist) {
		this.v = v;
		this.dist = dist;

	}

	// **MIN HEAP
	// @Override
//  public int compareTo(Tuple obj)
//  {
//	  return Integer.compare(this.dist, obj.dist);
//  }

	// MAX HEAP
	@Override
	public int compareTo(Tuple obj) {
		return Integer.compare(obj.dist, this.dist);
	}

}
