package com.practice.starategyPattern;

public class BubbleSort implements Sortstrategy{
 
	private void swap(int arr[], int i, int j) {
		arr[i] = arr[i]^arr[j];
		arr[j] = arr[i]^arr[j];
		arr[i] = arr[i]^arr[j];
	}
	@Override
	public void sort(int[] arr) {
		int n = arr.length;
		System.out.println("Bubble Sorting..");
		for(int i=0;i<n-1;i++) {
			boolean isSwapped = false;
			for(int j=0;j<n-1-i;j++) {
				if(arr[j] > arr[j+1]) {
					swap(arr,j,j+1);
					isSwapped = true;
				}
			}
			if(!isSwapped) {
				break;
			}
		}
		
	}

}
