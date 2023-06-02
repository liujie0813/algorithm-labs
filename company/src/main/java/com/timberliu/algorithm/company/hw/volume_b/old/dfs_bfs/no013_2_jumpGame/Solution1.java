package com.timberliu.algorithm.company.hw.volume_b.old.dfs_bfs.no013_2_jumpGame;

import java.util.*;

/**
 * 13. 跳格子游戏
 * 
 * @author liujie
 * @date 2023/6/2
 */

public class Solution1 {

	public static String jumpGame(List<int[]> steps, int n) {
		Set<Integer> curOpen = new HashSet<>();
		for (int i = 0; i < n; i++) {
			curOpen.add(i);
		}

		Map<Integer, List<Integer>> canOpen = new HashMap<>();
		for (int[] step : steps) {
			List<Integer> list = canOpen.computeIfAbsent(step[0], (val) -> new ArrayList<>());
			list.add(step[1]);
			curOpen.remove(step[1]);
		}

		for (int i = 0; i < n; i++) {
			if (curOpen.contains(i) && isPassed(i, curOpen, canOpen, new boolean[n], n)) {
				return "yes";
			}
		}
		return "no";
	}

	private static boolean isPassed(int cur, Set<Integer> curOpen, Map<Integer, List<Integer>> canOpen, boolean[] visited, int needVisit) {
		visited[cur] = true;
		needVisit--;
		if (needVisit <= 0) {
			return true;
		}

		if (canOpen.containsKey(cur)) {
			curOpen.addAll(canOpen.get(cur));
		}
		for (Integer next : curOpen) {
			if (cur != next && !visited[next] && isPassed(next, curOpen, canOpen, visited, needVisit)) {
				return true;
			}
		}
		return false;
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
