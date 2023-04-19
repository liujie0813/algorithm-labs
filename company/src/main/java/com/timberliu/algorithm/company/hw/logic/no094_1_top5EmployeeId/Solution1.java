package com.timberliu.algorithm.company.hw.logic.no094_1_top5EmployeeId;

import com.timberliu.algorithm.company.utils.PrintUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 94. 优秀学员统计
 *
 *  统计次数 + 自定义排序
 *
 * @author liujie
 * @date 2023/4/18
 */

public class Solution1 {

	public static List<Integer> top5EmployeeIds(List<List<Integer>> clockEmployeeIds) {
		// <id, [num, start]>
		Map<Integer, int[]> map = new HashMap<>();
		for (int i = 0; i < clockEmployeeIds.size(); i++) {
			for (Integer id : clockEmployeeIds.get(i)) {
				if (map.containsKey(id)) {
					map.get(id)[0]++;
				} else {
					map.put(id, new int[]{1, i});
				}
			}
		}

		// <id, num, start>
		List<int[]> list = new ArrayList<>();
		for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
			list.add(new int[]{entry.getKey(), entry.getValue()[0], entry.getValue()[1]});
		}

		list.sort((a, b) -> {
			if (a[1] == b[1]) {
				if (a[2] == b[2]) {
					return a[0] - b[0];
				}
				return a[2] - b[2];
			}
			return b[1] - a[1];
		});

		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < 5 && i < list.size(); i++) {
			res.add(list.get(i)[0]);
		}
		return res;
	}

	/**
	 * 0 1 7 10
	 * 0 1 6 10
	 * 10
	 * 10
	 * 10
	 * 10
	 * 10
	 * 10
	 * 10
	 * 10
	 * 10
	 * 10
	 * 10
	 * 10
	 * 10
	 * 10
	 * 10
	 * 10
	 * 10
	 * 10
	 * 10
	 * 10
	 * 10
	 * 10
	 * 10
	 * 10
	 * 10
	 * 10
	 * 6 10
	 * 7 10
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<List<Integer>> clockEmployeeIds = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			String line = scanner.nextLine();
			String[] ids = line.split(" ");
			List<Integer> list = Stream.of(ids).map(Integer::parseInt).collect(Collectors.toList());
			clockEmployeeIds.add(list);
		}

		List<Integer> res = top5EmployeeIds(clockEmployeeIds);
		PrintUtils.printListInteger(res);
	}

}
