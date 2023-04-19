package com.timberliu.algorithm.company.hw.priority_queue.no095_2_noOfMaxPerson;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 95. 人数最多的站点
 *
 *  最大重叠区间数，对应的起点
 *
 *  O(nlogn)
 *
 *  如果数量级不大，可以遍历每个区间，再遍历每个区间的起点到终点，使用 map 计数，O(nk)
 *
 * @author liujie
 * @date 2023/4/18
 */

public class Solution1 {

	public static int maxPerson(int[][] arr) {
		List<int[]> list = new ArrayList<>();
		int max = 0;
		for (int[] sub : arr) {
			max = Math.max(max, Math.max(sub[0], sub[1]));
		}
		for (int[] sub : arr) {
			if (sub[0] > sub[1]) {
				list.add(new int[]{sub[0], max});
				list.add(new int[]{1, sub[1]});
			} else {
				list.add(sub);
			}
		}

		list.sort((a, b) -> {
			if (a[0] == b[0]) {
				return a[1] - b[1];
			}
			return a[0] - b[0];
		});

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int maxNum = 0;
		int res = 0;
		for (int[] cur : list) {
			while (!pq.isEmpty()) {
				int peek = pq.peek();
				if (peek < cur[0]) {
					pq.poll();
				} else {
					break;
				}
			}
			pq.offer(cur[1]);
			if (pq.size() > maxNum) {
				maxNum = pq.size();
				res = cur[0];
			}
		}
		return res;
	}

	/**
	 * 4
	 * 1 3
	 * 2 4
	 * 1 4
	 * 1 2
	 *
	 *  1  2
	 *  1     3
	 *  1        4
	 *     2     4
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			arr[i][0] = scanner.nextInt();
			arr[i][1] = scanner.nextInt();
		}
		int res = maxPerson(arr);
		System.out.println(res);
	}

}
