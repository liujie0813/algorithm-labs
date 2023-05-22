package com.timberliu.algorithm.company.hw.volume_a.binary_search.no108_2_minInstanceSum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 108. 服务中心选址
 *
 *  服务中心的地址，最小距离和
 *   必然在 [min, max] 之间，且从左到右，距离和呈凹函数
 *   最小距离和就是求凹函数的极值（最小值）
 *
 *  三分法
 *
 * @author liujie
 * @date 2023/4/14
 */

public class Solution1 {

	/**
	 * 三等分
	 */
	public static int minInstanceSum(double[][] positions) {
		List<Double> list = new ArrayList<>();
		for (double[] position : positions) {
			list.add(position[0]);
			list.add(position[1]);
		}
		list.sort(null);
		double left = list.get(0);
		double right = list.get(list.size() - 1);
		while (right - left >= 0.00001) {
			double diff = (right - left) / 3;
			double leftM = left + diff;
			double rightM = right - diff;
			if (getInstance(positions, leftM) < getInstance(positions, rightM)) {
				right = rightM;
			} else {
				left = leftM;
			}
		}
		return (int) getInstance(positions, left);
	}

	public static double getInstance(double[][] positions, double location) {
		double res = 0;
		for (double[] position : positions) {
			double left = position[0];
			double right = position[1];
			if (right < location) {
				res += location - right;
			} else if (location < left) {
				res += left - location;
			}
		}
		return res;
	}

	/*
	 * 4
	 * 5 6
	 * 1 8
	 * 7 15
	 * 2 4
	 */
	/**
	 * 6
	 * 1 3
	 * 4 9
	 * 2 15
	 * 6 27
	 * 15 17
	 * 5 8
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		double[][] positions = new double[n][2];
		for (int i = 0; i < n; i++) {
			positions[i][0] = scanner.nextInt();
			positions[i][1] = scanner.nextInt();
		}

		int res = minInstanceSum(positions);
		System.out.println(res);
	}

}
