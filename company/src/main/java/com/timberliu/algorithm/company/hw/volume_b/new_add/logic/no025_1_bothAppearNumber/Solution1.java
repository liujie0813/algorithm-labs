package com.timberliu.algorithm.company.hw.volume_b.new_add.logic.no025_1_bothAppearNumber;

import java.util.*;

/**
 * 25. 找出两个整数数组中同时出现的整数
 *
 * @author liujie
 * @date 2023/5/31
 */

public class Solution1 {

	public static String bothAppearNumber(int[] first, int[] second) {
		Map<Integer, Integer> firstMap = new HashMap<>();
		for (int a : first) {
			firstMap.put(a, firstMap.getOrDefault(a, 0) + 1);
		}
		Map<Integer, Integer> secondMap = new HashMap<>();
		for (int a : second) {
			secondMap.put(a, secondMap.getOrDefault(a, 0) + 1);
		}

		Map<Integer, TreeSet<Integer>> map = new TreeMap<>();
		for (Map.Entry<Integer, Integer> entry : firstMap.entrySet()) {
			Integer firstCnt = entry.getValue();
			Integer secondCnt = secondMap.get(entry.getKey());
			if (secondCnt == null) {
				continue;
			}
			int cnt = firstCnt < secondCnt ? firstCnt : secondCnt;
			Set<Integer> set = map.computeIfAbsent(cnt, (a) -> new TreeSet<>());
			set.add(entry.getKey());
		}
		if (map.isEmpty()) {
			return "NULL";
		}
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Integer, TreeSet<Integer>> entry : map.entrySet()) {
			sb.append(entry.getKey()).append(":");
			for (Integer val : entry.getValue()) {
				sb.append(val).append(",");
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append("\n");
		}
		return sb.toString();
	}

	/*
	 * 5,3,6,-8,0,11
	 * 2,8,8,8,-1,15
	 */
	/**
	 * 5,8,11,3,6,8,8,-1,11,2,11,11
	 * 11,2,11,8,6,8,8,-1,8,15,3,-9,11
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] firstSplits = scanner.nextLine().split(",");
		String[] secondSplits = scanner.nextLine().split(",");
		int[] first = new int[firstSplits.length];
		for (int i = 0; i < firstSplits.length; i++) {
			first[i] = Integer.parseInt(firstSplits[i]);
		}
		int[] second = new int[secondSplits.length];
		for (int i = 0; i < secondSplits.length; i++) {
			second[i] = Integer.parseInt(secondSplits[i]);
		}

		String res = bothAppearNumber(first, second);
		System.out.println(res);
	}

}
