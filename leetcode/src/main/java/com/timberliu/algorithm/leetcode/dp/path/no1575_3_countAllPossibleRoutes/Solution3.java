package com.timberliu.algorithm.leetcode.dp.path.no1575_3_countAllPossibleRoutes;

/**
 * 1575. 统计所有可行路径
 *
 *  动态规划
 *    1. 状态定义
 *       f[i][fuel] 表示：从位置 i 出发，剩余油量为 fuel 时，到达目标位置的 [路径数量]
 *    2. 状态转义方程
 *       f[i][fuel] = ∑ f[k][fuel-need]
 *       k：表示 位置 i 油量 fuel 的状态时，枚举的 下一个位置
 *       need：表示 从位置 i 到 k 需要的油量
 *
 *       f[i][fuel] 依赖于  f[k][fuel-need]，所以油量少的必须都先计算了
 *
 * @author liujie
 * @date 2021/10/13
 */
public class Solution3 {

	int mod = 1000000007;

	public int countRoutes(int[] locations, int start, int finish, int fuel) {
		int[][] cache = new int[locations.length][fuel + 1];
		for (int i = 0; i <= fuel; i++) {
			cache[finish][i] = 1;
		}

		for (int retainFuel = 0; retainFuel <= fuel; retainFuel++) {
			for (int i = 0; i < locations.length; i++) {
				for (int next = 0; next < locations.length; next++) {
					if (i != next) {
						int need = Math.abs(locations[i] - locations[next]);
						if (retainFuel >= need) {
							cache[i][retainFuel] += cache[next][retainFuel - need];
							cache[i][retainFuel] %= mod;
						}
					}
				}
			}
		}
		return cache[start][fuel];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/count-all-possible-routes/ -----");
		Solution3 solution3 = new Solution3();
		System.out.println("----- 1 -----");
		int i1 = solution3.countRoutes(new int[]{2, 3, 6, 8, 4}, 1, 3, 5);
		System.out.println(i1);

		System.out.println("----- 2 -----");
		int i2 = solution3.countRoutes(new int[]{4, 3, 1}, 1, 0, 6);
		System.out.println(i2);

		System.out.println("----- 3-----");
		int i3 = solution3.countRoutes(new int[]{5, 2, 1}, 0, 2, 3);
		System.out.println(i3);

		System.out.println("----- 4-----");
		int i4 = solution3.countRoutes(new int[]{1, 2, 3}, 0, 2, 40);
		System.out.println(i4);

	}

}
