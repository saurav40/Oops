package com.practice.starategyPattern;

public class InsertionSort implements Sortstrategy{
	private void swap(int arr[], int i, int j) {
		arr[i] = arr[i]^arr[j];
		arr[j] = arr[i]^arr[j];
		arr[i] = arr[i]^arr[j];
	}

	@Override
	public void sort(int[] arr) {
		// TODO Auto-generated method stub
		System.out.println("Insertion sorting");
		int n = arr.length;
		for(int i=0;i<n;i++) {
			int j=i;
			while(j>0 && arr[j] < arr[j-1]) {
				swap(arr,j,j-1);
				j--;
			}
		}
	}
}
