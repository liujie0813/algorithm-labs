package com.timberliu.algorithm.leetcode.greedy.no0435_2_nonOverlappingIntervals.no0452_2_minimumNumberOfArrowsToBurstBalloons;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. 用最少数量的箭引爆气球
 *
 *
 *  points：[[10,16],[2,8],[1,6],[7,12]]  每个元素表示气球的开始横坐标和结束横坐标
 *
 *  贪心：当气球出现重叠时，一起射
 *
 * @author Timber
 * @date 2021/11/8
 */
public class Solution1 {

	public int findMinArrowShots(int[][] points) {
		if (points.length == 0) {
			return 0;
		}
		// 按左边界排序
		Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
		int result = 1;
		// 从前到后遍历
		for (int i = 1; i < points.length; i++) {
			// i 左边界大于 i-1 右边界，不挨着 result++
			if (points[i][0] > points[i - 1][1]) {
				result++;
			} else {
				// i 与 i-1 挨着，更新重叠气球最小右边界
				points[i][1] = Math.min(points[i - 1][1], points[i][1]);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.findMinArrowShots(new int[][]{
				{10, 16},
				{2, 8},
				{1, 6},
				{7, 12}
		}));

		System.out.println("----- 2 -----");
		System.out.println(solution1.findMinArrowShots(new int[][]{
				{1, 2},
				{3, 4},
				{5, 6},
				{7, 8}
		}));

		System.out.println("----- 3 -----");
		System.out.println(solution1.findMinArrowShots(new int[][]{
				{1, 2},
				{2, 3},
				{3, 4},
				{4, 5}
		}));

		System.out.println("----- 4 -----");
		System.out.println(solution1.findMinArrowShots(new int[][]{
				{1, 2},
		}));

		System.out.println("----- 5 -----");
		System.out.println(solution1.findMinArrowShots(new int[][]{
				{2, 3},
				{2, 3},
		}));

	}

}
