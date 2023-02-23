package com.timberliu.algorithm.leetcode.array.no0283_1_moveZeroes.related.other_1_removeAllDuplicates;

/**
 * 删除所有重复元素
 *   如果有重复元素，则删除所有该元素
 *
 * @author liujie
 * @date 2023/2/23
 */

public class Solution1 {

	public static int removeDuplicates(int[] nums) {
		int index = 0;
		int i = 0;
		while (i < nums.length) {
			if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
				while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
					i++;
				}
			} else {
				nums[index++] = nums[i];
			}
			i++;
		}
		return index;
	}

	public static void main(String[] args) {
		int[] nums1 = {1, 2, 2, 2, 3, 5};
		int res = removeDuplicates(nums1);
		System.out.println(res);
	}

}
