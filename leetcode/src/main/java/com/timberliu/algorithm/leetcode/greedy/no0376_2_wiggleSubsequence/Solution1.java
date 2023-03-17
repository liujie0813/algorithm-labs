package com.timberliu.algorithm.leetcode.greedy.no0376_2_wiggleSubsequence;

/**
 * 376. 摆动序列
 *
 *  连续数字之间的差严格地在正数和负数之间交替，摆动序列
 *    第一个差可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列
 *
 *  贪心：只统计坡顶/坡谷的数量
 *    prediff = num[i] - nums[i-1] 、curdiff = nums[i+1] - nums[i]
 *    坡谷：prediff < 0 && curdiff > 0   ||   坡顶：prediff > 0 && curdiff < 0
 *
 *  特殊情况：
 *    1. 平坡： 3 \       / 3          2-2-2-2
 *                2-2-2-2          1 /       \ 1
 *    	   要不删除左边的三个 2，只统计右边的峰值        prediff = 0 && curdiff > 0  ||   prediff = 0 && curdiff < 0
 *    	   要不删除右边的三个 2，只统计左边的峰值
 *
 *    2. 数字首尾两端
 *                                                     result = 1，记录了最右边的峰值
 *         假设最左边是平坡，prediff = 0 && curdiff >< 0，result++（记录了最左边的峰值）
 *
 *    3. 单调有平坡
 *         单调中的平坡不能算摆动，可以只在 坡度 发生变化时，才更新 prediff
 *
 */

public class Solution1 {

    public static int wiggleMaxLength(int[] nums) {
    	if (nums.length <= 1) {
    		return nums.length;
		}
    	int prediff = 0, curdiff = 0;
    	int result = 1;
		for (int i = 0; i < nums.length - 1; i++) {
			curdiff = nums[i + 1] - nums[i];
			if ((prediff <= 0 && curdiff > 0) || (prediff >= 0 && curdiff < 0)) {
				result++;
				prediff = curdiff;
			}
		}
		return result;
    }

    public static void main(String[] args) {
		int res1 = wiggleMaxLength(new int[]{1,7,4,9,2,5});
		System.out.println(res1);

		int res2 = wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8});
		System.out.println(res2);

		int res3 = wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9});
		System.out.println(res3);

	}

}