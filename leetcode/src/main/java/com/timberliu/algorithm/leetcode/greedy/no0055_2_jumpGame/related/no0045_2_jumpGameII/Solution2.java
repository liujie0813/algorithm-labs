package com.timberliu.algorithm.leetcode.greedy.no0055_2_jumpGame.related.no0045_2_jumpGameII;

/**
 * 45. 跳跃游戏 II
 *
 *  贪心
 *    局部最优：当前可移动范围内尽可能多走，如果还没到终点，则步数再加一
 *
 *   需要统计两个覆盖范围：当前这一步的最大覆盖和下一步的最大覆盖
 *    如果到达了当前这一步的最大覆盖距离了，还没有到终点，就要再走一步，直到覆盖了终点
 *
 * @author Timber
 * @date 2021/10/18
 */
public class Solution2 {

	public int jump1(int[] nums) {
		int res = 0;
		int curInstance = 0;
		int nextInstance = 0;
		for (int i = 0; i < nums.length; i++) {
			// 更新下一步最大覆盖范围
			nextInstance = Math.max(nums[i] + i, nextInstance);
			if (i == curInstance) {
				if (curInstance == nums.length - 1) {
					// 当前最大覆盖到终点了，不需要 res++
					break;
				}
				// 更新当前最大覆盖范围
				curInstance = nextInstance;
				res++;
			}
		}
		return res;
	}

	public int jump2(int[] nums) {
		int res = 0;
		int curInstance = 0;
		int nextInstance = 0;
		// i 只移动到 nums.length - 1
		for (int i = 0; i < nums.length - 1; i++) {
			// 更新下一步最大覆盖范围
			nextInstance = Math.max(nums[i] + i, nextInstance);
			if (i == curInstance) {
				// 到达最大覆盖范围
				curInstance = nextInstance;
				res++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/jump-game-ii/ -----");
		Solution2 solution1 = new Solution2();
		System.out.println("----- 1 -----");
		System.out.println(solution1.jump2(new int[]{2, 3, 1, 1, 4}));

		System.out.println("----- 2 -----");
		System.out.println(solution1.jump2(new int[]{2, 3, 0, 1, 4}));

	}

}
