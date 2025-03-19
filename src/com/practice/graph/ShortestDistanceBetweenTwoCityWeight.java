package com.practice.graph;
import java.util.*;

public class ShortestDistanceBetweenTwoCityWeight {
	private static List<String> dijkstra(Map<String, List<CityPair>> graph, String src, String dest, int n){
		Map<String, Integer> dist = new HashMap<>();
		Map<String, String> parent = new HashMap<>();
		for(String s : graph.keySet()) {
			dist.put(s, Integer.MAX_VALUE);
			parent.put(s, s);
		}
		
		PriorityQueue<CityPair> pq = new PriorityQueue<>((a,b)->a.weight-b.weight);
		pq.add(new CityPair(src, 0));
		dist.put(src, 0);
		while(!pq.isEmpty()) {
			String node = pq.peek().city;
			int weight = pq.peek().weight;
			pq.remove();
			
			for(CityPair p : graph.get(node)) {
				String adjNode = p.city;
				int w = p.weight;
				if(weight + w < dist.get(adjNode)) {
					dist.put(adjNode, weight + w);
					parent.put(adjNode, node);
					pq.add(new CityPair(adjNode, weight+w));
				}
			}
		}
		for(Map.Entry<String, Integer> mp: dist.entrySet()) {
			System.out.println(mp.getKey()+"->"+mp.getValue());
		}
		if(dist.get(dest) == Integer.MAX_VALUE) {
			System.out.println("Not reachable");
		    return null;
		}
		System.out.println();
		List<String> path = new ArrayList<>();
		path.add(dest);
		String key = dest;
		while(parent.get(dest) != src) {
			path.add(0,parent.get(dest));
			dest = parent.get(dest);
		}
		path.add(0,src);
		for(String p : path)
			System.out.print(p+" ");
	    System.out.println(dist.get(key));
		return null;
	}
	public static void main(String[] args) {
		String[] input = { "5", "Patna", "Chapra", "Banglore", "Mumbai", "Delhi", "Patna-Chapra,340", "Patna-Banglore,8000",
				"Banglore-Mumbai,2000", "Banglore-Delhi,5000", "Mumbai-Delhi,2000" };
		
		int n = Integer.parseInt(input[0]);
		Map<String, List<CityPair>> g = new HashMap<>();
		for(int i=1;i<=n;i++) {
			List<CityPair>  p = new ArrayList<>();
			//p.add(new CityPair(input[i], 0));
			g.put(input[i], p);
		}
		
		for(int i=n+1;i<input.length;i++) {
			String []path= input[i].split(",");
			String []edge = path[0].split("-");
			//g.get(edge[0]).add(new CityPair(edge[0],0));
			g.get(edge[0]).add(new CityPair(edge[1], Integer.parseInt(path[1])));
			g.get(edge[1]).add(new CityPair(edge[0], Integer.parseInt(path[1])));
			
		}
		for(Map.Entry<String, List<CityPair>> m: g.entrySet()) {
			System.out.print(m.getKey()+"->");
			for(CityPair p : m.getValue()) {
				System.out.print("{ "+p.city+","+p.weight+" }, ");
			}
			System.out.println();
		}
		System.out.println();
		dijkstra(g, "Banglore","Delhi",n);
		
		
	}
}
