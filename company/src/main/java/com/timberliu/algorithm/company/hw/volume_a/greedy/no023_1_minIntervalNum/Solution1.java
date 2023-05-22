package com.timberliu.algorithm.company.hw.volume_a.greedy.no023_1_minIntervalNum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 23. 区间交叠问题
 *
 * @author Timber
 * @date 2023/4/26
 */
public class Solution1 {

	public static int minIntervalNum(int[][] intervals, int[] connectors) {
		Arrays.sort(intervals, (a, b) -> {
			if (a[0] == b[0]) {
				return a[1] - b[1];
			}
			return a[0] - b[0];
		});

		// 区间之间的距离
		List<Integer> distances = new ArrayList<>();
		// 区间数量
		int result = 1;
		int lastRight = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			int curLeft = intervals[i][0];
			int curRight = intervals[i][1];
			if (curLeft <= lastRight) {
				lastRight = Math.max(curRight, lastRight);
			} else {
				result++;
				distances.add(curLeft - lastRight);
				lastRight = curRight;
			}
		}

		distances.sort(null);
		Arrays.sort(connectors);
		// 优先用小的连接器，，，连接小的区间距离
		int index = 0;
		for (int i = 0; i < connectors.length && index < distances.size(); i++) {
			if (connectors[i] >= distances.get(index)) {
				result--;
				index++;
			}
		}
		return result;
	}

	/**
	 *
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] intervalStrs = scanner.nextLine().split(",");

		int[][] intervals = new int[intervalStrs.length][2];
		for (int i = 0; i < intervals.length; i++) {
			String[] intervalStr = intervalStrs[i].substring(1, intervalStrs[i].length() - 1).split(",");
			intervals[i][0] = Integer.parseInt(intervalStr[0]);
			intervals[i][1] = Integer.parseInt(intervalStr[0]);
		}

		String connectorStr = scanner.nextLine();
		String[] connectorStrs = connectorStr.substring(1, connectorStr.length() - 1).split(",");
		int[] connectors = new int[connectorStrs.length];
		for (int i = 0; i < connectorStrs.length; i++) {
			connectors[i] = Integer.parseInt(connectorStrs[i]);
		}

		int res = minIntervalNum(intervals, connectors);
		System.out.println(res);
	}

}
