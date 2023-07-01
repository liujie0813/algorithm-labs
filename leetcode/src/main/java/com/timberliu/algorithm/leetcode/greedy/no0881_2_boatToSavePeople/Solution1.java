package com.timberliu.algorithm.leetcode.greedy.no0881_2_boatToSavePeople;

import java.util.Arrays;

/**
 * 881. 救生艇
 *
 * @author Timber
 * @date 2023/7/1
 */
public class Solution1 {

	public static int numRescueBoats(int[] people, int limit) {
		Arrays.sort(people);
		int res = 0;
		int left = 0, right = people.length - 1;
		while (left < right) {
			if (people[left] + people[right] <= limit) {
				res++;
				left++;
				right--;
			} else {
				res++;
				right--;
			}
		}
		return left == right ? res + 1 : res;
	}

	public static void main(String[] args) {
		int[] arr1 = {3, 2, 2, 1};
		int res1 = numRescueBoats(arr1, 3);
		System.out.println(res1);
	}

}
