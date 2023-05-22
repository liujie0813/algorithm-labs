package com.timberliu.algorithm.company.hw.volume_a.graph.no089_2_minCost;

import java.util.*;

/**
 * 89. 最优高铁城市修建方案
 *
 *  图论 - 最小生成树（Kruskal 算法）
 *
 * @author liujie
 * @date 2023/4/19
 */

public class Solution1 {

	public static class UnionFind {
		int[] node;
		int count;
		public UnionFind(int n) {
			this.node = new int[n];
			for (int i = 0; i < n; i++) {
				node[i] = i;
			}
			this.count = n;
		}
		public int find(int p) {
			while (p != node[p]) {
				p = node[p];
			}
			return p;
		}
		public void union(int p, int q) {
			int pNode = find(p);
			int qNode = find(q);
			if (pNode != qNode) {
				node[pNode] = qNode;
			}
			count--;
		}
		public boolean isConnected(int p, int q) {
			return find(p) == find(q);
		}
	}

	public static int minCost(int cityNum, int[][] costArr, int[][] mustBuildCityArr) {
		int minCost = 0;
		Map<String, Integer> costMap = new HashMap<>();
		for (int[] cost : costArr) {
			String key = cost[0] < cost[1] ? cost[0] + "_" + cost[1] : cost[1] + "_" + cost[0];
			costMap.put(key, cost[2]);
		}

		UnionFind unionFind = new UnionFind(cityNum);
		for (int[] city : mustBuildCityArr) {
			String key = city[0] < city[1] ? city[0] + "_" + city[1] : city[1] + "_" + city[0];
			minCost += costMap.get(key);
			unionFind.union(city[0], city[1]);
		}

		if (unionFind.count == 1) {
			return minCost;
		}

		Arrays.sort(costArr, Comparator.comparingInt(a -> a[2]));
		for (int[] cost : costArr) {
			if (!unionFind.isConnected(cost[0], cost[1])) {
				unionFind.union(cost[0], cost[1]);
				minCost += cost[2];
			}
			if (unionFind.count == 1) {
				break;
			}
		}

		if (unionFind.count > 1) {
			return -1;
		}
		return minCost;
	}

	/**
	 *  3
	 *
	 *      1  2  3
	 *  1      10 100
	 *  2         50
	 *  3
	 *
	 *  1 3
	 *
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cityNum = scanner.nextInt();
		int costListNum = scanner.nextInt();
		int mustBuildCityNum = scanner.nextInt();
		int[][] costArr = new int[costListNum][3];
		for (int i = 0; i < costListNum; i++) {
			costArr[i][0] = scanner.nextInt();
			costArr[i][1] = scanner.nextInt();
			costArr[i][2] = scanner.nextInt();
		}
		int[][] mustBuildCityArr = new int[mustBuildCityNum][2];
		for (int i = 0; i < mustBuildCityNum; i++) {
			mustBuildCityArr[i][0] = scanner.nextInt();
			mustBuildCityArr[i][1] = scanner.nextInt();
		}

		int res = minCost(cityNum, costArr, mustBuildCityArr);
		System.out.println(res);
	}

}
