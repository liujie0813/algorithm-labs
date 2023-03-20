package com.timberliu.algorithm.leetcode.greedy.no0860_1_lemonadeChange;

/**
 * 860. 柠檬水找零
 *
 *  每杯柠檬水 5 美元，bills[i] 为购买顺序，是否能正确找零
 *
 *  贪心
 *    5：记录一下 5 元数量
 *    10：记录一下 5/10 元数量，只能找零 5 元
 *    20：优先找零 10 元
 */
public class Solution1 {

    public static boolean lemonadeChange(int[] bills) {
		int num5 = 0;
		int num10 = 0;
		for (int i = 0; i < bills.length; i++) {
			if (bills[i] == 5) {
				num5++;
			} else if (bills[i] == 10) {
				if (num5 < 1) {
					return false;
				}
				num5--;
				num10++;
			} else if (bills[i] == 20) {
				if (num10 > 0 && num5 > 0) {
					num5--;
					num10--;
				} else if (num5 > 2) {
					num5 -= 3;
				} else {
					return false;
				}
			}
		}
		return true;
    }

    public static void main(String[] args) {
		boolean res1 = lemonadeChange(new int[]{5, 5, 10, 10, 20});
		System.out.println(res1);

		boolean res2 = lemonadeChange(new int[]{5, 5, 5, 10, 20});
		System.out.println(res2);

		boolean res3 = lemonadeChange(new int[]{5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5});
		System.out.println(res3);
	}

}