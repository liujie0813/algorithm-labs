package com.timberliu.algorithm.company.hw.volume_a.greedy.no072_2_fastestCheckEfficiency;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 72. 核酸最快检测效率
 *
 * @author Timber
 * @date 2023/4/22
 */
public class Solution1 {

	public static int fastestCheckEfficiency(int[] arr, int volunteerNum) {
		// <下次可提升的效率，当前效率，当前志愿者个数>
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->  {
			if (a[0] == b[0]) {
				// 按照当前志愿者个数，从大到小
				return b[2] - a[2];
			}
			// 按照下次可提升的效率，从大到小排序
			return b[0] - a[0];
		});
		for (int efficiency : arr) {
			pq.offer(new int[]{(int)(0.2 * efficiency), (int)(0.8 * efficiency), 0});
		}

		int res = 0;
		for (int i = 0; i < volunteerNum; i++) {
			if (pq.isEmpty()) {
				continue;
			}
			int[] element = pq.poll();
			if (element[2] == 3) {
				res += element[0] + element[1];
			} else {
				int next = (int)(element[2] == 0 ? 0.5 * element[0] : element[0]);
				pq.offer(new int[]{next, element[0] + element[1], element[2] + 1});
			}
		}
		while (!pq.isEmpty()) {
			res += pq.poll()[1];
		}
		return res;
	}

	/*
	 * 2 2
	 * 200 200
	 */
	/*
	 * 2 8
	 * 200 100
	 */
	/**
	 * 2 9
	 * 200 100
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int volunteerNum = scanner.nextInt();
		int[] arr = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = scanner.nextInt();
		}

		int res = fastestCheckEfficiency(arr, volunteerNum);
		System.out.println(res);
	}

}
