package com.practice.comparable;

public class Pair implements Comparable<Pair> {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		  if(this.first > o.first)
			  return Integer.compare(this.first, o.first);
		return Integer.compare(this.second, o.second);
	}
}
