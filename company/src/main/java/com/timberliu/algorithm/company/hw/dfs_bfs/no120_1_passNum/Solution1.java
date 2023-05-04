package com.timberliu.algorithm.company.hw.dfs_bfs.no120_1_passNum;

import com.timberliu.algorithm.company.utils.PrintUtils;

import java.util.*;

/**
 * 120. 超级玛丽过吊桥
 *
 * @author liujie
 * @date 2023/4/28
 */

public class Solution1 {

	public static int[] steps = {1, 2, 3};

	public static int passNum(int len, int life, Set<Integer> loss) {
		return dfs(0, len, life, new ArrayList<>(), loss);
	}

	private static int dfs(int cur, int len, int life, List<Integer> path, Set<Integer> loss) {
		if (life == 0) {
			return 0;
		}
		if (cur >= len + 1) {
			PrintUtils.printListIntegerV2(path);
			return 1;
		}
		path.add(cur);
		int count = 0;
		for (int step : steps) {
			int next = cur + step;
			if (loss.contains(next)) {
				count += dfs(next, len, life - 1, path, loss);
			} else {
				count += dfs(next, len, life, path, loss);
			}
		}
		return count;
	}

	/**
	 * 2 2 1
	 * 2
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int life = scanner.nextInt();
		int len = scanner.nextInt();
		int k = scanner.nextInt();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < k; i++) {
			set.add(scanner.nextInt());
		}

		int res = passNum(len, life, set);
		System.out.println(res);
	}

}
