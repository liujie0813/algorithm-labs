package com.timberliu.algorithm.company.hw.no093_1_notPassPackage;

import com.timberliu.algorithm.company.utils.PrintUtils;

import java.util.*;

/**
 * 93. 快递投放问题
 *
 * @author liujie
 * @date 2023/4/18
 */

public class Solution1 {

	public static List<String> findNotPassPackage(List<List<String>> packages, List<List<String>> roads) {
		Map<String, Set<String>> pkgMap = new HashMap<>();
		for (List<String> pkg : packages) {
			String path = pkg.get(1) + "-" + pkg.get(2);
			Set<String> set = pkgMap.computeIfAbsent(path, (val) -> new HashSet<>());
			set.add(pkg.get(0));
		}

		Map<String, Set<String>> roadMap = new HashMap<>();
		for (List<String> road : roads) {
			String path = road.get(0) + "-" + road.get(1);
			Set<String> set = roadMap.computeIfAbsent(path, (val) -> new HashSet<>());
			set.addAll(road.subList(2, road.size()));
		}

		List<String> res = new ArrayList<>();
		for (String path : pkgMap.keySet()) {
			Set<String> pkgs = pkgMap.get(path);
			Set<String> noPassPkgs = roadMap.get(path);
			if (noPassPkgs == null) {
				continue;
			}
			for (String pkg : noPassPkgs) {
				if (pkgs.contains(pkg)) {
					res.add(pkg);
				}
			}
		}

		res.sort(Comparator.comparingInt(a -> a.charAt(7)));
		return res;
	}

	public static List<String> findNotPassPackage1(List<List<String>> packages, List<List<String>> roads) {
		Map<String, Set<String>> pkgMap = new HashMap<>();
		for (List<String> pkg : packages) {
			String path = pkg.get(1) + "-" + pkg.get(2);
			Set<String> set = pkgMap.computeIfAbsent(path, (val) -> new HashSet<>());
			set.add(pkg.get(0));
		}

		List<String> res = new ArrayList<>();
		for (List<String> road : roads) {
			String path = road.get(0) + "-" + road.get(1);
			if (!pkgMap.containsKey(path)) {
				continue;
			}
			Set<String> set = pkgMap.get(path);
			for (int i = 2; i < road.size(); i++) {
				String pkg = road.get(i);
				if (set.contains(pkg)) {
					res.add(pkg);
				}
			}
		}

		res.sort(Comparator.comparingInt(a -> a.charAt(7)));
		return res;
	}

	/**
	 * 4 2
	 * package1 A C
	 * package2 A C
	 * package3 B C
	 * package4 A C
	 * A B package1
	 * A C package2 package1
	 *
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] firstLine = scanner.nextLine().split(" ");
		int m = Integer.parseInt(firstLine[0]);
		int n = Integer.parseInt(firstLine[1]);
		List<List<String>> packages = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			String[] strs = scanner.nextLine().split(" ");
			packages.add(Arrays.asList(strs));
		}
		List<List<String>> roads = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String[] strs = scanner.nextLine().split(" ");
			roads.add(Arrays.asList(strs));
		}

		List<String> res = findNotPassPackage1(packages, roads);
		if (res.isEmpty()) {
			System.out.println("none");
		} else {
			PrintUtils.printListString(res);
		}
	}

}
