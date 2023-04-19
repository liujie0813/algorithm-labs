package com.timberliu.algorithm.company.hw.binary_search.no111_1_maxAvgSubArray;

import java.util.Scanner;

/**
 * 117. 几何平均值最大子数组
 *
 *  n: 10^6
 *  几何平均值：k个数的乘积的 k 次方根
 *  找出长度至少为 l，几何平均值最大的子数组，其下标和长度
 *
 *  a[0] * a[1] * a[2] * ... * a[k-1] = res ^ k， res 即为几何平均值
 *  (a[0] / res) * (a[1] / res) * (a[2] / res) * ... * (a[k-1] / res) = 1
 *
 *  如果多个子数组的几何平均值都为最大值，这输出长度最小的；如果长度也相同，则输出最前面的；
 *
 * @author liujie
 * @date 2023/4/13
 */
public class Solution1 {

	public static int[] maxAvgSubArray(double[] nums, int minLen) {
		// res[0] 位置；res[1] 最大的几何平均值
		int[] res = new int[2];

		// 几何平均值介于 [minVal, maxVal]
		double maxVal = Integer.MIN_VALUE;
		double minVal = Integer.MAX_VALUE;
		double prefixProduct = 1;
		for (int i = 0; i < nums.length; i++) {
			maxVal = Math.max(maxVal, nums[i]);
			minVal = Math.min(minVal, nums[i]);
			if (i < minLen) {
				prefixProduct *= nums[i];
			}
		}

		// double 判断相等的方法
		// 二分法
		while (maxVal - minVal >= Math.pow(10, -10)) {
			double mid = (minVal + maxVal) / 2;
			// 是否存在长度大于等于 minLen 的子数组，其几何平均值大于等于 mid
			if (cal(nums, mid, prefixProduct, minLen, res)) {
				minVal = mid;
			} else {
				maxVal = mid;
			}
		}
		return res;
	}

	/**
	 * 几何平均值是否大于等于 avg
	 *  prefixProduct >= avg^k  等价于  prefixProduct / avg^k >=1
	 *
	 *  子数组扩大
	 *  prefixProduct / avg^k * (nums[i] / avg) >= 1
	 */
	public static boolean cal(double[] nums, double avg, double prefixProduct, int minLen, int[] res) {
		double p = prefixProduct / Math.pow(avg, minLen);
		// 最小长度的子数组，满足当前的几何平均值 avg 了
		if (p >= 1) {
			res[0] = 0;
			res[1] = minLen;
			return true;
		}

		double preP = 1;
		double minPreP = Integer.MAX_VALUE;
		int minPrePIndex = 0;
		for (int i = minLen; i < nums.length; i++) {
			// [0, i]
			p *= nums[i] / avg;
			// [0, i-minLen] 之间的最小 p = minPrePIndex
			preP *= nums[i - minLen] / avg;
			if (preP < minPreP) {
				minPreP = preP;
				minPrePIndex = i - minLen;
			}
			if (p / minPreP >= 1) {
				// [minPrePIndex, i] 满足条件
				res[0] = minPrePIndex + 1;
				res[1] = i - minPrePIndex;
				return true;
			}
		}
		return false;
	}

	/**
	 * eg1:
	 * 10 2
	 * 0.2
	 * 0.1
	 * 0.2
	 * 0.2
	 * 0.2
	 * 0.1
	 * 0.2
	 * 0.2
	 * 0.2
	 * 0.2
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int minLen = scanner.nextInt();
		double[] nums = new double[n];
		for (int i = 0; i < n; i++) {
			nums[i] = scanner.nextDouble();
		}

		int[] res = maxAvgSubArray(nums, minLen);
		System.out.println(res[0] + " " + res[1]);
	}

}
