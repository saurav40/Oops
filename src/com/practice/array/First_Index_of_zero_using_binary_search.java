package com.practice.array;

public class First_Index_of_zero_using_binary_search {
	public static void main(String[] args) {
        int []arr = {1,1,1,1,1,0,0,0,0};
        
        int low = 0;
        int high = arr.length-1;
        while(low<=high)
        {
        	int mid = (low+high)/2;
        	
        	if(arr[mid] == 0 && arr[mid-1]!=0)
        	{
        		System.out.println(mid);
        		break;
        	}
        	else if(arr[mid] == 0 )
        	{
        		System.out.println("once"+mid);
        		high = mid -1;
        	}
        	else if(arr[mid] > 0)
        	{
        		low = mid+1;
        	}
        	else
        		high = mid-1;
        }
	}
}
