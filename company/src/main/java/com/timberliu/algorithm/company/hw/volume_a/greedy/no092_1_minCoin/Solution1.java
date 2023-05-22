package com.timberliu.algorithm.company.hw.volume_a.greedy.no092_1_minCoin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 92. 静态扫描
 *
 *  贪心：
 *    对于每种文件：
 *     1. 扫描n次
 *     2. 扫描1次并缓存
 *    取较小者
 *
 * @author liujie
 * @date 2023/4/18
 */

public class Solution1 {

	public static int minCoin(List<Integer> fileIds, List<Integer> fileSizes, int m) {
		Map<Integer, Integer> cntMap = new HashMap<>();
		Map<Integer, Integer> costMap = new HashMap<>();
		for (int i = 0; i < fileIds.size(); i++) {
			Integer fileId = fileIds.get(i);
			Integer fileSize = fileSizes.get(i);
			cntMap.put(fileId, cntMap.getOrDefault(fileId, 0) + 1);
			costMap.putIfAbsent(fileId, fileSize);
		}

		int res = 0;
		for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
			Integer fileId = entry.getKey();
			Integer fileCnt = entry.getValue();
			Integer fileCost = costMap.get(fileId);
			res += Math.min(fileCnt * fileCost, fileCost + m);
		}
		return res;
	}

	/**
	 * 5
	 * 1 2 2 2 2 1 2 3 4
	 * 2 3 3 3 3 2 3 4 5
	 *
	 * 1 2    4
	 * 2 4    3+5
	 * 3 1    4
	 * 4 1    5
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		scanner.nextLine();
		String[] second = scanner.nextLine().split(" ");
		List<Integer> fileIds = Stream.of(second).map(Integer::parseInt).collect(Collectors.toList());

		String[] third = scanner.nextLine().split(" ");
		List<Integer> fileSizes = Stream.of(third).map(Integer::parseInt).collect(Collectors.toList());

		int res = minCoin(fileIds, fileSizes, m);
		System.out.println(res);
	}

}
