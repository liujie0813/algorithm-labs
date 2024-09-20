package com.timberliu.algorithm.leetcode.array.no0169_2_majorityElement;

/**
 * 169. 多数元素
 *
 * 出现次数大于 n/2 的元素
 *
 * 1、map计数
 * 2、排序，找中位数
 * 3、摩尔投票法
 *    消除任意两个不同的数，在剩下的数中继续找众数
 *
 * @author liujie
 * @date 2024/9/20
 */

public class Solution1 {

	public int majorityElement(int[] nums) {
		int num = nums[0];
		int times = 1;
		for (int i = 1; i < nums.length; i++) {
			if (times == 0) {
				num = nums[i];
				times = 1;
			} else if (nums[i] == num) {
				times++;
			} else {
				times--;
			}
		}
		return num;
	}

	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		int[] arr = {1, 1, 1, 1, 2, 3};
		System.out.println(solution1.majorityElement(arr));
	}

}
