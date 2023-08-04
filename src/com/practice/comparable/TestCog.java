package com.practice.comparable;

import java.util.ArrayList;
import java.util.HashSet;

public class TestCog {
  public static void main(String[] args) {
	  int []arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      int [][]arr2 = {{1, 1, 2, 3}, 
              {4, 5, 6, 7}, 
              {7, 8, 9, 10}
            };
           //    1 2 3 _ 4 5 6 7 _ 7 8 9 10
     // expeted_output = [1,2,3,4,5,6,8,9,10];
     //remove duplicate first
     int i=0;
     ArrayList<Integer> ans = new ArrayList<>();
     while(i<arr1.length)
     {
         //int row = 0,col =0;
         
         for(int j=0;j<arr2.length;j++)
         {
        	 int cnt = 0;
             for(int k=0;k<arr2[0].length;k++)
             {  
                if(arr2[j][k]==arr1[i] && cnt == 0)
                {
                      cnt++;
                      ans.add(arr2[j][k]);
                }
             }
         }
         i++;
     }
    
     HashSet<Integer> ans2 = new HashSet<>();
     for(int x : ans)
     {  // System.out.println(x+" ");
         if(ans2.contains(x))
         {
             ans2.remove(x);
             continue;
         }
         else
           ans2.add(x);
     }
    System.out.println(ans2);
  }
}
