package com.practice.heap;

import javax.management.MXBean;

public class MaxHeap {
	private int arr[];
	private int size;
	private int index;

	public MaxHeap(int size) {
		// TODO Auto-generated constructor stub
		this.arr = new int[size+1];
		this.index = 1;
		this.size = size+1;
	}
	private void insert(int x) {
		arr[index] = x;
		// todo : adjust
		if(index == 1) {
			this.index ++;
			return;
		}
		int idx = index;
		while(arr[idx] > arr[idx/2]) {
			int temp = arr[idx/2];
			arr[idx/2] = arr[idx];
			arr[idx] = temp;
			idx = idx/2;
		}
		this.index++;
	}
	private void print() {
		for(int i=1;i<size;i++) {
			System.out.println(arr[i]);
		}
	}
	public static void main(String[] args) {
		MaxHeap obj = new MaxHeap(10);
		obj.insert(10);
		obj.insert(30);
		obj.print();
	}
}
