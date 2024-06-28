package com.timberliu.algorithm.leetcode.binary_search.no0004_3_medianOfTwoSortedArrays;

/**
 * 4. 两个正序数组的中位数
 *
 *  求中位数，即求第 k 小的数
 *
 * @author liujie
 * @date 2022/2/23
 */

public class Solution1 {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		int left = (m + n + 1) / 2;
		int right = (m + n + 2) / 2;
		// 应对奇偶数情况
		return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
	}

	public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		if ((m + n) % 2 == 0) {
			return (findKth(nums1, 0, nums2, 0, (m + n) / 2) + findKth(nums1, 0, nums2, 0, (m + n) / 2 + 1)) / 2.0;
		} else {
			return findKth(nums1, 0, nums2, 0, (m + n) / 2 + 1);
		}
	}

	// 找第 k 小的数
	public int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
		// 一个数组为空，返回另一个数组的第 k 个元素
		if (i >= nums1.length) {
			return nums2[j + k - 1];
		}
		if (j >= nums2.length) {
			return nums1[i + k - 1];
		}
		if (k == 1) {
			return Math.min(nums1[i], nums2[j]);
		}
		// 比较两数组的第 k/2 个元素
		int midVal1 = (i + k/2 - 1 < nums1.length) ? nums1[i + k/2 - 1] : Integer.MAX_VALUE;
		int midVal2 = (j + k/2 - 1 < nums2.length) ? nums2[j + k/2 - 1] : Integer.MAX_VALUE;
		if (midVal1 < midVal2) {
			return findKth(nums1, i + k/2, nums2, j, k - k/2);
		} else {
			return findKth(nums1, i, nums2, j + k/2, k - k/2);
		}
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/median-of-two-sorted-arrays/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.findMedianSortedArrays1(new int[]{1, 3},
				new int[]{2}));

		System.out.println("----- 2 -----");
		System.out.println(solution1.findMedianSortedArrays1(new int[]{1, 2},
				new int[]{3, 4}));

	}
}
