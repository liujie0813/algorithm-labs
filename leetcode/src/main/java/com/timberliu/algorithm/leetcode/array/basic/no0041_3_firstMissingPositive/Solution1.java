package com.timberliu.algorithm.leetcode.array.basic.no0041_3_firstMissingPositive;

/**
 * 41. 缺少的第一个正数
 *
 *  原地哈希
 *
 * @author liujie
 * @date 2024/6/19
 */

public class Solution1 {

	public int firstMissingPositive(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
				swap(nums, i, nums[i] - 1);
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}

	private void swap(int[] nums, int left, int right) {
		int tmp = nums[left];
		nums[left] = nums[right];
		nums[right] = tmp;
	}

	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		System.out.println(solution1.firstMissingPositive(new int[]{3, 4, -1, 1}));
	}

}
