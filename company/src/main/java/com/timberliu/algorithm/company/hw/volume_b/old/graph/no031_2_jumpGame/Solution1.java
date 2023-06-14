package com.timberliu.algorithm.company.hw.volume_b.old.graph.no031_2_jumpGame;

import java.util.*;

/**
 * 31. 跳格子
 *
 * @author liujie
 * @date 2023/6/13
 */

public class Solution1 {

	public static String jumpGame(List<int[]> relations, int n) {
		int[] inDegree = new int[n];
		Map<Integer, List<Integer>> next = new HashMap<>();

		for (int[] relation : relations) {
			int a = relation[0], b = relation[1];
			inDegree[b]++;
			List<Integer> list = next.computeIfAbsent(a, (v) -> new ArrayList<>());
			list.add(b);
		}

		Deque<Integer> stack = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (inDegree[i] == 0) {
				stack.add(i);
			}
		}

		int count = 0;
		while (!stack.isEmpty()) {
			Integer top = stack.pop();
			count++;
			if (next.containsKey(top)) {
				for (Integer a : next.get(top)) {
					if (--inDegree[a] == 0) {
						stack.add(a);
					}
				}
			}
		}
		return count == n ? "yes" : "no";
	}

	/**
	 * 3
	 * 0 1
	 * 0 2
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());

		List<int[]> relations = new ArrayList<>();
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (line.isEmpty()) {
				return;
			}
			String[] splits = line.split(" ");
			relations.add(new int[]{Integer.parseInt(splits[0]), Integer.parseInt(splits[1])});
		}

		String res = jumpGame(relations, n);
		System.out.println(res);
	}

}
