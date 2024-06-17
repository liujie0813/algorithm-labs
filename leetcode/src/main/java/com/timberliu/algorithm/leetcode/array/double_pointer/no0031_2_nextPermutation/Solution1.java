package com.timberliu.algorithm.leetcode.array.double_pointer.no0031_2_nextPermutation;

/**
 * 31. 下一个排列
 *
 *  1 3 6 5 4 2
 *
 *  1 4 2 3 5 6
 *
 * @author liujie
 * @date 2024/6/17
 */

public class Solution1 {

	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		// 从后往前 找到第一个逆序对
		int j = nums.length - 1, i = j - 1;
		while (i >= 0 && nums[i] >= nums[j]) {
			i--;
			j--;
		}

		if (j == 0) {
			reverse(nums, 0, nums.length - 1);
		} else {
			// 增加的幅度要尽可能小
			// j 之后递减，从末尾到 j 找第一个比 i 大的数
			int k = nums.length - 1;
			while (k >= j && nums[k] <= nums[i]) {
				k--;
			}
			// 稍大的数，交换到前面
			int tmp = nums[k];
			nums[k] = nums[i];
			nums[i] = tmp;
			// j 之后递减，逆序
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

	}

}
