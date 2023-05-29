package com.timberliu.algorithm.company.hw.volume_b.dfs_bfs.new_no991_1_directorySize;

import java.util.*;

/**
 * 文件目录大小
 *
 * @author liujie
 * @date 2023/5/29
 */

public class Solution1 {

	public static int directorySize(Map<Integer, Integer> sizeMap, Map<Integer, List<Integer>> subDirectoryMap, int targetId) {
		int res = sizeMap.getOrDefault(targetId, 0);
		List<Integer> subDirectoryIds = subDirectoryMap.get(targetId);
		for (Integer subDirectoryId : subDirectoryIds) {
			res += directorySize(sizeMap, subDirectoryMap, subDirectoryId);
		}
		return res;
	}

	/*
	 * 3 1
	 * 3 15 ()
	 * 1 20 (2)
	 * 2 10 (3)
	 */
	/**
	 * 4 2
	 * 4 20 ()
	 * 5 30 ()
	 * 2 10 (4,5)
	 * 1 40 ()
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		scanner.nextLine();
		Map<Integer, Integer> sizeMap = new HashMap<>();
		Map<Integer, List<Integer>> subDireMap = new HashMap<>();
		for (int i = 0; i < m; i++) {
			String[] splits = scanner.nextLine().split(" ");
			int id = Integer.parseInt(splits[0]);
			int size = Integer.parseInt(splits[1]);
			sizeMap.put(id, size);
			String substring = splits[2].substring(1, splits[2].length() - 1);
			String[] subIdStrs = substring.split(",");
			List<Integer> subIds = new ArrayList<>();
			for (String subIdStr : subIdStrs) {
				if (subIdStr.isEmpty()) {
					continue;
				}
				subIds.add(Integer.parseInt(subIdStr));
			}
			subDireMap.put(id, subIds);
		}

		int res = directorySize(sizeMap, subDireMap, n);
		System.out.println(res);
	}

}
