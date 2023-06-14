package com.timberliu.algorithm.company.hw.exercise.no01.no007_matchScore;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liujie
 * @date 2023/6/14
 */

public class Solution1 {

	public static List<Integer> matchScore(int n, int[] ids, int[] scores) {
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int id = ids[i];
			int score = scores[i];
			PriorityQueue<Integer> queue = map.computeIfAbsent(id, (val) -> new PriorityQueue<>());
			queue.offer(score);
		}

		List<int[]> list = new ArrayList<>();
		for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
			if (entry.getValue().size() < 3) {
				continue;
			}
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += entry.getValue().poll();
			}
			list.add(new int[]{entry.getKey(), sum});
		}

		list.sort((a, b) -> {
			if (a[1] == b[1]) {
				return b[0] - a[0];
			}
			return b[1] - a[1];
		});
		return list.stream().map(a -> a[0]).collect(Collectors.toList());
	}

	/**
	 * 13
	 * 3,3,7,4,4,4,4,7,7,3,5,5,5
	 * 53,80,68,24,39,76,66,16,100,55,53,80,55
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		String[] idStrs = scanner.nextLine().split(",");
		int[] ids = new int[n];
		for (int i = 0; i < n; i++) {
			ids[i] = Integer.parseInt(idStrs[i]);
		}
		String[] scoreStrs = scanner.nextLine().split(",");
		int[] scores = new int[n];
		for (int i = 0; i < n; i++) {
			scores[i] = Integer.parseInt(scoreStrs[i]);
		}

		List<Integer> res = matchScore(n, ids, scores);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i));
			if (i < res.size() - 1) {
				System.out.print(",");
			}
		}
	}

}
