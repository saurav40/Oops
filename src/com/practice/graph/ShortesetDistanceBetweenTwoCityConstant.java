package com.practice.graph;

import java.util.*;

 
public class ShortesetDistanceBetweenTwoCityConstant {
	private static List<String> bfs(Map<String, List<String>> graph, String source, String dest){
		
		Queue<CityNode> q = new LinkedList<>();
		Set<String> visited  = new HashSet<>();
		
		q.add(new CityNode(source, Arrays.asList(source)));
		visited.add(source);
		List<String> answer = new ArrayList<>();
		while(!q.isEmpty()) {
			String city = q.peek().city;
			List<String> cities = q.peek().connectedCities;
			q.remove();
			visited.add(city);
			if(city.equals(dest)) {
				return cities;
			}
			
			for(String adjNode : graph.get(city)) {
				//System.out.println(adjNode);
				if(!visited.contains(adjNode)) {
					List<String> newPath = new ArrayList<>(cities);
					newPath.add(adjNode);
					q.add(new CityNode(adjNode, newPath));
					visited.add(adjNode);
				}
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		String[] input = { "5", "Patna", "Chapra", "Banglore", "Mumbai", "Delhi", "Patna-Chapra", "Patna-Banglore",
				"Banglore-Mumbai", "Banglore-Delhi", "Mumbai-Delhi" };

		int n = Integer.parseInt(input[0]);

		Map<String, List<String>> mp = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			mp.put(input[i], new ArrayList<>());
		}
		
		for(int i=n+1;i<input.length;i++) {
			String[] edge = input[i].split("-");
			mp.get(edge[0]).add(edge[1]);
			mp.get(edge[1]).add(edge[0]);
		}
		for(Map.Entry<String, List<String>> m : mp.entrySet()) {
			System.out.print(m.getKey()+"->");
			for(String val : m.getValue()) {
				System.out.print(val+" ");
			}
			System.out.println();
		}
		List<String> path = bfs(mp, "Patna", "Delhi");
		for(String p : path) {
			System.out.print(p+" ");
		}
		
	}

}
