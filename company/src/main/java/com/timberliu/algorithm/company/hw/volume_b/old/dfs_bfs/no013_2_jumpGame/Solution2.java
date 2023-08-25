package com.timberliu.algorithm.company.hw.volume_b.old.dfs_bfs.no013_2_jumpGame;

import java.util.*;

/**
 * 13. 跳格子游戏
 * 
 * @author liujie
 * @date 2023/6/2
 */

public class Solution2 {

	public static String jumpGame(List<int[]> steps, int n) {
		int[] inDegree = new int[n];
		Map<Integer, List<Integer>> next = new HashMap<>();

		for (int[] step : steps) {
			int a = step[0], b = step[1];
			inDegree[b]++;
			List<Integer> list = next.computeIfAbsent(a, (val) -> new ArrayList<>());
			list.add(b);
		}

		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (inDegree[i] == 0) {
				deque.add(i);
			}
		}

		int count = 0;
		while (!deque.isEmpty()) {
			Integer a = deque.poll();
			count++;

			if (next.containsKey(a)) {
				for (Integer b : next.get(a)) {
					--inDegree[b];
					if (inDegree[b] == 0) {
						deque.add(b);
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
	/**
	 * 2
	 * 1 0
	 * 0 1
	 */
	/**
	 * 6
	 * 0 1
	 * 0 2
	 * 0 3
	 * 0 4
	 * 0 5
	 */
	/**
	 * 5
	 * 4 3
	 * 0 4
	 * 2 1
	 * 3 2
	 */
	/**
	 * 4
	 * 1 2
	 * 1 0
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		List<int[]> list = new ArrayList<>();
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (line.isEmpty()) {
				break;
			} else {
				String[] splits = line.split(" ");
				list.add(new int[]{Integer.parseInt(splits[0]), Integer.parseInt(splits[1])});
			}
		}

		String res = jumpGame(list, n);
		System.out.println(res);
	}

}
