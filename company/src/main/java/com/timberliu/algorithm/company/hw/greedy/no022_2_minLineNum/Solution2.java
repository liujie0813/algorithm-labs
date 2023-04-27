package com.timberliu.algorithm.company.hw.greedy.no022_2_minLineNum;

import java.util.*;

/**
 * 22. 区间交叠问题
 *
 * @author liujie
 * @date 2023/4/27
 */

public class Solution2 {

	public static int minLineNum(int[][] arr) {
		Arrays.sort(arr, (a, b) -> {
			if (a[0] == b[0]) {
				return b[1] - a[1];
			}
			return a[0] - b[0];
		});

		List<int[]> res = new ArrayList<>();
		res.add(arr[0]);

		int index = 1;
		while (index < arr.length) {
			int lastRight = res.get(res.size() - 1)[1];
			// 左端点 小于等于 上一个区间右端点 的线段
			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
			while (index < arr.length && arr[index][0] <= lastRight) {
				pq.offer(arr[index++]);
			}
			if (pq.isEmpty()) {
				// 没有与上一个区间有交集的线段
				res.add(arr[index++]);
			} else {
				// 有交集的线段中，选右端点最大的
				res.add(pq.peek());
			}
		}
		return res.size();
	}

	/*
	 * 3
	 * 1,4
	 * 2,5
	 * 3,6
	 */
	/*
	 * 3
	 * 1,10
	 * 5,12
	 * 8,11
	 */
	/**
	 * 8
	 * 0,4
	 * 1,2
	 * 1,4
	 * 3,7
	 * 6,8
	 * 10,12
	 * 11,13
	 * 12,14
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			String[] splits = scanner.nextLine().split(",");
			arr[i][0] = Integer.parseInt(splits[0]);
			arr[i][1] = Integer.parseInt(splits[1]);
		}

		int res = minLineNum(arr);
		System.out.println(res);
	}

}
