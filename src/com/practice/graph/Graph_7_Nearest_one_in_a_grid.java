package com.practice.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph_7_Nearest_one_in_a_grid {
	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 } };
		int[][] res = find_nearest_1_in_a_grid(grid);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	} 

	private static int[][] find_nearest_1_in_a_grid(int[][] grid) {
		// 1. Using BFS
		int n = grid.length;
		int m = grid[0].length;
		boolean[][] visited = new boolean[n][m];
		int[][] dist = new int[n][m];
		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					q.add(new Node(i, j, 0));
					visited[i][j] = true;
				}
			}

		int deltaR[] = { -1, 0, 1, 0 };
		int deltaC[] = { 0, -1, 0, 1 };
		while (!q.isEmpty()) {
			int row = q.peek().x;
			int col = q.peek().y;
			int distance = q.peek().distance;
			q.remove();
			dist[row][col] = distance;

			for (int i = 0; i < 4; i++) {
				int nrow = row + deltaR[i];
				int ncol = col + deltaC[i];

				if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !visited[nrow][ncol]) {
					q.add(new Node(nrow, ncol, distance + 1));
					visited[nrow][ncol] = true;
				}
			}
		}
		return dist;
	}
}
