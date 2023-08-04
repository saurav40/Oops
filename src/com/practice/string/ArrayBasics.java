package com.practice.string;

public class ArrayBasics {
	public static void main(String[] args) {
      int arr[]={7,8,3,1,2};
      //int arr2[] = {7,8,3,1,2};
      //bubble_sort(arr);
      //selection_sort(arr);
      insertion_sort(arr);
      for(int i=0;i<arr.length;i++)
    	   System.out.print(arr[i]+" ");
	}
	//Bubble sort
	static void bubble_sort(int[] arr)
	{
		int n=arr.length;
		for(int i=0;i<n-1;i++)
		{  //1st 0 to 4
			System.out.print(arr[n-1-i]+" ");
			for(int j=0;j<n-i-1;j++)
			{
			  if(arr[j]>arr[j+1])
			  {
				  int tmp = arr[j];
				  arr[j] = arr[j+1];
				  arr[j+1] = tmp;
			  }
			}
			System.out.print(arr[n-1-i]);
			System.out.println();
		}
		System.out.println();
	}
	//selection sort
	static void selection_sort(int [] arr)
	{
		int  n = arr.length;
		for(int i=0;i<n;i++)
		{
			int min = i;
			
			for(int j=i+1;j<n;j++)
			{
				if(arr[j] < arr[min])
				{
					min = j;
				}
			}
			//swap
			int tmp = arr[min];
			arr[min] = arr[i];
			arr[i]=tmp;
				
		}
		
		
	}
	//insertion sort
	static void insertion_sort(int[] arr)
	{
		int n = arr.length;
		for(int i=1;i<n;i++)
		{   int current = arr[i];
		    int j=i-1;
			for(;j>=0;j--)
			{
				if(arr[j]>current)
				{
					arr[j+1]=arr[j];
				}
				else
					break;
			}
			arr[j+1] = current;
		}
	}
}
