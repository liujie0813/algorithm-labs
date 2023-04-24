package com.timberliu.algorithm.company.hw.double_pointer.no049_2_subArrayNum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 49. 优雅子数组
 *
 * @author liujie
 * @date 2023/4/24
 */

public class Solution1 {

	public static int subArrayNum(int[] arr, int k) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int left = 0, right = 0, n = arr.length;
		while (right < n) {
			int e = arr[right];
			map.put(e, map.getOrDefault(e, 0) + 1);
			if (map.get(e) >= k) {
				res += n - right;

				map.put(arr[left], map.get(arr[left]) - 1);
				left++;

				// 不遗漏 [left, right-1] 的情况
				map.put(e, map.get(e) - 1);
				right--;
			}
			right++;
		}
		return res;
	}

	public static int subArrayNum1(int[] arr, int k) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int left = 0, right = 0, n = arr.length;
		while (right < n) {
			map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
			// 次数满足
			while (map.getOrDefault(arr[right], 0) >= k) {
				res += n - right;
				// 尝试缩小左边界
				map.put(arr[left], map.get(arr[left]) - 1);
				left++;
			}
			// 扩大右边界
			right++;
		}
		return res;
	}

	/**
	 * 10 3
	 * -1 0 1 2 3 1 2 3 1 0
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		int res = subArrayNum1(arr, k);
		System.out.println(res);
	}

}
