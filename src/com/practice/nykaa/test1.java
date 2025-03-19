package com.practice.nykaa;

public class test1 {
	private static void backtrack(int cnt[],int row, int col, int n, int m) {
		// check
		if(row < 0 || col < 0 || row >= m || col >= n) {
			return;
		}
		
		if(row == m-1 && col == n-1) {
			cnt[0]++;
		}
		
		//bottom
		backtrack(cnt, row+1, col, n, m);
		
		//right
		backtrack(cnt, row, col+1, n, m);
		
		
	}
	public static void main(String[] args) {
	   int n = 7, m=3;
	   
       int grid[][] = new int[m][n];
       
       //boolean visited[][] = new boolean[m][n];
       
       int []cnt = {0};
       
       backtrack(cnt, 0, 0, n, m );
      
       System.out.println(cnt[0]);
	}
}
