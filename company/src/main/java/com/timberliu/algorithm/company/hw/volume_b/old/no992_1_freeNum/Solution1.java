package com.timberliu.algorithm.company.hw.volume_b.old.no992_1_freeNum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 免单统计
 *
 * @author liujie
 * @date 2023/5/26
 */

public class Solution1 {

	public static int freeNum(String[] arr) {
		Arrays.sort(arr);

		List<String> list = new ArrayList<>();
		list.add(arr[0]);
		int index = 1;
		while (index < arr.length) {
			String cur = arr[index++];
			String last = list.get(list.size() - 1);
			// 同一秒的最早下单的那几个（相等）
			// 下一秒了
			if (cur.equals(last) || !cur.substring(0, 19).equals(last.substring(0, 19))) {
				list.add(cur);
			}
		}
		return list.size();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextLine();
		}

		int res = freeNum(arr);
		System.out.println(res);
	}

}
