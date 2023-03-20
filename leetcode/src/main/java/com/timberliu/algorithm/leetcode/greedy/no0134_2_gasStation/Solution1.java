package com.timberliu.algorithm.leetcode.greedy.no0134_2_gasStation;

/**
 * 134. 加油站
 *
 *  gas =  [1,2,3,4,5]
 *  cost = [3,4,5,1,2]
 *
 *  暴力解法
 */

public class Solution1 {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
    	// 依次遍历从各个 i 出发
		for (int i = 0; i < cost.length; i++) {
			// 记录剩余油量
			int rest = gas[i] - cost[i];
			int index = (i + 1) % cost.length;
			// 模拟从 i 出发
			while (rest > 0 && index != i) {
				rest += gas[index] - cost[index];
				index = (index + 1) % cost.length;
			}
			// 如果循环一遍，且剩余油量 >= 0
			if (rest >= 0 && index == i) {
				return i;
			}
		}
		return -1;
    }

    public static void main(String[] args) {
		int res1 = canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
		System.out.println(res1);

	}

}