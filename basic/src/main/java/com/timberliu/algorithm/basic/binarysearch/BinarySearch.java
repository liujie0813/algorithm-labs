package com.timberliu.algorithm.basic.binarysearch;

/**
 * @author liujie
 * @date 2023/4/14
 */

public class BinarySearch {

	public static int binarySearch(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int res = binarySearch(new int[]{1, 3, 5, 7, 9, 11}, 9);
		System.out.println(res);
	}

}
