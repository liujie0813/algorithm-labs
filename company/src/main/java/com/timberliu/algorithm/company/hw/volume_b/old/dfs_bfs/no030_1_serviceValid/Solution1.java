package com.timberliu.algorithm.company.hw.volume_b.old.dfs_bfs.no030_1_serviceValid;

import java.util.*;

/**
 * 30. 服务失效判断
 *
 *  给定服务依赖关系列表、服务失效列表
 *  返回正常工作的服务列表
 *
 * @author liujie
 * @date 2023/6/6
 */

public class Solution1 {

	public static String serviceIsValid(String[][] dependencies, String[] fails) {
		Map<String, Set<String>> next = new HashMap<>();
		Map<String, Integer> firstMap = new HashMap<>();
		for (int i = 0; i < dependencies.length; i++) {
			String first = dependencies[i][0];
			String second = dependencies[i][1];
			Set<String> set = next.computeIfAbsent(second, (val) -> new HashSet<>());
			set.add(first);
			firstMap.putIfAbsent(first, i);
			firstMap.putIfAbsent(second, i);
		}

		for (String fail : fails) {
			remove(next, fail);
		}
		String[] res = next.keySet().toArray(new String[0]);
		if (res.length == 0) {
			return ",";
		}
		Arrays.sort(res, Comparator.comparingInt(firstMap::get));

		StringJoiner stringJoiner = new StringJoiner(",");
		for (String a : res) {
			stringJoiner.add(a);
		}
		return stringJoiner.toString();
	}

	private static void remove(Map<String, Set<String>> next, String s) {
		if (next.containsKey(s)) {
			Set<String> needRemove = next.get(s);
			next.remove(s);
			for (String sub : needRemove) {
				remove(next, sub);
			}
		}
	}

	/**
	 * a1-a2,a5-a6,a2-a3
	 * a5,a2
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] firsts = scanner.nextLine().split(",");
		String[][] dependencies = new String[firsts.length][2];
		for (int i = 0; i < firsts.length; i++) {
			String[] a = firsts[i].split("-");
			dependencies[i] = a;
		}
		String[] seconds = scanner.nextLine().split(",");

		String res = serviceIsValid(dependencies, seconds);
		System.out.println(res);
	}

}
