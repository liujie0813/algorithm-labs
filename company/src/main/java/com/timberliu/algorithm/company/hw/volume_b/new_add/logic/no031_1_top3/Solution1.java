package com.timberliu.algorithm.company.hw.volume_b.new_add.logic.no031_1_top3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 31. 比赛的冠亚季军
 *
 * @author liujie
 * @date 2023/6/1
 */

public class Solution1 {

	public static int[] top3(List<int[]> list) {
		List<int[]> winGroup = new ArrayList<>();
		List<int[]> loseGroup = new ArrayList<>();

		match(list, winGroup, loseGroup);
		winGroup.sort((a, b) -> {
			if (a[1] == b[1]) {
				return a[0] - b[0];
			}
			return b[1] - a[1];
		});
		loseGroup.sort((a, b) -> {
			if (a[1] == b[1]) {
				return a[0] - b[0];
			}
			return b[1] - a[1];
		});
		return new int[]{winGroup.get(0)[0], winGroup.get(1)[0], loseGroup.get(0)[0]};
	}

	private static void match(List<int[]> list, List<int[]> winGroup, List<int[]> loseGroup) {
		List<int[]> res = new ArrayList<>();
		int size = list.size();
		for (int i = 0; i + 1 < list.size(); i += 2) {
			int[] first = list.get(i);
			int[] second = list.get(i + 1);
			if (first[1] >= second[1]) {
				res.add(first);
				if (size <= 4) {
					winGroup.add(first);
					loseGroup.add(second);
				}
			} else {
				res.add(second);
				if (size <= 4) {
					winGroup.add(second);
					loseGroup.add(first);
				}
			}
		}
		if (list.size() % 2 == 1) {
			int[] last = list.get(list.size() - 1);
			res.add(last);
			if (size == 3) {
				winGroup.add(last);
			}
		}
		if (res.size() > 4) {
			match(res, winGroup, loseGroup);
		}
	}

	/**
	 * 2 3 4 5
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] splits = scanner.nextLine().split(" ");
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < splits.length; i++) {
			int[] arr = {i, Integer.parseInt(splits[i])};
			list.add(arr);
		}
		int[] res = top3(list);
		System.out.println(res[0] + " " + res[1] + " " + res[2]);
	}


}
