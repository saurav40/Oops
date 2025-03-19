package com.practice.starategyPattern;

public class SelectionSort implements Sortstrategy{
	private void swap(int arr[], int i, int j) {
		arr[i] = arr[i]^arr[j];
		arr[j] = arr[i]^arr[j];
		arr[i] = arr[i]^arr[j];
	}
	@Override
	public void sort(int[] arr) {
      int n = arr.length;
      System.out.println("Selection sorting...");
      for(int i=0;i<n;i++) {
    	  int min = i;
    	  for(int j=i+1;j<n;j++) {
    		  if(arr[min] > arr[j]) {
    			  min = j;
    		  }
    	  }
    	  if(min != i) {
    		 swap(arr, min,i);
    	  }
      }
	}

}
