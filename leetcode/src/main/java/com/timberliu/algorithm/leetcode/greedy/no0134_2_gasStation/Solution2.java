package com.timberliu.algorithm.leetcode.greedy.no0134_2_gasStation;

/**
 * 134. 加油站
 *
 *  gas =  [1,2,3,4,5]
 *  cost = [3,4,5,1,2]
 *
 *  贪心
 *    局部最优：当前累加 rest[i] 的总和 curSum 一旦小于 0，说明 [0, i] 都不能作为起始位置，
 *    		到 i 位置处都会断油，所以起始位置至少是 i+1
 *
 *    每个加油站的剩余油量为 rest[i] = gas[i] - cost[i]
 *    如果所有加油站的剩余油量和 大于等于 0，那么一定可以跑完一圈
 */

public class Solution2 {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
		int curSum = 0;
		int totalSum = 0;
		int start = 0;
		for (int i = 0; i < gas.length; i++) {
			curSum += gas[i] - cost[i];
			totalSum += gas[i] - cost[i];
			if (curSum < 0) {
				start = i + 1;
				curSum = 0;
			}
		}
		if (totalSum < 0) {
			return -1;
		}
		return start;
    }

    public static void main(String[] args) {
		int res1 = canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
		System.out.println(res1);
		
	}

}