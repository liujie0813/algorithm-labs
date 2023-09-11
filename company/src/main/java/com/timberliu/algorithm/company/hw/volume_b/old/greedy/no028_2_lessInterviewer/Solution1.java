package com.timberliu.algorithm.company.hw.volume_b.old.greedy.no028_2_lessInterviewer;

import java.util.*;

/**
 * 28. 最少面试官
 *
 * @author Timber
 * @date 2023/6/4
 */
public class Solution1 {

	public static int lessInterviewer(int[][] arr, int n, int m) {
		// 求不相交区间，按结束位置排序
		Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));
		// 桶，维护面试结束时间
		List<List<Integer>> buckets = new ArrayList<>();
		doInterview(arr, 0, buckets, m);
		return buckets.size();
	}

	private static void doInterview(int[][] arr, int index, List<List<Integer>> buckets, int m) {
		if (index == arr.length) {
			return;
		}
		for (List<Integer> bucket : buckets) {
			if (bucket.size() == m) {
				continue;
			}
			if (arr[index][0] >= bucket.get(bucket.size() - 1)) {
				bucket.add(arr[index][1]);
				doInterview(arr, index + 1, buckets, m);
				return;
			}
		}
		buckets.add(new ArrayList<>(Collections.singleton(arr[index][1])));
		doInterview(arr, index + 1, buckets, m);
	}

	/**
	 * 3
	 * 5
	 * 1 6
	 * 2 3
	 * 3 4
	 * 4 5
	 * 5 6
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			arr[i][0] = scanner.nextInt();
			arr[i][1] = scanner.nextInt();
		}

		int res = lessInterviewer(arr, n, m);
		System.out.println(res);
	}

}
