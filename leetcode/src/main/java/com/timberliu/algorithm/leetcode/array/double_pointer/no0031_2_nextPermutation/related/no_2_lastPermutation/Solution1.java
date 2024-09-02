package com.timberliu.algorithm.leetcode.array.double_pointer.no0031_2_nextPermutation.related.no_2_lastPermutation;

import java.util.Arrays;

/**
 * 上一个排列
 *   字节真题
 *
 *  1 4 2 3 5 6
 *
 *  1 3 6 5 4 2
 *
 * @author liujie
 * @date 2024/8/30
 */

public class Solution1 {

	public void lastPermutation(int[] nums) {

		int j = nums.length - 1, i = j - 1;
		while (i >= 0 && nums[i] <= nums[j]) {
			i--;
			j--;
		}

		if (j == 0) {
			reverse(nums, 0, nums.length - 1);
		} else {
			int k = nums.length - 1;
			while (k >= 0 && nums[k] >= nums[i]) {
				k--;
			}
			int tmp = nums[k];
			nums[k] = nums[i];
			nums[i] = tmp;
			reverse(nums, j, nums.length - 1);
		}
	}

	private void reverse(int[] nums, int left, int right) {
		while (left <= right) {
			int tmp = nums[left];
			nums[left] = nums[right];
			nums[right] = tmp;
			left++;
			right--;
		}
	}

	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		int[] nums1 = {1, 4, 2, 3, 5, 6};
		solution1.lastPermutation(nums1);
		System.out.println(Arrays.toString(nums1));

	}

}
