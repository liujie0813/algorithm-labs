package com.timberliu.algorithm.offer.sort.no051_reversePairs;

/**
 * 51. 数组中的逆序对
 *
 *  归并排序
 *
 * @author liujie
 * @date 2021/9/8
 */

public class Solution1 {

	private int[] aux;

	public int reversePairs(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		aux = new int[nums.length];
		return doReversePairs(nums, 0, nums.length - 1);
	}

	private int doReversePairs(int[] nums, int left, int right) {
		if (left >= right) {
			return 0;
		}
		int mid = left + ((right - left) >> 1);
		int i = doReversePairs(nums, left, mid);
		int j = doReversePairs(nums, mid + 1, right);
		if (nums[mid] <= nums[mid + 1]) {
			return i + j;
		}
		return i + j + merge(nums, left, mid, right);
	}

	/**
	 *   left mid       right
	 *   5    7    4    6
	 */
	private int merge(int[] nums, int left, int mid, int right) {
		for (int i = left; i <= right; i++) {
			aux[i] = nums[i];
		}
		int index = left;
		int i = left;
		int j = mid + 1;
		int res = 0;
		while (i <= mid || j <= right) {
			if (i > mid) {
				nums[index++] = aux[j++];
			} else if (j > right) {
				nums[index++] = aux[i++];
			} else if (aux[i] <= aux[j]) {
				nums[index++] = aux[i++];
			} else {
				res += mid - i + 1;
				nums[index++] = aux[j++];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.reversePairs(new int[]{7, 5, 6, 4}));

		System.out.println("----- 2 -----");
		System.out.println(solution1.reversePairs(new int[]{1, 3, 2, 3, 1}));

	}
}
