package com.practice.rakuten;
import java.util.*;
public class Test {
	private static boolean isPresent(int nums[], int target) {
		Map<Integer,Integer> mp  = new HashMap<>();
		// O(n) + O(1)/O(n) => O(2n) / O(n) =
		for(int i=0;i<nums.length;i++) {
			if(mp.containsKey(target-nums[i])) {
				return true;
			}
			mp.put(nums[i],i);
		}
		return false;
	}
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5};
		int target = 10;
		System.out.println(isPresent(arr, target));
	}
}
