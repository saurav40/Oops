package com.practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_17_Course_Schedule_1_and_2 {
	public static void main(String[] args) {
		int prerequisties[][] = { { 1, 4 }, { 4, 0 },
				// {2,4},// to check not possible
				{ 0, 3 }, { 3, 2 }, };
		int noOfTask = 5;
		if (courseSchedule(noOfTask, prerequisties) == true) {
			System.out.println("Possible");
		} else
			System.out.println("Not possible");
		
		int []res = courseScheduleII(noOfTask, prerequisties);
		if(res.length == 0)
			System.out.println("[-1]");
		else
			for(int i=0;i<res.length;i++)
				System.out.print(res[i]+" ");
	}
    private static int[] courseScheduleII(int noOftask,int [][] pre)
    {
    	ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < noOftask; i++)
			adj.add(new ArrayList<>());
		for (int i = 0; i < pre.length; i++) {
			int u = pre[i][1];
			int v = pre[i][0];
			adj.get(u).add(v);
		}

		int[] indegree = new int[noOftask];
		for (int i = 0; i < noOftask; i++) {
			for (int adjNode : adj.get(i)) {
				indegree[adjNode]++;
			}
		}
		Queue<Integer> q = new LinkedList();

		for (int i = 0; i < noOftask; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}
		int cnt = 0;
		ArrayList<Integer> topo = new ArrayList<>();
		while (!q.isEmpty()) {
			int node = q.peek();
			q.remove();
			topo.add(node);
			cnt++;
			for (int adjNode : adj.get(node)) {
				indegree[adjNode]--;
				if (indegree[adjNode] == 0) {
					q.add(adjNode);
				}
			}
		}
		if (cnt != noOftask)
			return new int[] {};
		return topo.stream().mapToInt(Integer::intValue).toArray();   
    }
	private static boolean courseSchedule(int noOftask, int[][] pre) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < noOftask; i++)
			adj.add(new ArrayList<>());
		for (int i = 0; i < pre.length; i++) {
			int u = pre[i][1];
			int v = pre[i][0];
			adj.get(u).add(v);
		}

		int[] indegree = new int[noOftask];
		for (int i = 0; i < noOftask; i++) {
			for (int adjNode : adj.get(i)) {
				indegree[adjNode]++;
			}
		}
		Queue<Integer> q = new LinkedList();

		for (int i = 0; i < noOftask; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}
		int cnt = 0;
		while (!q.isEmpty()) {
			int node = q.peek();
			q.remove();
			cnt++;
			for (int adjNode : adj.get(node)) {
				indegree[adjNode]--;
				if (indegree[adjNode] == 0) {
					q.add(adjNode);
				}
			}
		}
		if (cnt != noOftask)
			return false;
		return true;
	}
}
