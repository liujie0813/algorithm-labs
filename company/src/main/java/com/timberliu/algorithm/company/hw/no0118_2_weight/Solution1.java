package com.timberliu.algorithm.company.hw.no0118_2_weight;

import java.util.*;

/**
 * 118. 称砝码
 *
 *  n
 *  weight:  4   2   3
 *  num:     2   3   2
 *
 *
 *
 * @author liujie
 * @date 2023/4/11
 */

public class Solution1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			int n = scanner.nextInt();
			int[] weight = new int[n];
			for (int i = 0; i < n; i++) {
				weight[i] = scanner.nextInt();
			}
			int[] num = new int[n];
			for (int i = 0; i < n; i++) {
				num[i] = scanner.nextInt();
			}
			Set<Integer> set = new HashSet<>();
			set.add(0);
			// 遍历砝码
			for (int i = 0; i < n; i++) {
				// 前面的砝码可以称的重量
				List<Integer> pre = new ArrayList<>(set);
				for (Integer w : pre) {
					// 遍历砝码数量
					for (int j = 1; j <= num[i]; j++) {
						set.add(w + weight[i] * j);
					}
				}
			}
			System.out.println(set.size());
		}
	}

}
