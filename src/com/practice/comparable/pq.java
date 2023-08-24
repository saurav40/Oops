package com.practice.comparable;

import java.util.PriorityQueue;

public class pq {
	public static void main(String[] args) {
     PriorityQueue<Tuple> pq = new PriorityQueue<>();
     pq.add(new Tuple(1,5));
     pq.add(new Tuple(2,4));
     pq.add(new Tuple(3,3));
     pq.add(new Tuple(4,2));
     pq.add(new Tuple(5,1));
     
     while(!pq.isEmpty())
     {
    	 int x=pq.peek().v;
    	 int y =  pq.peek().dist;
    	 pq.remove();
    	 
    	 System.out.println(x+" "+y);
     }
     
	}
}
