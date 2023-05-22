package com.timberliu.algorithm.company.hw.volume_a.greedy.no002_1_minRentBikeNum;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2. 租车骑绿岛
 *   weight [3, 2, 2, 1] 每个人的体重
 *     每个自行车限重 limit，限坐两人
 *     最少要多少辆自行车
 *
 *
 *
 * @author Timber
 * @date 2023/3/21
 */
public class Solution1 {

	public static int minRentBikeNum(int[] weight, int limit) {
		Arrays.sort(weight);

		int res = 0;
		int left = 0, right = weight.length - 1;
		while (left < right) {
			if (weight[left] + weight[right] > limit) {
				// 最轻和最重的人也会超载，只能坐最重的那个人一个
				res++;
				right--;
			} else {
				left++;
				right--;
				res++;
			}
		}
		return left == right ? res + 1 : res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		int[] weight = new int[n];
		for (int i = 0; i < n; i++) {
			weight[i] = scanner.nextInt();
		}
		int res = minRentBikeNum(weight, m);
		System.out.println(res);
	}

}
