package com.timberliu.algorithm.company.hw.logic.no032_2_bestCheckPoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 32. 优选核酸检测点
 *
 *  每人做核酸花费一分钟
 *
 *  8~10 每分钟增加 3 人
 *  12~14 每分钟增加 10 人
 *  18~20 每分钟增加 20 人
 *  其他时间每五分钟增加 1 人
 *
 * @author liujie
 * @date 2023/4/25
 */

public class Solution1 {

	// 各时间段，每分钟净增加人数
	public static double[][] times = {
			{8 * 60, 10 * 60, 2},
			{10 * 60, 12 * 60, -0.8},
			{12 * 60, 14 * 60, 9},
			{14 * 60, 18 * 60, -0.8},
			{18 * 60, 20 * 60, 19},
	};

	public static List<int[]> bestCheckPoint(int[][] arr, int startHour, int startMinute, int endHour, int endMinute) {
		int startTime = startHour * 60 + startMinute;
		// id, totalCostTime, totalFee
		List<int[]> list = new ArrayList<>();
		for (int[] subArr : arr) {
			int id = subArr[0];
			// 距离
			int distance = subArr[1];
			// 出发前等待的人数
			int wait = subArr[2];
			// 路上花费的时间，也是费用
			int cost = distance * 10;
			// 到达的时间
			int arriveTime = startTime + distance * 10;
			if (arriveTime < 8 * 60) {
				// 排在初始人数后面
				list.add(new int[]{id, cost + wait, cost});
				// 排在初始人数前面
//				list.add(new int[]{id, arriveTime - startTime, cost});
				continue;
			}
			// 到达时等待的人数
			for (double[] time : times) {
				double s1 = time[0];
				double e1 = time[1];
				double changePerMinute = time[2];
				double t = intersection(startTime, arriveTime, s1, e1);
				if (t > 0) {
					wait += t * changePerMinute;
					wait = Math.max(0, wait);
				}
			}
			list.add(new int[]{id, cost + wait, cost});
		}

		int endTime = Math.min(endHour * 60 + endMinute, 20 * 60);
		// 过滤掉超出时间的
		return list.stream().filter(subArr -> startTime + subArr[1] < endTime).sorted((a, b) -> {
			if (a[1] == b[1]) {
				if (a[2] == b[2]) {
					return a[0] - b[0];
				}
				return a[2] - b[2];
			}
			return a[1] - b[1];
		}).collect(Collectors.toList());
	}

	private static double intersection(double s1, double e1, double s2, double e2) {
		if (s1 <= s2 && s2 < e1) {
			return Math.min(e1, e2) - s2;
		}
		if (s2 <= s1 && s1 < e2) {
			return Math.min(e1, e2) - s1;
		}
		return 0;
	}

	/**
	 * 10 30
	 * 14 50
	 * 3
	 * 1 10 19
	 * 2 8 20
	 * 3 21 3
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int startHour = scanner.nextInt();
		int startMinute = scanner.nextInt();
		int endHour = scanner.nextInt();
		int endMinute = scanner.nextInt();
		int n = scanner.nextInt();
		int[][] arr = new int[n][3];
		for (int i = 0; i < n; i++) {
			arr[i][0] = scanner.nextInt();
			arr[i][1] = scanner.nextInt();
			arr[i][2] = scanner.nextInt();
		}

		List<int[]> res = bestCheckPoint(arr, startHour, startMinute, endHour, endMinute);
		System.out.println(res.size());
		for (int i = 0; i < res.size(); i++) {
			int[] sub = res.get(i);
			System.out.println(sub[0] + " " + sub[1] + " " + sub[2]);
		}
	}

}
