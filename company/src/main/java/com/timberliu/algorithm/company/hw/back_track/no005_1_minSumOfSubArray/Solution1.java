package com.timberliu.algorithm.company.hw.back_track.no005_1_minSumOfSubArray;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 5. 等和子数组最小和
 *
 *  将一组元素拆分为多个子数组，使得每组和相等。求组内元素和的最小值
 *
 *   搜索+剪枝
 *
 *   对于 n 个元素，依次判断是否可以拆分为 k 个桶（1 <= k <= n）
 *
 *   回溯：
 *    1. 将第 i 个球，尝试放入每一个桶中
 *         如果放入 i 后当前桶不超过 sum/k=target，则继续尝试去放下一个球到每个桶中
 *    2. 终止条件：如果所有球都放入桶里了，则表示满足条件 target 条件
 *
 *   回溯剪枝：
 *    1. 纵向：某个桶元素和超过 target 则跳过
 *    2. 横向：当前桶与上一个桶的元素和相等，则跳过
 *
 * @author Timber
 * @date 2023/4/6
 */
public class Solution1 {

	private static int minSumOfSubArray(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		Arrays.sort(nums);

		for (int k = nums.length; k > 0; k--) {
			// 不能拆分为 k 个桶
			if (sum % k != 0) {
				continue;
			}
			int[] bucket = new int[k];
			if (canSplit(nums, nums.length - 1, bucket, k, sum / k)) {
				return sum / k;
			}
		}
		return sum;
	}

	/**
	 * 每次考虑第 cur 个球，尝试放入各个桶中
	 * @param cur 第 cur 个球
	 * @param k 拆分为 k 个桶
	 * @param target 每个桶的目标和
	 */
	private static boolean canSplit(int[] nums, int cur, int[] bucket, int k, int target) {
		if (cur == -1) {
			// 如果所有球能按要求放入桶中，则每个桶内的球的和一定为 target
//			for (int val : bucket) {
//				if (val != target) {
//					return false;
//				}
//			}
			return true;
		}
		for (int i = 0; i < k; i++) {
			// 如果和上一个桶的元素和相等，则可以跳过当前桶
			// 放到上一个桶，和放入当前桶，结果是一致的
			if (i > 0 && bucket[i] == bucket[i - 1]) {
				continue;
			}
			// 放入球后，桶内元素和超过 target，尝试下一个桶
			if (bucket[i] + nums[cur] > target) {
				continue;
			}
			bucket[i] += nums[cur];
			if (canSplit(nums, cur - 1, bucket, k, target)) {
				return true;
			}
			bucket[i] -= nums[cur];
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int[] nums = new int[m];
		for (int i = 0; i < m; i++) {
			nums[i] = scanner.nextInt();
		}
		int res = minSumOfSubArray(nums);
		System.out.println(res);
	}

}
