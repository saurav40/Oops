package com.practice.comparable;

public class NormalPair implements Comparable<NormalPair> {
	int first;
	int second;

	public NormalPair(int first, int second) {
		super();
		this.first = first;
		this.second = second;
	}
	@Override
	public int compareTo(NormalPair o) {
		// TODO Auto-generated method stu
		  if(this.first > o.first)
			  return Integer.compare(this.first,this.second);
		return Integer.compare(this.second, o.second);
	}

}
