package com.practice.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Queue {
	public static void main(String[] args) {
          int arr[] = {0,0,1,2,3,3,4,7,7,8};
                   // {2,1,0,1,2}
          
          PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
          
          for(int i=0;i<arr.length;i++)
          {
        	  int abs = Math.abs(arr[i]-5);
        	  pq.add(new int[] {abs,arr[i]});
          }
          List<Integer> ans = new ArrayList<>();
          int cnt = 1;
//          while(!pq.isEmpty() && cnt <1)
//          {
//        	  pq.remove();
//        	  cnt++;
//          }
          while(!pq.isEmpty() && cnt<=3)
          {
        	  int res[]=pq.peek();
        	  pq.remove();
        	  ans.add(res[0]);
        	  cnt++;
          }
          Collections.reverse(ans);
          for(int x:ans)
        	  System.out.print(x+" ");
          
	}
}
