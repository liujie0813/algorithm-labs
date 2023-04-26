package com.timberliu.algorithm.company.hw.logic.no027_1_mergePort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 27. 端口合并
 *
 * @author Timber
 * @date 2023/4/26
 */
public class Solution1 {

	public static boolean mergeGroup(List<TreeSet<Integer>> groups) {
		for (int i = groups.size() - 1; i >= 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				TreeSet<Integer> first = groups.get(j);
				TreeSet<Integer> second = groups.get(i);
				if (check(first, second)) {
					first.addAll(second);
					groups.remove(i);
					return true;
				}
			}
		}
		return false;
	}

	public static boolean check(TreeSet<Integer> group1, TreeSet<Integer> group2) {
		int count = 0;
		for (Integer val : group1) {
			if (group2.contains(val)) {
				count++;
			}
			if (count >= 2) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 6
	 * 10
	 * 4,2,1
	 * 9
	 * 3,6,9,2
	 * 6,3,4
	 * 8
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = Integer.parseInt(scanner.nextLine());

		List<TreeSet<Integer>> groups = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			List<Integer> group = Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());
			groups.add(new TreeSet<>(group));
		}

		while (mergeGroup(groups)) {}

		System.out.println(groups);
	}

}
